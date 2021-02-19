package nl.novi.clemens.bgbbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table (name = "covidregulation")
public class CovidRegulation {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long bookingid;

    @Column
    private int nrAllowedGuests;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    public CovidRegulation(int nrAllowedGuests, LocalDate startDate, LocalDate endDate) {
        this.nrAllowedGuests = nrAllowedGuests;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getBookingid() {
        return bookingid;
    }

    public void setBookingid(long bookingid) {
        this.bookingid = bookingid;
    }

    public int getNrAllowedGuests() {
        return nrAllowedGuests;
    }

    public void setNrAllowedGuests(int nrAllowedGuests) {
        this.nrAllowedGuests = nrAllowedGuests;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
