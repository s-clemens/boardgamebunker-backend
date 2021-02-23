package nl.novi.clemens.bgbbackend.payload.response;

import java.util.List;

public class GLPlayroomResponse {

    private String playroomname;

    private List<GLGuestlistResponse> glGuestlistResponses;

    public GLPlayroomResponse() {
    }

    public GLPlayroomResponse(List<GLGuestlistResponse> glGuestlistResponses) {
        this.glGuestlistResponses = glGuestlistResponses;
    }

    public List<GLGuestlistResponse> getGlGuestlistResponses() {
        return glGuestlistResponses;
    }

    public void setGlGuestlistResponses(List<GLGuestlistResponse> glGuestlistResponses) {
        this.glGuestlistResponses = glGuestlistResponses;
    }

    public String getPlayroomname() {
        return playroomname;
    }

    public void setPlayroomname(String playroomname) {
        this.playroomname = playroomname;
    }
}
