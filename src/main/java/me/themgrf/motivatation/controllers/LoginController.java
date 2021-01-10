package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.Motivatation;
import me.themgrf.motivatation.users.LoginDetails;
import me.themgrf.motivatation.users.UserManager;
import me.themgrf.motivatation.util.AppInfo;
import me.themgrf.motivatation.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private static final String PAGE_NAME = "Motivatation | Login";

    // TODO: https://medium.com/@kamer.dev/spring-boot-user-registration-and-login-43a33ea19745

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", Auth.isLoggedIn());
        return "login";
    }

    @PostMapping("/loginuser")
    public String loginSubmit(@ModelAttribute LoginDetails loginDetails, Model model) {
        String password = UserManager.getPassword("test@test.com");
        boolean correct = Motivatation.getInstance().passwordEncoder().matches(password, loginDetails.getPassword());

        System.out.println("Password: " + password);

        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", correct);

        System.out.println("Status: " + correct);

        return correct ? "welcome" : "login?error=true";
    }

}