package me.themgrf.motivatation.game.missions.impl;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.MuggingEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BusinessMission extends Mission {

    public BusinessMission() {
        super("BUSINESS");
    }

    @Override
    public String getName() {
        return "Taking Care of Business";
    }

    @Override
    public String getDescription() {
        return "The mysterious Thieves Guild reached out to you about helping them \"re-acquire\" some of their lost belongings.";
    }

    @Override
    public int getLevel() {
        return 10;
    }

    @Override
    public DangerLevel getDangerLevel() {
        return DangerLevel.HARD;
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
    public boolean runEvent(Player player) {
        return true;
    }

    @Override
    public List<Reward> getRewards() {
        return Arrays.asList(
                new Reward(RewardType.EXP, 40),
                new Reward(RewardType.COINS, 80)
        );
    }
}
