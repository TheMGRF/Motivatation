package me.themgrf.motivatation.game.missions;

import me.themgrf.motivatation.game.missions.impl.BusinessMission;
import me.themgrf.motivatation.game.missions.impl.PilgrimageMission;
import me.themgrf.motivatation.game.missions.impl.zombies.CityZombieHunterMission;
import me.themgrf.motivatation.game.missions.impl.zombies.LocalZombieHunterMission;
import me.themgrf.motivatation.game.missions.impl.zombies.PortZombieHunterMission;

public enum Missions {

    KILL_ZOMBIES_1(new LocalZombieHunterMission()),
    KILL_ZOMBIES_2(new PortZombieHunterMission()),
    KILL_ZOMBIES_3(new CityZombieHunterMission()),
    PILGRIMAGE(new PilgrimageMission()),
    BUSINESS(new BusinessMission());

    public static final Missions[] VALUES = values();

    private final Mission mission;

    Missions(Mission mission) {
        this.mission = mission;
    }

    public Mission getMission() {
        return mission;
    }
}
