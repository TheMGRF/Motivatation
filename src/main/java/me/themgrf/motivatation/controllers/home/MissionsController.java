package me.themgrf.motivatation.controllers.home;

import me.themgrf.motivatation.controllers.ControllerBase;
import me.themgrf.motivatation.database.PlayerManager;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.game.achievement.Achievement;
import me.themgrf.motivatation.game.achievement.AchievementManager;
import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.MissionManager;
import me.themgrf.motivatation.game.missions.Missions;
import me.themgrf.motivatation.game.missions.actions.ActionRecorder;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.PeacefulJourneyEvent;
import me.themgrf.motivatation.util.Auth;
import me.themgrf.motivatation.util.MathUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import xyz.minecrossing.coreutilities.CoreUtilities;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class MissionsController extends ControllerBase {

    private static final int RESET_COST = 100;
    private static final int REVIVE_COST = 500;

    @GetMapping("/home/missions")
    public String missions(Model model) {
        model = super.setup(model);

        User user = Auth.getUser();
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            Player player = PlayerManager.getPlayer(user);
            model.addAttribute("player", player);

            if (player.isDead()) {
                model.addAttribute("hideMissions", true);
            } else {
                model.addAttribute("missions", MissionManager.createMissionsForPlayer(player));
            }
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

            // % chance that a random event will occur dependant on journey time
            int random = ThreadLocalRandom.current().nextInt(100);
            boolean runRandomEvent;
            switch (mission.getJourneyTime()) {
                case SHORT:
                    runRandomEvent = random > 70;
                    break;
                case MEDIUM:
                    runRandomEvent = random > 50;
                    break;
                case LONG:
                    runRandomEvent = random > 30;
                    break;
                default:
                    runRandomEvent = false;
                    break;
            }

            Achievement firstMission = Achievement.FIRST_ADVENTURE;
            if (!player.hasAchievement(firstMission)) {
                CoreUtilities.getTaskManager().runAsync(() -> AchievementManager.updateAchievement(player, firstMission, 1));
                model.addAttribute("firstMission", firstMission);
            }

            Achievement firstFiveMissions = Achievement.SEASONED_ADVENTURER;
            if (!player.hasAchievement(firstFiveMissions)) {
                CoreUtilities.getTaskManager().runAsync(() -> AchievementManager.updateAchievement(player, firstFiveMissions, 5));
                model.addAttribute("firstFiveMission", firstFiveMissions);
            }

            if (runRandomEvent) {
                List<RandomEvent> randomEvents = mission.getRandomEvents();
                randomEvent = randomEvents.get(ThreadLocalRandom.current().nextInt(randomEvents.size()));
            }

            model.addAttribute("randomEvent", randomEvent);

            // Run the actual events logic
            randomEvent.activate(player);
            //boolean complete = mission.activate(player);
            boolean complete = mission.runEvent(player);
            if (complete) {
                mission.complete(player); // give rewards to player
            } else {
                int lostCoins = player.getCoins() / 2;
                player.setCoins(lostCoins);
                model.addAttribute("lostCoins", MathUtil.format(lostCoins));
            }

            model.addAttribute("missionState", complete);
            model.addAttribute("missionActions", ActionRecorder.EVENT_LIST.get(player.getId()));

            // Remove the mission from the player's list so they cant repeat it
            MissionManager.removeMission(player, mission);

            CoreUtilities.getTaskManager().runAsync(() -> PlayerManager.savePlayer(player));
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
                player.removeCoins(RESET_COST);

                Achievement prestigious = Achievement.PRESTIGIOUS;
                if (!AchievementManager.hasCompleted(player, prestigious)) {
                    CoreUtilities.getTaskManager().runAsync(() -> AchievementManager.updateAchievement(player, prestigious, 1));
                    attributes.addFlashAttribute("prestigious", prestigious);
                }

                CoreUtilities.getTaskManager().runAsync(() -> PlayerManager.savePlayer(player));
            } else {
                attributes.addFlashAttribute("resetError", "Not Enough Coins!");
            }
        }

        return redirectView;
    }

    @GetMapping("/home/revive")
    public RedirectView revivePlayer(HttpServletRequest req, RedirectAttributes attributes) {
        RedirectView redirectView = new RedirectView("/home/missions", true);

        User user = Auth.getUser();
        if (user != null) {
            Player player = PlayerManager.getPlayer(user);

            if (player.getCoins() >= REVIVE_COST) {
                attributes.addFlashAttribute("revived", true);
                player.setDead(false);
                player.setHealth(20);
                player.removeCoins(REVIVE_COST);

                CoreUtilities.getTaskManager().runAsync(() -> PlayerManager.savePlayer(player));
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
