package nl.novi.clemens.bgbbackend.domain;

import nl.novi.clemens.bgbbackend.domain.enums.EPlayroomNr;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table ( name = "playroom")
public class Playroom {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long playroomid;

    @Enumerated(EnumType.STRING)
    private EPlayroomNr roomnr;

    @Column
    private int maxguests;

    @OneToMany (mappedBy = "playroom")
    private Set<Booking> bookings;

    public long getPlayroomid() {
        return playroomid;
    }

    public void setPlayroomid(long playroomid) {
        this.playroomid = playroomid;
    }

    public EPlayroomNr getRoomNr() {
        return roomnr;
    }

    public int getMaxGuests() {
        return maxguests;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}