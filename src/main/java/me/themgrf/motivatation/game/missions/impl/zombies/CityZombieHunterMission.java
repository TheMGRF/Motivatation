package me.themgrf.motivatation.game.missions.impl.zombies;

import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.MuggingEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CityZombieHunterMission extends Mission {

    public CityZombieHunterMission() {
        super("KILL_ZOMBIES_3");

        setEvent(player -> {
            System.out.println(player.getName() + " has ran Zombie hunter III!");
            return true;
        });
    }

    @Override
    public String getName() {
        return "Zombie Hunter III";
    }

    @Override
    public String getDescription() {
        return "The city of Galen has heard of your zombie slaying skills and wants you to clear out their crypts!";
    }

    @Override
    public int getLevel() {
        return 5;
    }

    @Override
    public DangerLevel getDangerLevel() {
        return DangerLevel.MEDIUM;
    }

    @Override
    public JourneyTime getJourneyTime() {
        return JourneyTime.MEDIUM;
    }

    @Override
    public List<RandomEvent> getRandomEvents() {
        return Collections.singletonList(new MuggingEvent());
    }

    @Override
    public List<Reward> getRewards() {
        return Arrays.asList(
                new Reward(RewardType.EXP, 30),
                new Reward(RewardType.COINS, 20)
        );
    }

}
