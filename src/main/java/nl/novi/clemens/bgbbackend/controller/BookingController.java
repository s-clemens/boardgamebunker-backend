package nl.novi.clemens.bgbbackend.controller;

import nl.novi.clemens.bgbbackend.payload.request.AvailableTimeSlotRequest;
import nl.novi.clemens.bgbbackend.payload.request.BookingRequest;
import nl.novi.clemens.bgbbackend.payload.request.GuestlistRequest;
import nl.novi.clemens.bgbbackend.payload.response.AllBookingResponse;
import nl.novi.clemens.bgbbackend.payload.response.AvailableTimeSlotsResponse;
import nl.novi.clemens.bgbbackend.payload.response.BookingResponse;
import nl.novi.clemens.bgbbackend.payload.response.GuestlistResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import nl.novi.clemens.bgbbackend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/user/postbooking")
    public ResponseEntity<MessageResponse> postBooking(@RequestBody BookingRequest bookingRequest){
        return bookingService.postBooking(bookingRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/all")
    public ResponseEntity<AllBookingResponse> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/all")
    public  ResponseEntity<AllBookingResponse> getAllOwnedBookings(){
        return bookingService.getAllOwnedBookings();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/{bookingid}")
    public ResponseEntity<BookingResponse> getOwnedBookingById(@PathVariable("bookingid") Long bookingid){
        return bookingService.getOwnedBookingById(bookingid);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/admin/cancelbooking/{bookingid}")
    public ResponseEntity<MessageResponse> cancelBookingById(@PathVariable("bookingid") Long bookingid){
        return bookingService.cancelBookingById(bookingid);
    }

    @PreAuthorize("hasRole('USER')")
    @PatchMapping("/user/cancelbooking/{bookingid}")
    public ResponseEntity<MessageResponse> cancelOwnedBookingById(@PathVariable("bookingid") Long bookingid){
        return bookingService.cancelOwnedBookingById(bookingid);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/timeslots/available")
    public ResponseEntity<AvailableTimeSlotsResponse> getAvailableTimeslotsByDay(@RequestBody AvailableTimeSlotRequest availableTimeSlotRequest){
        return bookingService.getAvailableTimeslotsByDay(availableTimeSlotRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/guestlist")
    public ResponseEntity<GuestlistResponse> getGuestlistFromDayBasedOnTimeslotsAndRoom(@RequestBody GuestlistRequest guestlistRequest){
        return bookingService.getGuestlistFromDayBasedOnTimeslotsAndRoom(guestlistRequest);
    }
}