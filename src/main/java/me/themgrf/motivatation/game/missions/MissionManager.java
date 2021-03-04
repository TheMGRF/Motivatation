package me.themgrf.motivatation.game.missions;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.events.impl.TravellingMerchantEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        List<Mission> missions = new ArrayList<>(TOTAL_MISSIONS);

        for (int i = 1; i < TOTAL_MISSIONS + 1; i++) {
            missions.add(
                    new MissionBuilder()
                            .setName("Test mission " + i)
                            .setDescription("Go kill " + 3 * i + " zombies")
                            .setLevel(1)
                            .setDangerLevel(Mission.DangerLevel.EASY)
                            .setJourneyTime(Mission.JourneyTime.SHORT)
                            .setRandomEvents(Collections.singletonList(new TravellingMerchantEvent()))
                            .setRewards(
                                    Arrays.asList(
                                            new Reward(RewardType.EXP, 10 * i),
                                            new Reward(RewardType.COINS, 5 * i)
                                    )
                            )
                            .createMission()
            );
        }

        return missions;
    }

}
