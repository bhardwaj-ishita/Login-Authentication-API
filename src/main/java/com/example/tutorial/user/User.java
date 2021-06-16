package com.example.tutorial.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    private @Id @GeneratedValue long id;
    private @NotBlank String username;
    private @NotBlank String password;
    private @NotBlank String email;
    private @NotBlank boolean loggedIn;//tells if the person is logged in or not

    public User() {
    }

    public User(@NotBlank String username,
                @NotBlank String password,
                @NotBlank String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedIn = false;
    }
    public long getId() {
        return id;
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
    public void setPassword(String password) { this.password = password; }
    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email; }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    //this would be used later to compare the object passed in the database and program for eligibility
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    //generates a hash value for object
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email,
                loggedIn);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}