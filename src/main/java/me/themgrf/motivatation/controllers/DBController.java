package me.themgrf.motivatation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class DBController {

    @Autowired
    private static JdbcTemplate db;

    public static JdbcTemplate getDB() {
        return db;
    }
}
