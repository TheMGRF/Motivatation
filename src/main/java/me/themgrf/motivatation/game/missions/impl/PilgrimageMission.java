package me.themgrf.motivatation.game.missions.impl;

import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.MuggingEvent;
import me.themgrf.motivatation.game.missions.events.impl.TripAndFallEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;

import java.util.Arrays;
import java.util.List;

public class PilgrimageMission extends Mission {

    public PilgrimageMission() {
        super("PILGRIMAGE");

        setEvent(player -> {
            System.out.println(player.getName() + " has ran Pilgrimage!");
            return true;
        });
    }

    @Override
    public String getName() {
        return "Pilgrimage";
    }

    @Override
    public String getDescription() {
        return "The Monks of Arigi have requested a supply drop to their remote temple.";
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public DangerLevel getDangerLevel() {
        return DangerLevel.EASY;
    }

    @Override
    public JourneyTime getJourneyTime() {
        return JourneyTime.LONG;
    }

    @Override
    public List<RandomEvent> getRandomEvents() {
        return Arrays.asList(new MuggingEvent(), new TripAndFallEvent());
    }

    @Override
    public List<Reward> getRewards() {
        return Arrays.asList(
                new Reward(RewardType.EXP, 30),
                new Reward(RewardType.COINS, 40)
        );
    }
}
