package pojo;

public class ResourceOwnerRequest {
    private String grant_type;
    private String username;
    private String password;

    public ResourceOwnerRequest() {
    }

    public String getGrant_type() {
        return grant_type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public static final class ResourceOwnerRequestBuilder {
        private String grant_type;
        private String username;
        private String password;

        public ResourceOwnerRequestBuilder() {
        }

        public static ResourceOwnerRequestBuilder aResourceOwnerRequest() {
            return new ResourceOwnerRequestBuilder();
        }

        public ResourceOwnerRequestBuilder withGrant_type(String grant_type) {
            this.grant_type = grant_type;
            return this;
        }

        public ResourceOwnerRequestBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public ResourceOwnerRequestBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public ResourceOwnerRequest build() {
            ResourceOwnerRequest resourceOwnerRequest = new ResourceOwnerRequest();
            resourceOwnerRequest.password = this.password;
            resourceOwnerRequest.username = this.username;
            resourceOwnerRequest.grant_type = this.grant_type;
            return resourceOwnerRequest;
        }
    }
}
