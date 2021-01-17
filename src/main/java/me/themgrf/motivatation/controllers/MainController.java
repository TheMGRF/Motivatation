package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.util.AppInfo;
import me.themgrf.motivatation.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private static final String PAGE_NAME = "Motivatation";

    @Autowired
    private JdbcTemplate db;

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        //model.addAttribute("pageName", db.query("SELECT * FROM TEST LIMIT 1;", (rs, i) -> rs.getString("name")));
        //model.addAttribute("pageName", db.queryForObject("SELECT name FROM TEST WHERE id = 2 LIMIT 1;", String.class));
        model.addAttribute("loggedIn", Auth.isLoggedIn());

        //db.update("INSERT INTO test (name) VALUES ('Tom');");

        return "landing";
    }

}
