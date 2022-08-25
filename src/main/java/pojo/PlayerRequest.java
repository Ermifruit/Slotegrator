package pojo;

public class PlayerRequest {
    private String username;
    private String password_change;
    private String password_repeat;
    private String email;
    private String name;
    private String surname;
    private String currency_code;

    public PlayerRequest() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword_change() {
        return password_change;
    }

    public String getPassword_repeat() {
        return password_repeat;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCurrency_code() {
        return currency_code;
    }


    public static final class PlayerRequestBuilder {
        private String username;
        private String password_change;
        private String password_repeat;
        private String email;
        private String name;
        private String surname;
        private String currency_code;

        public PlayerRequestBuilder() {
        }

        public static PlayerRequestBuilder aPlayerRequest() {
            return new PlayerRequestBuilder();
        }

        public PlayerRequestBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public PlayerRequestBuilder withPassword_change(String password_change) {
            this.password_change = password_change;
            return this;
        }

        public PlayerRequestBuilder withPassword_repeat(String password_repeat) {
            this.password_repeat = password_repeat;
            return this;
        }

        public PlayerRequestBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public PlayerRequestBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PlayerRequestBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PlayerRequestBuilder withCurrency_code(String currency_code) {
            this.currency_code = currency_code;
            return this;
        }

        public PlayerRequest build() {
            PlayerRequest playerRequest = new PlayerRequest();
            playerRequest.username = this.username;
            playerRequest.password_repeat = this.password_repeat;
            playerRequest.currency_code = this.currency_code;
            playerRequest.surname = this.surname;
            playerRequest.password_change = this.password_change;
            playerRequest.email = this.email;
            playerRequest.name = this.name;
            return playerRequest;
        }
    }
}
