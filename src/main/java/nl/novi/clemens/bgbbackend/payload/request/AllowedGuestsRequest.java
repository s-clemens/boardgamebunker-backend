package nl.novi.clemens.bgbbackend.payload.request;

import java.time.LocalDate;

public class AllowedGuestsRequest {

    private int numberofguests;

    private LocalDate bookingdate;

    public AllowedGuestsRequest(int numberofguests, LocalDate bookingdate) {
        this.numberofguests = numberofguests;
        this.bookingdate = bookingdate;
    }

    public AllowedGuestsRequest() {
    }

    public int getNumberofguests() {
        return numberofguests;
    }

    public void setNumberofguests(int numberofguests) {
        this.numberofguests = numberofguests;
    }

    public LocalDate getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(LocalDate bookingdate) {
        this.bookingdate = bookingdate;
    }
}
