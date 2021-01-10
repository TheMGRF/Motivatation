package me.themgrf.motivatation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Motivatation {

    private static Motivatation instance;

    public Motivatation() {
        instance = this;
    }

    public static Motivatation getInstance() {
        if (instance == null) instance = new Motivatation();
        return instance;
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
