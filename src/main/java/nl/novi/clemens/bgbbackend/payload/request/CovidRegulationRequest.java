package nl.novi.clemens.bgbbackend.payload.request;

import org.apache.tomcat.jni.Local;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

public class CovidRegulationRequest {

    @NotBlank
    private int nrallowedguests;

    @NotBlank
    private LocalDate startdate;

    @NotBlank
    private LocalDate enddate;

    public CovidRegulationRequest(int nrallowedguests, @NotBlank LocalDate startdate, @NotBlank LocalDate enddate) {
        this.nrallowedguests = nrallowedguests;
        this.startdate = startdate;
        this.enddate = enddate;
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

    @Override
    public String toString() {
        return "CovidRegulationRequest{" +
                "nrallowedguests=" + nrallowedguests +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                '}';
    }
}
