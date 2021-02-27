package nl.novi.clemens.bgbbackend.payload.response;

public class GLGuestResponse {

    private String name;

    private String phonenumber;

    public GLGuestResponse(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public GLGuestResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}