package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.util.AppInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private boolean loggedIn = false;

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("loggedIn", false);

        return loggedIn ? "home" : "landing";
    }

}
