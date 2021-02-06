package me.themgrf.motivatation.controllers.home;

import me.themgrf.motivatation.database.PlayerManager;
import me.themgrf.motivatation.entities.GameUser;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
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

        User user = Auth.getUser();
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            Player player = PlayerManager.getPlayer(user);
            model.addAttribute("player", player);
        }

        return "home/home";
    }

}
