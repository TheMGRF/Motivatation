package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.util.AppInfo;
import me.themgrf.motivatation.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final String PAGE_NAME = "Motivatation | Home";

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", Auth.isLoggedIn());
        return "home/home";
    }

}
