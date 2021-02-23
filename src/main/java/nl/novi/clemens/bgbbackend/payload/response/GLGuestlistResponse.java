package nl.novi.clemens.bgbbackend.payload.response;

import nl.novi.clemens.bgbbackend.domain.Guest;

import java.util.List;

public class GLGuestlistResponse {

    private List<Guest> guests;

    private Long bookingid;

    public GLGuestlistResponse() {
    }

    public GLGuestlistResponse(List<Guest> guests, Long bookingid) {
        this.guests = guests;
        this.bookingid = bookingid;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public Long getBookingid() {
        return bookingid;
    }

    public void setBookingid(Long bookingid) {
        this.bookingid = bookingid;
    }
}
