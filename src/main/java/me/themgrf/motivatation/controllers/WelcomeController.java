package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController extends ControllerBase {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model = super.setup(model);
        model.addAttribute("user", Auth.getUser());

        return "welcome";
    }

    @Override
    public String getPageName() {
        return "Motivatation | Welcome";
    }
}
