package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.domain.Booking;
import nl.novi.clemens.bgbbackend.domain.BookingLine;
import nl.novi.clemens.bgbbackend.domain.Guest;
import nl.novi.clemens.bgbbackend.domain.Playroom;
import nl.novi.clemens.bgbbackend.domain.enums.ETimeslot;
import nl.novi.clemens.bgbbackend.payload.request.AvailableTimeSlotRequest;
import nl.novi.clemens.bgbbackend.payload.request.BookingRequest;
import nl.novi.clemens.bgbbackend.payload.request.GuestlistRequest;
import nl.novi.clemens.bgbbackend.payload.response.AllBookingResponse;
import nl.novi.clemens.bgbbackend.payload.response.AvailableTimeSlotsResponse;
import nl.novi.clemens.bgbbackend.payload.response.BookingLineResponse;
import nl.novi.clemens.bgbbackend.payload.response.BookingResponse;
import nl.novi.clemens.bgbbackend.payload.response.GLGuestlistResponse;
import nl.novi.clemens.bgbbackend.payload.response.GLPlayroomResponse;
import nl.novi.clemens.bgbbackend.payload.response.GLTimeslotResponse;
import nl.novi.clemens.bgbbackend.payload.response.GuestlistResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import nl.novi.clemens.bgbbackend.repository.BookingLineRepository;
import nl.novi.clemens.bgbbackend.repository.BookingRepository;
import nl.novi.clemens.bgbbackend.repository.GuestRepository;
import nl.novi.clemens.bgbbackend.repository.PlayroomRepository;
import nl.novi.clemens.bgbbackend.repository.ProductRepository;
import nl.novi.clemens.bgbbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BookingLineRepository bookingLineRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    PlayroomRepository playroomRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @Transactional
    @Override
    public ResponseEntity<MessageResponse> postBooking(@Valid BookingRequest bookingRequest){


        // Check if unique
        if (bookingRepository.existsByName(bookingRequest.getName())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "Booking name already exists.");
        }

        if (!playroomRepository.existsById(bookingRequest.getPlayroomid())){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Given playroom id is unknown.");
        }

        // Check if available
        List<Booking> existingBookings = bookingRepository.findAll();

        for (int i = 0; i < existingBookings.size(); i++) {
            if (bookingRequest.getBookingdate().isEqual(existingBookings.get(i).getBookingdate())
                    && existingBookings.get(i).getCancelled().equals(false)){
                if (0 == bookingRequest.getTimeslot().compareTo(existingBookings.get(i).getTimeslot())){
                    throw new ResponseStatusException(
                            HttpStatus.NOT_ACCEPTABLE, "There already is a booking on this timeslot and day.");
                }
            }
        }

        // Get current username to promise User to booking consturctor instead of Optional User.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        // Set Booking level
        // Connect playroom
        Booking booking = new Booking(
                bookingRequest.getName(),
                bookingRequest.getBookingdate(),
                bookingRequest.getTimeslot(),
                false,
                userRepository.findByUsername(currentPrincipalName)
        );

        // Connect playroom
        Playroom playroom = playroomRepository.findByPlayroomid(bookingRequest.getPlayroomid());
        booking.setPlayroom(playroom);

        bookingRepository.save(booking);

        // Set Guest level and connect to booking
        List<Guest> guests = new ArrayList<Guest>();

        for (int i = 0; i < bookingRequest.getGuestsrequests().length; i++) {
            Guest guest = new Guest(
                    bookingRequest.getGuestsrequests()[i].getName(),
                    bookingRequest.getGuestsrequests()[i].getPhonenumber(),
                    booking
            );
            guests.add(guest);
            guestRepository.save(guest);
        }

        // Set BookingLine level
        List<BookingLine> bookingLines = new ArrayList<BookingLine>();

        for (int i = 0; i < bookingRequest.getBookinglines().length; i++) {
            BookingLine bookingLine = new BookingLine(
                    bookingRequest.getBookinglines()[i].getNumberofitems(),
                    productRepository.findByProductid(bookingRequest.getBookinglines()[i].getProductid()),
                    booking
            );
            bookingLines.add(bookingLine);
            bookingLineRepository.save(bookingLine);
        }

        // Connect already saved booking itterated saves of bookinglines and guests.
        Booking bookingToUpdate = bookingRepository.findByName(bookingRequest.getName());
        bookingToUpdate.setBookinglines(bookingLines);
        bookingToUpdate.setGuests(guests);
        bookingRepository.save(bookingToUpdate);

        return ResponseEntity.ok(new MessageResponse("Booking was successful!"));
    }

    @Override
    public ResponseEntity<AllBookingResponse> getAllBookings(){

        // For every booking in findall:
        List<Booking> bookings = bookingRepository.findAll();

        return createAllBookingResponse(bookings);
        }

    @Override
    public ResponseEntity<AllBookingResponse> getAllOwnedBookings(){

        // Get Owned bookings by authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        List<Booking> bookings = bookingRepository.findAllByUser(userRepository.findByUsername(currentPrincipalName));

        return createAllBookingResponse(bookings);
    }

    @Override
    public ResponseEntity<BookingResponse> getBookingById(Long id){
        if (bookingRepository.existsById(id)){
            Booking booking = bookingRepository.findByBookingid(id);

            List<BookingLine> bookingLines = booking.getBookinglines();
            List<BookingLineResponse> bookingLineResponses = new ArrayList<BookingLineResponse>();
            for (int j = 0; j < bookingLines.size(); j++) {
                BookingLineResponse bookingLineResponse = new BookingLineResponse(
                        bookingLines.get(j).getProduct().getName(),
                        (int)bookingLines.get(j).getProduct().getProductid(),
                        bookingLines.get(j).getProduct().getProducttype().getName().name(),
                        bookingLines.get(j).getNumberofItems(),
                        bookingLines.get(j).getProduct().getImage_cover(),
                        bookingLines.get(j).getProduct().getProduct_price()
                );
                //Add to bookinglinelist
                bookingLineResponses.add(bookingLineResponse);
            }
            // Make a bookingresponse
            BookingResponse bookingResponse = new BookingResponse(
                    booking.getName(),
                    booking.getUser().getId(),
                    booking.getUser().getUsername(),
                    booking.getCancelled(),
                    booking.getPlayroom().getRoomNr().name(),
                    booking.getBookingdate().toString(),
                    booking.getTimeslot().name(),
                    booking.getGuests().toArray(new Guest[0]),
                    bookingLineResponses
            );

            return ResponseEntity.ok(bookingResponse);

        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "A matching booking with given id (" + id + ") was not found.");
        }
    }

    @Override
    public ResponseEntity<BookingResponse> getOwnedBookingById(long bookingid){

        // Get current username to promise User to booking consturctor instead of Optional User.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        if (bookingRepository.existsById(bookingid)) {
            if (bookingRepository.findByBookingid(bookingid).getUser().getId() == userRepository.findByUsername(currentPrincipalName).getId()){
                return getBookingById(bookingid);

            } else {
                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED);
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "A matching booking with given id (" + bookingid + ") was not found.");
        }
    }

    @Override
    public ResponseEntity<AvailableTimeSlotsResponse> getAvailableTimeslotsByDay(AvailableTimeSlotRequest availableTimeSlotRequest){

        List<Booking> bookings = bookingRepository.findAll();

        AvailableTimeSlotsResponse availableTimeSlotsResponse = checkTimeslotAvailabilityOnDate(bookings, availableTimeSlotRequest.getBookingdate());

        return ResponseEntity.ok(availableTimeSlotsResponse);
    }

    @Override
    public ResponseEntity<MessageResponse> cancelBookingById(Long bookingid){
        if (bookingRepository.existsById(bookingid)) {
            Booking booking = bookingRepository.findByBookingid(bookingid);

            booking.setCancelled(true);
            bookingRepository.save(booking);

            return ResponseEntity.ok(new MessageResponse("Booking met id: " + bookingid + ", is gecanceled"));
        } else
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Een met booking met id " + bookingid + ", is niet gevonden.");
    }

    @Override
    public ResponseEntity<MessageResponse> cancelOwnedBookingById(Long bookingid){
        if (bookingRepository.existsById(bookingid)){
            Booking booking = bookingRepository.findByBookingid(bookingid);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();

            if (bookingRepository.findByBookingid(bookingid).getUser().getId()
                    == userRepository.findByUsername(currentPrincipalName).getId()){
                booking.setCancelled(true);
                bookingRepository.save(booking);

            } else
                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Een met booking met id " + bookingid + ", is niet gevonden.");
        }
        return ResponseEntity.ok(new MessageResponse("Booking met id: " + bookingid + ", is gecanceled"));
    }

    @Override
    public ResponseEntity<GuestlistResponse> getGuestlistFromDayBasedOnTimeslotsAndRoom(GuestlistRequest guestlistRequest){
        // Creates a guest list per room per timeslot per request date.



        GuestlistResponse guestlistResponse = new GuestlistResponse();
        // Set date for response
        guestlistResponse.setDate(guestlistRequest.getRequestdate());
        guestlistResponse.setGlTimeslotResponseList(new ArrayList<GLTimeslotResponse>());

        List<ETimeslot> eTimeslotList = Arrays.asList(ETimeslot.values());

        // Iterate over all timeslots for given day
        for (ETimeslot eTimeslot : eTimeslotList) {
            GLTimeslotResponse glTimeslotResponse = new GLTimeslotResponse();
            // Set name of timeslot
            glTimeslotResponse.setTimeslot(eTimeslot.name());
            glTimeslotResponse.setGlPlayroomResponses(new ArrayList<GLPlayroomResponse>());

            // Iterate all playrooms for given timeslot
            List<Playroom> playrooms = playroomRepository.findAll();
            for (Playroom playroom : playrooms) {
                GLPlayroomResponse glPlayroomResponse = new GLPlayroomResponse();
                // Set name of playroom
                glPlayroomResponse.setPlayroomname(playroom.getRoomNr().name());
                glPlayroomResponse.setGlGuestlistResponses(new ArrayList<GLGuestlistResponse>());

                // Iterate all booking for given day and check if matches timeslot
                List<Booking> bookings = bookingRepository.findAllByBookingdate(guestlistRequest.getRequestdate());
                for (Booking booking : bookings) {
                    GLGuestlistResponse glGuestlistResponse = new GLGuestlistResponse();
                    // If there is a booking on the timeslot, add bookingid and guest information.
                    if (booking.getTimeslot().equals(eTimeslot)) {

                        glGuestlistResponse.setBookingid(booking.getBookingid());
                        List<Guest> guests = booking.getGuests();

                        // Add to collection of booking/guestlist combination list
                        glPlayroomResponse.getGlGuestlistResponses().add(glGuestlistResponse);
                    }
                }
                glTimeslotResponse.getGlPlayroomResponses().add(glPlayroomResponse);
            }
            guestlistResponse.getGlTimeslotResponseList().add(glTimeslotResponse);
        }
        return ResponseEntity.ok(guestlistResponse);
    }

    // Helper Methods
    public AvailableTimeSlotsResponse checkTimeslotAvailabilityOnDate(List<Booking> bookings, LocalDate date){
        // Checks whats timeslots are available based on existing bookings (Excl. canceled booking)
        AvailableTimeSlotsResponse availableTimeSlotsResponse = new AvailableTimeSlotsResponse(
                true,
                true,
                true,
                true,
                true
        );

        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingdate().isEqual(date) && bookings.get(i).getCancelled().equals(false)) {
                ETimeslot timeslottaken = bookings.get(i).getTimeslot();

                switch (timeslottaken) {
                    case LATE_MORNING:
                        availableTimeSlotsResponse.setLatemorning(false);
                        break;
                    case EARLY_AFTERNOON:
                        availableTimeSlotsResponse.setEarlyafternoon(false);
                        break;
                    case LATE_AFTERNOON:
                        availableTimeSlotsResponse.setLateafternoon(false);
                        break;
                    case EVENING:
                        availableTimeSlotsResponse.setEvening(false);
                        break;
                    case LATE_EVENING:
                        availableTimeSlotsResponse.setLateevening(false);
                        break;
                }
            }
        }
        return availableTimeSlotsResponse;

    }

    public ResponseEntity<AllBookingResponse> createAllBookingResponse(List<Booking> bookingList){
        // Make list for allbookingsresponse
        List<BookingResponse> bookingResponses = new ArrayList<>();

        for (int i = 0; i < bookingList.size(); i++) {
            // Make as many bookinglineresponses as needed
            List<BookingLine> bookingLines = bookingList.get(i).getBookinglines();
            List<BookingLineResponse> bookingLineResponses = new ArrayList<BookingLineResponse>();
            for (int j = 0; j < bookingLines.size(); j++) {
                BookingLineResponse bookingLineResponse = new BookingLineResponse(
                        bookingLines.get(j).getProduct().getName(),
                        (int)bookingLines.get(j).getProduct().getProductid(),
                        bookingLines.get(j).getProduct().getProducttype().getName().name(),
                        bookingLines.get(j).getNumberofItems(),
                        bookingLines.get(j).getProduct().getImage_cover(),
                        bookingLines.get(j).getProduct().getProduct_price()
                );
                //Add to bookinglinelist
                bookingLineResponses.add(bookingLineResponse);
            }
            // Make a bookingresponse
            BookingResponse bookingResponse = new BookingResponse(
                    bookingList.get(i).getName(),
                    bookingList.get(i).getUser().getId(),
                    bookingList.get(i).getUser().getUsername(),
                    bookingList.get(i).getCancelled(),
                    bookingList.get(i).getPlayroom().getRoomNr().name(),
                    bookingList.get(i).getBookingdate().toString(),
                    bookingList.get(i).getTimeslot().name(),
                    bookingList.get(i).getGuests().toArray(new Guest[0]),
                    bookingLineResponses
            );
            // Add Bookingresponse to List
            bookingResponses.add(bookingResponse);
        }

        // Turn list into array for transmitting
        AllBookingResponse allBookingResponse = new AllBookingResponse(
                bookingResponses
        );

        return ResponseEntity.ok(allBookingResponse);
    }
}