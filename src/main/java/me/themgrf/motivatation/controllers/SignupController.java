package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.users.service.UserService;
import me.themgrf.motivatation.users.UserValidator;
import me.themgrf.motivatation.util.AppInfo;
import me.themgrf.motivatation.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private static final String PAGE_NAME = "Motivatation | Signup";

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signup", new User());
        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", Auth.isLoggedIn());

        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("signup") User userData, BindingResult bindingResult, Model model) {
        userValidator.validate(userData, bindingResult);

        model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", Auth.isLoggedIn());

        if (bindingResult.hasErrors()) {
            System.out.println("ERROR: " + bindingResult.getErrorCount());
            bindingResult.getModel().forEach((s, o) -> {
                System.out.println(s + ": " + o);
            });
            return "signup";
        }

        userService.save(userData);

        return "redirect:/welcome";
    }


}
