package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.Motivatation;
import me.themgrf.motivatation.users.SignupDetails;
import me.themgrf.motivatation.util.AppInfo;
import me.themgrf.motivatation.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class SignupController {

    private static final String PAGE_NAME = "Motivatation | Signup";

    @Autowired
    private JdbcTemplate db;

    @GetMapping("/signup")
    public String signup(Model model) {
        boolean loggedIn = Auth.isLoggedIn();

        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", loggedIn);

        if (loggedIn) {
            return "landing";
        }


        model.addAttribute("signup", new SignupDetails());
        return "signup";
    }

    @PostMapping("/signupuser")
    public String signupSubmit(@ModelAttribute SignupDetails signupDetails, Model model) {
        boolean loggedIn = Auth.isLoggedIn();

        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", loggedIn);

        if (loggedIn) {
            return "landing";
        }

        model.addAttribute("username", signupDetails.getUsername());

        //db.update("INSERT INTO users (uuid, username, email, password) VALUES (?, ?, ?, ?) WHERE NOT EXISTS(SELECT email FROM users WHERE ? = email);",
        db.update("INSERT IGNORE INTO users (uuid, username, email, password) VALUES (?, ?, ?, ?);",
                UUID.randomUUID().toString(),
                signupDetails.getUsername(),
                signupDetails.getEmail(),
                Motivatation.getInstance().passwordEncoder().encode(signupDetails.getPassword())
        );

        return "welcome";
    }



}
