package me.themgrf.motivatation.game.missions.impl.zombies;

import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.TravellingMerchantEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PortZombieHunterMission extends Mission {

    public PortZombieHunterMission() {
        super("KILL_ZOMBIES_2");

        setEvent(player -> {
            System.out.println(player.getName() + " has ran Zombie hunter II!");
            return true;
        });
    }

    @Override
    public String getName() {
        return "Zombie Hunter II";
    }

    @Override
    public String getDescription() {
        return "A nearby port settlement has put an ad out for an adventurer to kill a nearby group of zombies!";
    }

    @Override
    public int getLevel() {
        return 2;
    }

    @Override
    public DangerLevel getDangerLevel() {
        return DangerLevel.EASY;
    }

    @Override
    public JourneyTime getJourneyTime() {
        return JourneyTime.MEDIUM;
    }

    @Override
    public List<RandomEvent> getRandomEvents() {
        return Collections.singletonList(new TravellingMerchantEvent());
    }

    @Override
    public List<Reward> getRewards() {
        return Arrays.asList(
                new Reward(RewardType.EXP, 15),
                new Reward(RewardType.COINS, 10)
        );
    }
}
