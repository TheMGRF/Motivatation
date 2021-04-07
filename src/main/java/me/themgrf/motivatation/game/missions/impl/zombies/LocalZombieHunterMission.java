package me.themgrf.motivatation.game.missions.impl.zombies;

import me.themgrf.motivatation.entities.EntityType;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.Difficulty;
import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.base.FightingMission;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.TravellingMerchantEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LocalZombieHunterMission extends Mission {

    public LocalZombieHunterMission() {
        super("KILL_ZOMBIES_1");
    }

    @Override
    public String getName() {
        return "Zombie Hunter I";
    }

    @Override
    public String getDescription() {
        return "A local town has put an ad out for an adventurer to kill a nearby group of zombies!";
    }

    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public DangerLevel getDangerLevel() {
        return DangerLevel.EASY;
    }

    @Override
    public JourneyTime getJourneyTime() {
        return JourneyTime.SHORT;
    }

    @Override
    public List<RandomEvent> getRandomEvents() {
        return Collections.singletonList(new TravellingMerchantEvent());
    }

    @Override
    public boolean runEvent(Player player) {
        FightingMission fight = new FightingMission(getName(), Difficulty.EASY, player, EntityType.ZOMBIE);
        return fight.start();
    }

    @Override
    public List<Reward> getRewards() {
        return Arrays.asList(
                new Reward(RewardType.EXP, 10),
                new Reward(RewardType.COINS, 5)
        );
    }
}
