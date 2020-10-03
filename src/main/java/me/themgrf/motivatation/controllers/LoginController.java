package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.util.AppInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private static final String PAGE_NAME = "Motivatation | Login";

    @GetMapping("/login")
    public String landing(Model model) {
        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", false);
        return "login";
    }

}