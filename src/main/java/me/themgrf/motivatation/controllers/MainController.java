package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.util.AppInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private static final String PAGE_NAME = "Home";

    private boolean loggedIn = false;

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("loggedIn", loggedIn);

        return loggedIn ? "home" : "landing";
    }

}
