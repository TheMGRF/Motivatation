package me.themgrf.motivatation.controllers;

import me.themgrf.motivatation.database.PlayerManager;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.users.UserValidator;
import me.themgrf.motivatation.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController extends ControllerBase {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/signup")
    public String signup(Model model) {
        model = super.setup(model);

        model.addAttribute("signup", new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("signup") User userData, BindingResult bindingResult, Model model) {
        userValidator.validate(userData, bindingResult);

        /*model.addAttribute("appName", AppInfo.SITE_NAME);
        model.addAttribute("pageName", PAGE_NAME);
        model.addAttribute("loggedIn", Auth.isLoggedIn());*/
        model = super.setup(model);

        if (bindingResult.hasErrors()) {
            System.out.println("ERROR: " + bindingResult.getErrorCount());
            bindingResult.getModel().forEach((s, o) -> {
                System.out.println(s + ": " + o);
            });

            model.addAttribute("error", true);

            return "signup";
        }

        userService.save(userData);
        PlayerManager.addPlayer(new Player(userData.getId()));

        return "redirect:/welcome";
    }

    @Override
    public String getPageName() {
        return "Motivatation | Signup";
    }
}
