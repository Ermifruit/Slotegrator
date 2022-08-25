package pojo;

public class AuthResponse {
    private String token_type;
    private Integer expires_in;
    private String access_token;

    public AuthResponse() {
    }

    public String getToken_type() {
        return token_type;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }
}
