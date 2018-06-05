package mihajlo.exampleantony.it.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mihajlo.exampleantony.it.entity.User;

import javax.persistence.Column;

public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String image;
    public User getUser(){//String username, String password, String email, String firstname, String lastname
        return new User(username,password,email,firstname,lastname,image);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
