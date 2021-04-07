package me.themgrf.motivatation.game.missions.impl.zombies;

import me.themgrf.motivatation.entities.EntityType;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.Zombie;
import me.themgrf.motivatation.game.damage.DamageHandler;
import me.themgrf.motivatation.game.missions.Difficulty;
import me.themgrf.motivatation.game.missions.actions.ActionRecorder;
import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.actions.Actions;
import me.themgrf.motivatation.game.missions.base.FightingMission;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.TravellingMerchantEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;
import me.themgrf.motivatation.util.Icons;
import me.themgrf.motivatation.util.TUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PortZombieHunterMission extends Mission {

    public PortZombieHunterMission() {
        super("KILL_ZOMBIES_2");
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
    public boolean runEvent(Player player) {
        FightingMission fight = new FightingMission(getName(), Difficulty.MEDIUM, player, EntityType.ZOMBIE);
        return fight.run();
    }

    @Override
    public List<Reward> getRewards() {
        return Arrays.asList(
                new Reward(RewardType.EXP, 15),
                new Reward(RewardType.COINS, 10)
        );
    }
}
