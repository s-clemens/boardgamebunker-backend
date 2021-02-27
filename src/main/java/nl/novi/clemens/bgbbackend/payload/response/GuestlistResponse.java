package nl.novi.clemens.bgbbackend.payload.response;

import java.time.LocalDate;
import java.util.List;

public class GuestlistResponse {

    private LocalDate date;

    List<GLTimeslotResponse> glTimeslotResponseList;

    public GuestlistResponse(LocalDate date, List<GLTimeslotResponse> glTimeslotResponseList) {
        this.date = date;
        this.glTimeslotResponseList = glTimeslotResponseList;
    }

    public GuestlistResponse() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<GLTimeslotResponse> getGlTimeslotResponseList() {
        return glTimeslotResponseList;
    }

    public void setGlTimeslotResponseList(List<GLTimeslotResponse> glTimeslotResponseList) {
        this.glTimeslotResponseList = glTimeslotResponseList;
    }
}