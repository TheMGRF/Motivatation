package me.themgrf.motivatation.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserManager {

    @Autowired
    private static JdbcTemplate db;

    public static String getPassword(String email) {
        return db.queryForObject("SELECT password FROM users WHERE email = ?", String.class, email);
    }

}
