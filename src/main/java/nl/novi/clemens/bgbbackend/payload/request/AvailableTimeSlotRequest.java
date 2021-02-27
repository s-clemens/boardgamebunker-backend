package nl.novi.clemens.bgbbackend.payload.request;

import java.time.LocalDate;

public class AvailableTimeSlotRequest {
    private LocalDate bookingdate;

    public AvailableTimeSlotRequest(){};

    public AvailableTimeSlotRequest(LocalDate bookingdate) {
        this.bookingdate = bookingdate;
    }

    public LocalDate getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(LocalDate bookingdate) {
        this.bookingdate = bookingdate;
    }
}