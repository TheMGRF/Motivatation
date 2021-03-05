package me.themgrf.motivatation.controllers.home;

import me.themgrf.motivatation.controllers.ControllerBase;
import me.themgrf.motivatation.database.PlayerManager;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.MissionManager;
import me.themgrf.motivatation.game.missions.Missions;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.PeacefulJourneyEvent;
import me.themgrf.motivatation.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class MissionsController extends ControllerBase {

    private static final int RESET_COST = -1; // TODO: Set to 100

    @GetMapping("/home/missions")
    public String missions(Model model) {
        model = super.setup(model);

        User user = Auth.getUser();
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            Player player = PlayerManager.getPlayer(user);
            model.addAttribute("player", player);

            model.addAttribute("missions", MissionManager.createMissionsForPlayer(player));
        }

        return "home/missions";
    }

    @GetMapping("/home/mission/{missionName}")
    public String runMission(Model model, @PathVariable String missionName) {
        model = super.setup(model);

        User user = Auth.getUser();
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            Player player = PlayerManager.getPlayer(user);
            model.addAttribute("player", player);

            Mission mission = Missions.valueOf(missionName.toUpperCase()).getMission();

            List<Mission> playerMissions = MissionManager.PLAYER_MISSIONS.get(player.getId());
            if (playerMissions == null) return "redirect:/home/missions";
            if (!playerMissions.contains(mission)) return "redirect:/home/missions";

            model.addAttribute("mission", mission);

            RandomEvent randomEvent = new PeacefulJourneyEvent();

            // 50% chance that a random event will occur
            int random = ThreadLocalRandom.current().nextInt(100);
            if (random >= 50) {
                List<RandomEvent> randomEvents = mission.getRandomEvents();
                randomEvent = randomEvents.get(ThreadLocalRandom.current().nextInt(randomEvents.size()));
            }

            model.addAttribute("randomEvent", randomEvent);

            // Run the actual events logic
            randomEvent.activate(player);
            mission.activate(player);

            // Remove the mission from the player's list so they cant repeat it
            MissionManager.removeMission(player, mission);
        }

        return "home/mission";
    }

    @GetMapping("/home/resetmissions")
    public RedirectView resetMissions(HttpServletRequest req, RedirectAttributes attributes) {
        RedirectView redirectView = new RedirectView("/home/missions", true);

        User user = Auth.getUser();
        if (user != null) {
            Player player = PlayerManager.getPlayer(user);

            if (player.getCoins() >= RESET_COST) {
                attributes.addFlashAttribute("missions", MissionManager.reset(player));
            } else {
                attributes.addFlashAttribute("resetError", "Not Enough Coins!");
            }
        }

        return redirectView;
    }

    @Override
    public String getPageName() {
        return "Motivatation | Home";
    }

}
