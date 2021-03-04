package me.themgrf.motivatation.controllers.home;

import me.themgrf.motivatation.controllers.ControllerBase;
import me.themgrf.motivatation.database.PlayerManager;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.game.achievement.Achievement;
import me.themgrf.motivatation.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AchievementController extends ControllerBase {

    @GetMapping("/home/achievements")
    public String achievements(Model model) {
        model = super.setup(model);

        model.addAttribute("achievements", Achievement.VALUES);

        User user = Auth.getUser();
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            Player player = PlayerManager.getPlayer(user);
            for (Achievement achievement : Achievement.VALUES) {
                if (player.hasCompletedAchievement(achievement)) {
                    player.awardAchievement(achievement);
                }
            }
            model.addAttribute("player", player);
            model.addAttribute("playerAchievements", player.getAchievements());
        }

        return "home/achievements";
    }

    @Override
    public String getPageName() {
        return "Motivatation | Home";
    }
}
