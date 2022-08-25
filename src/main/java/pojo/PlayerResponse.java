package pojo;

public class PlayerResponse {
    public Integer id;
    public Object country_id;
    public Object timezone_id;
    public String username;
    public String email;
    public String name;
    public String surname;
    public Object gender;
    public Object phone_number;
    public Object birthdate;
    public Boolean bonuses_allowed;
    public Boolean is_verified;

    public PlayerResponse() {
    }

    public Integer getId() {
        return id;
    }

    public Object getCountry_id() {
        return country_id;
    }

    public Object getTimezone_id() {
        return timezone_id;
    }

    public String getUsername() {
        return username;
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

    public Object getGender() {
        return gender;
    }

    public Object getPhone_number() {
        return phone_number;
    }

    public Object getBirthdate() {
        return birthdate;
    }

    public Boolean getBonuses_allowed() {
        return bonuses_allowed;
    }

    public Boolean getIs_verified() {
        return is_verified;
    }
}
