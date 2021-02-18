package nl.novi.clemens.bgbbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Date startDate;

    @Column
    private Date endDate;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
