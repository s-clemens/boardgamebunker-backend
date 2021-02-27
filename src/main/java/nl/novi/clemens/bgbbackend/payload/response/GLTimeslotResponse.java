package nl.novi.clemens.bgbbackend.payload.response;

import java.util.List;

public class GLTimeslotResponse {

    private String timeslot;

    private List<GLPlayroomResponse> glPlayroomResponses;

    public GLTimeslotResponse() {
    }

    public GLTimeslotResponse(String timeslot, List<GLPlayroomResponse> glPlayroomResponses) {
        this.timeslot = timeslot;
        this.glPlayroomResponses = glPlayroomResponses;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public List<GLPlayroomResponse> getGlPlayroomResponses() {
        return glPlayroomResponses;
    }

    public void setGlPlayroomResponses(List<GLPlayroomResponse> glPlayroomResponses) {
        this.glPlayroomResponses = glPlayroomResponses;
    }
}
