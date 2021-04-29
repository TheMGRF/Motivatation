package me.themgrf.motivatation.controllers.home;

import me.themgrf.motivatation.controllers.ControllerBase;
import me.themgrf.motivatation.database.PlayerManager;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.game.achievement.Achievement;
import me.themgrf.motivatation.game.achievement.AchievementManager;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.tasks.Task;
import me.themgrf.motivatation.game.tasks.TaskManager;
import me.themgrf.motivatation.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import xyz.minecrossing.coreutilities.CoreUtilities;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TasksController extends ControllerBase {

    @GetMapping("/home/tasks")
    public String tasks(Model model) {
        model = super.setup(model);

        User user = Auth.getUser();
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            Player player = PlayerManager.getPlayer(user);
            model.addAttribute("player", player);
            model.addAttribute("tasks", TaskManager.getTasks(player));
            model.addAttribute("newTask", new Task());
        }

        return "home/tasks";
    }

    @PostMapping("/home/tasks/add")
    public RedirectView buyItem(@ModelAttribute Task task, HttpServletRequest req, RedirectAttributes attributes) {
        RedirectView redirectView = new RedirectView("/home/tasks", true);

        User user = Auth.getUser();
        if (user != null) {
            // Make sure main reward is up to date
            if (task.getFormReward() != Reward.DEFAULT) {
                task.setReward(task.getFormReward());
            }

            System.out.println("User " + user.getUsername() + " has added a new task: " + task.getName());

            attributes.addFlashAttribute("username", user.getUsername());
            Player player = PlayerManager.getPlayer(user);
            TaskManager.addTask(player, task);

            Achievement firstTask = Achievement.FIRST_TASK;
            if (!player.hasAchievement(firstTask)) {
                CoreUtilities.getTaskManager().runAsync(() -> AchievementManager.updateAchievement(player, firstTask, 1));
            }

            Achievement fiveTasks = Achievement.FIVE_TASKS;
            if (!player.hasAchievement(fiveTasks) && TaskManager.getTasks(player).size() > 5) {
                CoreUtilities.getTaskManager().runAsync(() -> AchievementManager.updateAchievement(player, fiveTasks, 5));
            }

            Achievement tenTasks = Achievement.TEN_TASKS;
            if (!player.hasAchievement(tenTasks) && TaskManager.getTasks(player).size() > 10) {
                CoreUtilities.getTaskManager().runAsync(() -> AchievementManager.updateAchievement(player, tenTasks, 10));
            }

            CoreUtilities.getTaskManager().runAsync(() -> PlayerManager.savePlayer(player));
        }

        return redirectView;
    }

    @RequestMapping("/home/tasks/complete/{uuid}")
    public RedirectView completeTask(HttpServletRequest req, RedirectAttributes attributes, @PathVariable String uuid) {
        RedirectView redirectView = new RedirectView("/home/tasks", true);

        User user = Auth.getUser();
        if (user != null) {
            Player player = PlayerManager.getPlayer(user);
            for (Task task : TaskManager.getTasks(player)) {
                if (task.getUUID().toString().equals(uuid)) {
                    task.setDone(true);

                    player.giveReward(task.getReward());

                    // save tasks to db
                    CoreUtilities.getTaskManager().runAsync(() -> TaskManager.saveTasks(player));

                    attributes.addFlashAttribute("taskCompleted", task.getReward().toString());
                    System.out.println("User " + user.getUsername() + " has completed task: " + task.getName());
                    break;
                }
            }
        }

        return redirectView;
    }

    @Override
    public String getPageName() {
        return "Motivatation | Home";
    }

}
