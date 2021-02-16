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
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long playroomid;

    @Enumerated(EnumType.STRING)
    private EPlayroomNr roomNr;

    @Column
    private int maxGuests;

    @OneToMany (mappedBy = "playroom")
    private Set<Booking> bookings;
}
