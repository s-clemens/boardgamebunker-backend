package nl.novi.clemens.bgbbackend.payload.response;

import nl.novi.clemens.bgbbackend.domain.Guest;
import java.util.List;

public class BookingResponse {

    private String name;

    private Long bookinguserid;

    private String bookingusername;

    private Boolean iscancelled;

    private String roomnr;

    private String bookingdate;

    private String timeslot;

    private Guest[] guests;

    private List<BookingLineResponse> bookingLineResponses;

    public BookingResponse(String name,
                           Long bookinguserid,
                           String bookingusername,
                           Boolean iscancelled,
                           String roomnr,
                           String bookingdate,
                           String timeslot,
                           Guest[] guests,
                           List<BookingLineResponse> bookingLineResponses) {
        this.name = name;
        this.bookinguserid = bookinguserid;
        this.bookingusername = bookingusername;
        this.iscancelled = iscancelled;
        this.roomnr = roomnr;
        this.bookingdate = bookingdate;
        this.timeslot = timeslot;
        this.guests = guests;
        this.bookingLineResponses = bookingLineResponses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBookinguserid() {
        return bookinguserid;
    }

    public void setBookinguserid(Long bookinguserid) {
        this.bookinguserid = bookinguserid;
    }

    public String getBookingusername() {
        return bookingusername;
    }

    public void setBookingusername(String bookingusername) {
        this.bookingusername = bookingusername;
    }

    public Boolean getIscancelled() {
        return iscancelled;
    }

    public void setIscancelled(Boolean iscancelled) {
        this.iscancelled = iscancelled;
    }

    public String getRoomnr() {
        return roomnr;
    }

    public void setRoomnr(String roomnr) {
        this.roomnr = roomnr;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public Guest[] getGuests() {
        return guests;
    }

    public void setGuests(Guest[] guests) {
        this.guests = guests;
    }

    public List<BookingLineResponse> getBookingLineResponses() {
        return bookingLineResponses;
    }

    public void setBookingLineResponses(List<BookingLineResponse> bookingLineResponses) {
        this.bookingLineResponses = bookingLineResponses;
    }
}