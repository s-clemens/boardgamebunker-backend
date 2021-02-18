package nl.novi.clemens.bgbbackend.domain;

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
import java.util.Set;

@Entity
@Table (name = "booking")
public class Booking {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column (columnDefinition = "serial")
    private long bookingid;

    @Column
    private String name;

    @Column private Boolean isCancelled;

    @OneToMany (mappedBy = "booking")
    private Set<BookingLine> bookinglines;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "playroom_id")
    private Playroom playroom;

    @OneToMany (mappedBy = "booking")
    private Set<Guest> guests;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "timeslot_id")
    private Timeslot timeslot;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "user_id")
    private User user;

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

    public Set<BookingLine> getBookinglines() {
        return bookinglines;
    }

    public void setBookinglines(Set<BookingLine> bookinglines) {
        this.bookinglines = bookinglines;
    }

    public Playroom getPlayroom() {
        return playroom;
    }

    public void setPlayroom(Playroom playroom) {
        this.playroom = playroom;
    }

    public Set<Guest> getGuests() {
        return guests;
    }

    public void setGuests(Set<Guest> guests) {
        this.guests = guests;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
