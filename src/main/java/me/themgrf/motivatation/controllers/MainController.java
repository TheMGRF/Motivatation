package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.util.AppInfo;
import me.themgrf.motivatation.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private static final String PAGE_NAME = "Motivatation";

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", Auth.isLoggedIn());

        return "landing";
    }

}
