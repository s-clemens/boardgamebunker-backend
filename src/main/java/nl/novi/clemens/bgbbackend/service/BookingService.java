package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.payload.request.BookingRequest;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public interface BookingService {
    ResponseEntity<MessageResponse> postBooking(@Valid BookingRequest bookingRequest);



}
