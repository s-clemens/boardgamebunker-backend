package nl.novi.clemens.bgbbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "guest")
public class Guest {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long guestid;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "booking_id")
    private Booking booking;

    public Guest(String name, String phoneNumber, Booking booking) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.booking = booking;
    }

    public long getGuestid() {
        return guestid;
    }

    public void setGuestid(long guestid) {
        this.guestid = guestid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
