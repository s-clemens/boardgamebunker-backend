package nl.novi.clemens.bgbbackend.payload.request;

public class TokenRequest {

    private String token;

    public String getTokenString() {
        return token;
    }

    public void setTokenString(String tokenString) {
        this.token = tokenString;
    }
}