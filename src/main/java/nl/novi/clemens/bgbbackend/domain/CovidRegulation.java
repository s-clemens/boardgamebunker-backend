package nl.novi.clemens.bgbbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table (name = "covidregulation")
public class CovidRegulation {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @Column(columnDefinition = "serial", name = "id")
    private long covidregulationid;

    @Column
    private int nrAllowedGuests;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    public CovidRegulation() {
    }

    public CovidRegulation(int nrAllowedGuests, LocalDate startDate, LocalDate endDate) {
        this.nrAllowedGuests = nrAllowedGuests;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getCovidregulationid() {
        return covidregulationid;
    }

    public void setCovidregulationid(long covidregulationid) {
        this.covidregulationid = covidregulationid;
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