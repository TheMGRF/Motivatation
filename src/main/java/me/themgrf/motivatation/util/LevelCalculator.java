package me.themgrf.motivatation.util;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.achievement.Achievement;
import me.themgrf.motivatation.game.achievement.AchievementManager;
import xyz.minecrossing.coreutilities.CoreUtilities;

public class LevelCalculator {

    public static final int CONSTANT = 5;

    public static int getLevel(Player player) {
        double exp = player.getExperience();
        int level = (int) (CONSTANT * Math.sqrt(exp)) / 10;

        if (level >= 5) {
            Achievement achievement = Achievement.APPRENTICE;
            if (!player.hasAchievement(achievement)) {
                CoreUtilities.getTaskManager().runAsync(() -> AchievementManager.updateAchievement(player, achievement, 5));
            }
        }
        if (level >= 10) {
            Achievement achievement = Achievement.ADEPT;
            if (!player.hasAchievement(achievement)) {
                CoreUtilities.getTaskManager().runAsync(() -> AchievementManager.updateAchievement(player, achievement, 10));
            }
        }
        if (level >= 25) {
            Achievement achievement = Achievement.EXPERT;
            if (!player.hasAchievement(achievement)) {
                CoreUtilities.getTaskManager().runAsync(() -> AchievementManager.updateAchievement(player, achievement, 25));
            }
        }
        if (level >= 50) {
            Achievement achievement = Achievement.MASTER;
            if (!player.hasAchievement(achievement)) {
                CoreUtilities.getTaskManager().runAsync(() -> AchievementManager.updateAchievement(player, achievement, 50));
            }
        }

        return Math.max(0, level);
    }

}
