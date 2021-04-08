package me.themgrf.motivatation.game.missions.impl;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.actions.Actions;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.MuggingEvent;
import me.themgrf.motivatation.game.missions.events.impl.TripAndFallEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PilgrimageMission extends Mission {

    private static final int MAX_TIP = 8;

    public PilgrimageMission() {
        super("PILGRIMAGE");
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
    public boolean runEvent(Player player) {
        long id = player.getId();
        double speed = player.getSpeed();
        double intelligence = player.getIntelligence();

        double rand = ThreadLocalRandom.current().nextDouble(speed);
        if (rand < (speed / 2)) {
            player.setHealth(player.getHealth() - 2);
            Actions.selfDamage(id, 2, "Low Stamina");
        }

        Actions.deliveryMade(id, "the Monks");

        // give the player an extra tip if they were smart enough
        rand = ThreadLocalRandom.current().nextDouble(intelligence);
        if (rand < (intelligence / 2)) {
            Reward tip = new Reward(RewardType.COINS, ThreadLocalRandom.current().nextInt(MAX_TIP));
            Actions.tip(id, tip);
            player.giveReward(tip);
            Actions.addReward(id, tip);
        }

        return true;
    }

    @Override
    public List<Reward> getRewards() {
        return Arrays.asList(
                new Reward(RewardType.EXP, 30),
                new Reward(RewardType.COINS, 40)
        );
    }
}
