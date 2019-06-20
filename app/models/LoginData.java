package models;


import play.data.validation.Constraints;

public class LoginData {

    @Constraints.Required
    private String username;

    @Constraints.Required
    private String password;

    public LoginData() {
    }

    public LoginData(@Constraints.Required String username, @Constraints.Required String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
