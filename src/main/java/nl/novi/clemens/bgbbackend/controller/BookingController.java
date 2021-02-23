package nl.novi.clemens.bgbbackend.controller;

import nl.novi.clemens.bgbbackend.payload.request.BookingRequest;
import nl.novi.clemens.bgbbackend.payload.response.AllBookingResponse;
import nl.novi.clemens.bgbbackend.payload.response.BookingResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import nl.novi.clemens.bgbbackend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;
//    @Autowired
//    BookingServiceImpl bookingServiceImpl;

//     Post Booking
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/postbooking")
    public ResponseEntity<MessageResponse> postBooking(@RequestBody BookingRequest bookingRequest){
        return bookingService.postBooking(bookingRequest);
    }

    // Get all bookings
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/all")
    public ResponseEntity<AllBookingResponse> getAllBookings(){
        return bookingService.getAllBookings();
    }

    // Get booking by id
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }

    // Get Owned Booking by id

    // Get booking guest list by id

    // Get booking products by id

    // update booking guest list

    // cancel booking

    // cancel owned booking

    // Check if booking is allowed

}
