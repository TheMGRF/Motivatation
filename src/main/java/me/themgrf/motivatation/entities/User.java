package me.themgrf.motivatation.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username, password, confirmedPassword;
    @Column(unique = true)
    private String email;

    public User() {
    }

    public User(Long id, String username, String password, String confirmedPassword, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Transient
    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String passwordConfirm) {
        this.confirmedPassword = passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
