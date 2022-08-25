package pojo;

public class AuthRequest {
    private String grant_type;
    private String scope;

    public AuthRequest() {
    }

    public String getGrant_type() {
        return grant_type;
    }

    public String getScope() {
        return scope;
    }


    public static final class AuthRequestBuilder {
        private String grant_type;
        private String scope;

        public AuthRequestBuilder() {
        }

        public static AuthRequestBuilder anAuthRequest() {
            return new AuthRequestBuilder();
        }

        public AuthRequestBuilder withGrant_type(String grant_type) {
            this.grant_type = grant_type;
            return this;
        }

        public AuthRequestBuilder withScope(String scope) {
            this.scope = scope;
            return this;
        }

        public AuthRequest build() {
            AuthRequest authRequest = new AuthRequest();
            authRequest.scope = this.scope;
            authRequest.grant_type = this.grant_type;
            return authRequest;
        }
    }
}
