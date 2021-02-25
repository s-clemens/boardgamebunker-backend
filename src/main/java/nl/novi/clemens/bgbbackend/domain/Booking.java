package nl.novi.clemens.bgbbackend.domain;

import nl.novi.clemens.bgbbackend.domain.enums.ETimeslot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "booking")
public class Booking {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @Column (columnDefinition = "serial")
    private long bookingid;

    @Column
    private String name;

    @Column
    private LocalDate bookingdate;

    @Column
    private ETimeslot timeslot;

    @Column
    private Boolean isCancelled;

    @OneToMany (mappedBy = "booking")
    private List<BookingLine> bookinglines;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "playroom_id")
    private Playroom playroom;

    @OneToMany (mappedBy = "booking")
    private List<Guest> guests;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "user_id")
    private User user;

    public Booking(){};

    public Booking(String name, LocalDate bookingdate, ETimeslot timeslot, Boolean isCancelled, User owner) {
        this.name = name;
        this.bookingdate = bookingdate;
        this.timeslot = timeslot;
        this.isCancelled = isCancelled;
        this.user = owner;
    }

    public long getBookingid() {
        return bookingid;
    }

    public void setBookingid(long bookingid) {
        this.bookingid = bookingid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCancelled() {
        return isCancelled;
    }

    public void setCancelled(Boolean cancelled) {
        isCancelled = cancelled;
    }

    public List<BookingLine> getBookinglines() {
        return bookinglines;
    }

    public void setBookinglines(List<BookingLine> bookinglines) {
        this.bookinglines = bookinglines;
    }

    public Playroom getPlayroom() {
        return playroom;
    }

    public void setPlayroom(Playroom playroom) {
        this.playroom = playroom;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


}
