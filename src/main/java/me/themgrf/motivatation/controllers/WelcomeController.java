package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.util.AppInfo;
import me.themgrf.motivatation.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    private static final String PAGE_NAME = "Motivatation | Welcome";

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", Auth.isLoggedIn());
        model.addAttribute("user", Auth.getUser());
        return "welcome";
    }

}
