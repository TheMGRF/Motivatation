package me.themgrf.motivatation.util;

import me.themgrf.motivatation.entities.Player;

public class LevelCalculator {

    public static final int CONSTANT = 5;

    public static int getLevel(Player player) {
        double exp = player.getExperience();
        int level = (int) (CONSTANT * Math.sqrt(exp)) / 10;

        return Math.max(0, level);
    }

}
