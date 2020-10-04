package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotNull
    @NotBlank(message = "Username required.")
    @Size(min = 5, max = 15, message = "Must be between 5 and 15 characters.")
    private String username;

    @Email(message = "Email must be valid.")
    private String email;

    @NotBlank(message = "Password required.")
    @Size(min = 6, max = 30)
    private String password;

    @NotBlank(message = "Must verify password.")
    @Size(min = 6, max = 30)
    private String verify;

    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;

    public User() {
    }

    public User(String username, String email, String password, String verify) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
    }

    private void checkPassword() {
//        if (getPassword().equals(getVerify())) {
//            setVerifyPassword("true");
//        }

        if (!getPassword().equals(getVerify()) && getPassword() != null && getVerify() != null) {
            setVerifyPassword(null);
        } else {
            setVerifyPassword("allGood");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
