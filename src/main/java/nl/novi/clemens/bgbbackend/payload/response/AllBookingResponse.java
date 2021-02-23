package nl.novi.clemens.bgbbackend.payload.response;

import java.util.List;

public class AllBookingResponse {

    private List<BookingResponse> bookingResponses;

    public AllBookingResponse(List<BookingResponse> bookingResponses) {
        this.bookingResponses = bookingResponses;
    }

    public List<BookingResponse> getBookingResponses() {
        return bookingResponses;
    }

    public void setBookingResponses(List<BookingResponse> bookingResponses) {
        this.bookingResponses = bookingResponses;
    }
}
