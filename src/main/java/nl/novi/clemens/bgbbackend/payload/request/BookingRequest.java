package nl.novi.clemens.bgbbackend.payload.request;

import nl.novi.clemens.bgbbackend.domain.enums.ETimeslot;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class BookingRequest {

    @NotBlank
    private String name;

    @NotBlank
    private LocalDate bookingdate;

    @NotBlank
    private ETimeslot timeslot;

    @NotBlank
    private Long playroomid;

    private GuestRequest[] guestsrequests;

    @NotBlank
    private BookingLineRequest[] bookinglines;

    @NotBlank
    private Long posterid;

    public BookingRequest() {};

    public BookingRequest(@NotBlank String name,
                          @NotBlank LocalDate bookingdate,
                          @NotBlank ETimeslot timeslot,
                          @NotBlank Long playroomid,
                          GuestRequest[] guestsrequests,
                          @NotBlank BookingLineRequest[] bookinglines,
                          @NotBlank Long posterid) {
        this.name = name;
        this.bookingdate = bookingdate;
        this.timeslot = timeslot;
        this.playroomid = playroomid;
        this.guestsrequests = guestsrequests;
        this.bookinglines = bookinglines;
        this.posterid = posterid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(LocalDate bookingdate) {
        this.bookingdate = bookingdate;
    }

    public ETimeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(ETimeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Long getPlayroomid() {
        return playroomid;
    }

    public void setPlayroomid(Long playroomid) {
        this.playroomid = playroomid;
    }

    public GuestRequest[] getGuestsrequests() {
        return guestsrequests;
    }

    public void setGuestsrequests(GuestRequest[] guestsrequests) {
        this.guestsrequests = guestsrequests;
    }

    public BookingLineRequest[] getBookinglines() {
        return bookinglines;
    }

    public void setBookinglines(BookingLineRequest[] bookinglines) {
        this.bookinglines = bookinglines;
    }

    public Long getPosterid() {
        return posterid;
    }

    public void setPosterid(Long posterid) {
        this.posterid = posterid;
    }
}
