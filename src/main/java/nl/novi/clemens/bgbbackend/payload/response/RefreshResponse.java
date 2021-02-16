package nl.novi.clemens.bgbbackend.payload.response;

import java.util.List;

public class RefreshResponse {
    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    public RefreshResponse(String accessToken, Long id, String username, String email, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}