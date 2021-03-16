package me.themgrf.motivatation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController extends ControllerBase {

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        model = super.setup(model);

        if (error != null) {
            model.addAttribute("error", "Your username or password is invalid.");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        return "login";
    }

    @Override
    public String getPageName() {
        return "Motivatation | Login";
    }
}