package nl.novi.clemens.bgbbackend.service;

import nl.novi.clemens.bgbbackend.payload.request.AvailableTimeSlotRequest;
import nl.novi.clemens.bgbbackend.payload.request.BookingRequest;
import nl.novi.clemens.bgbbackend.payload.request.GuestlistRequest;
import nl.novi.clemens.bgbbackend.payload.response.AllBookingResponse;
import nl.novi.clemens.bgbbackend.payload.response.AvailableTimeSlotsResponse;
import nl.novi.clemens.bgbbackend.payload.response.BookingResponse;
import nl.novi.clemens.bgbbackend.payload.response.GuestlistResponse;
import nl.novi.clemens.bgbbackend.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public interface BookingService {

    ResponseEntity<MessageResponse> postBooking(@Valid BookingRequest bookingRequest);
    ResponseEntity<AllBookingResponse> getAllBookings();
    ResponseEntity<AllBookingResponse> getAllOwnedBookings();
    ResponseEntity<BookingResponse> getBookingById(Long id);
    ResponseEntity<BookingResponse> getOwnedBookingById(long bookingid);
    ResponseEntity<AvailableTimeSlotsResponse> getAvailableTimeslotsByDay(AvailableTimeSlotRequest availableTimeSlotRequest);
    ResponseEntity<MessageResponse> cancelBookingById(Long bookingid);
    ResponseEntity<MessageResponse> cancelOwnedBookingById(Long bookingid);
    ResponseEntity<GuestlistResponse> getGuestlistFromDayBasedOnTimeslotsAndRoom(GuestlistRequest guestlistRequest);



}
