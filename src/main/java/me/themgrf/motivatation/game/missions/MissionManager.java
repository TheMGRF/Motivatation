package me.themgrf.motivatation.game.missions;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.events.impl.TravellingMerchantEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MissionManager {

    public static final int TOTAL_MISSIONS = 3;

    /**
     * Create missions for a player
     *
     * @param player The player to create the missions for
     * @return A list of varying missions for a player
     */
    public static List<Mission> createMissionsForPlayer(Player player) {
        //int totalMissions = 3 * player.getLevel();

        boolean safe = false;

        List<Mission> missions = new ArrayList<>(TOTAL_MISSIONS);

        for (int i = 1; i < TOTAL_MISSIONS + 1;) {
            Mission mission = Missions.VALUES[ThreadLocalRandom.current().nextInt(Missions.VALUES.length)].getMission();
            if (mission.getLevel() <= player.getLevel()) {
                safe = true;
            }
            if (safe) {
                missions.add(mission);
                i++;
            }
        }

        return missions;
    }

}
