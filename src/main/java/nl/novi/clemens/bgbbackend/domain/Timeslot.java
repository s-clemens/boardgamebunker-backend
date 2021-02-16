package nl.novi.clemens.bgbbackend.domain;

import nl.novi.clemens.bgbbackend.domain.enums.ETimeslot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "timeslot")
public class Timeslot {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long timeslotid;

    @Enumerated(EnumType.STRING)
    private ETimeslot timeslot;

    @Column
    private Date day;

    @OneToMany(mappedBy = "timeslot")
    private Set<Booking> bookings;
}
