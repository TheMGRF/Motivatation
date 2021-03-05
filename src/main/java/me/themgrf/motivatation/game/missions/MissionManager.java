package me.themgrf.motivatation.game.missions;

import me.themgrf.motivatation.entities.Player;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MissionManager {

    public static final int TOTAL_MISSIONS = 3;
    public static final HashMap<Long, List<Mission>> PLAYER_MISSIONS = new HashMap<>();

    /**
     * Create missions for a player
     *
     * @param player The player to create the missions for
     * @return A list of varying missions for a player
     */
    public static List<Mission> createMissionsForPlayer(Player player) {
        List<Mission> missions = PLAYER_MISSIONS.get(player.getId());
        if (missions != null) return missions;

        missions = getNewMissions(player);

        PLAYER_MISSIONS.put(player.getId(), missions);
        return missions;
    }

    /**
     * Reset a player's missions and give them a whole new set of missions
     *
     * @param player The player's missions to reset
     * @return A new list of varying missions for a player
     */
    public static List<Mission> reset(Player player) {
        return PLAYER_MISSIONS.put(player.getId(), getNewMissions(player));
    }

    /**
     * Get a new list of missions for a player
     *
     * @param player The player to get the new missions for
     * @return The list of new missions
     */
    private static List<Mission> getNewMissions(Player player) {
        List<Mission> missions = new ArrayList<>(TOTAL_MISSIONS);
        boolean safe = false;

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

    /**
     * Add a mission to a player's mission set
     *
     * @param player  The player to add the mission to
     * @param mission The mission to add
     */
    public static void addMission(Player player, Mission mission) {
        List<Mission> missions = PLAYER_MISSIONS.get(player.getId());

        if (missions == null) missions = new ArrayList<>();
        missions.add(mission);

        PLAYER_MISSIONS.put(player.getId(), missions);
    }

    /**
     * Remove a mission from a player's set of missions
     *
     * @param player  The player to remove the mission from
     * @param mission The mission to remove
     */
    public static void removeMission(Player player, Mission mission) {
        List<Mission> missions = PLAYER_MISSIONS.get(player.getId());
        if (missions == null) return;

        missions.remove(mission);

        PLAYER_MISSIONS.put(player.getId(), missions);
    }

}
