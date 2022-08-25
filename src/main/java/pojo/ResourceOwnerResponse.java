package pojo;

public class ResourceOwnerResponse {
    private String token_type;
    private Integer expires_in;
    private String access_token;
    private String refresh_token;

    public ResourceOwnerResponse() {
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

    public String getRefresh_token() {
        return refresh_token;
    }
}
