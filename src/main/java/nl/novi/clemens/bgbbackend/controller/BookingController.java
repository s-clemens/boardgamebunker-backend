package nl.novi.clemens.bgbbackend.controller;

import nl.novi.clemens.bgbbackend.payload.request.BookingRequest;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import nl.novi.clemens.bgbbackend.service.BookingService;
import nl.novi.clemens.bgbbackend.service.BookingServiceImpl;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
//    @Autowired
//    BookingServiceImpl bookingServiceImpl;

//     Post Booking
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/postbooking")
    public ResponseEntity<MessageResponse> postBooking(@RequestBody BookingRequest bookingRequest){
        return bookingService.postBooking(bookingRequest);
    }

    // Get all bookings

    // Get booking by id

    // Get Owned Booking by id

    // Get booking guest list by id

    // Get booking products by id

    // update booking guest list

    // cancel booking

    // cancel owned booking

    // Check if booking is allowed

}
