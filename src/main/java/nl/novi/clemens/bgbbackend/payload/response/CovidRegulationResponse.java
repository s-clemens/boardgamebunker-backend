package nl.novi.clemens.bgbbackend.payload.response;

import java.time.LocalDate;

public class CovidRegulationResponse {

    private long id;
    private int nrallowedguests;
    private LocalDate startdate;
    private LocalDate enddate;

    public CovidRegulationResponse(long id, int nrallowedguests, LocalDate startdate, LocalDate enddate) {
        this.id = id;
        this.nrallowedguests = nrallowedguests;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNrallowedguests() {
        return nrallowedguests;
    }

    public void setNrallowedguests(int nrallowedguests) {
        this.nrallowedguests = nrallowedguests;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }
}
