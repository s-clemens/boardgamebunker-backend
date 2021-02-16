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
}
