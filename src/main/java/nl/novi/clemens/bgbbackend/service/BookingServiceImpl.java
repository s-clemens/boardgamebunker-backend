package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.domain.Booking;
import nl.novi.clemens.bgbbackend.domain.BookingLine;
import nl.novi.clemens.bgbbackend.domain.Guest;
import nl.novi.clemens.bgbbackend.domain.Playroom;
import nl.novi.clemens.bgbbackend.payload.request.BookingRequest;
import nl.novi.clemens.bgbbackend.payload.response.AllBookingResponse;
import nl.novi.clemens.bgbbackend.payload.response.BookingLineResponse;
import nl.novi.clemens.bgbbackend.payload.response.BookingResponse;
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
import java.util.ArrayList;
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

        for (int i = 0; i < bookingRepository.findAll().size(); i++) {
            if (bookingRequest.getBookingdate().isEqual(existingBookings.get(i).getBookingdate())){
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

        // Make list for allbookingsresponse
        List<BookingResponse> bookingResponses = new ArrayList<>();

        // For every booking in findall:
        List<Booking> bookings = bookingRepository.findAll();

        for (int i = 0; i < bookings.size(); i++) {
            // Make as many bookinglineresponses as needed
            List<BookingLine> bookingLines = bookings.get(i).getBookinglines();
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
                    bookings.get(i).getName(),
                    bookings.get(i).getUser().getId(),
                    bookings.get(i).getUser().getUsername(),
                    bookings.get(i).getCancelled(),
                    bookings.get(i).getPlayroom().getRoomNr().name(),
                    bookings.get(i).getBookingdate().toString(),
                    bookings.get(i).getTimeslot().name(),
                    bookings.get(i).getGuests().toArray(new Guest[0]),
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

}