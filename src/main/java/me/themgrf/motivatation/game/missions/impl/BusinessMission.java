package me.themgrf.motivatation.game.missions.impl;

import me.themgrf.motivatation.entities.NPC;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.damage.FightUtil;
import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.actions.ActionRecorder;
import me.themgrf.motivatation.game.missions.actions.Actions;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.MuggingEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BusinessMission extends Mission {

    private static final int MAX_STOLEN = 100;

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
        System.out.println(player.getName() + " has embarked on " + getName() + "!");

        long id = player.getId();
        double intelligence = player.getIntelligence();
        double speed = player.getSpeed();

        ActionRecorder.clearEvents(id);

        Actions.travelToProperty(id);

        // If player is smart enough find a way inside
        double rand = ThreadLocalRandom.current().nextDouble(intelligence);
        if (rand > (intelligence / 2)) {
            Actions.sneakInside(id, true);

            // creaky floorboard chance
            rand = ThreadLocalRandom.current().nextDouble(speed);
            if (rand > (speed / 2)) {
                Actions.creakyFloorboard(id);

                NPC npc = new NPC("Property Owner");
                npc.setStrength(player.getStrength() / 2);

                if (!FightUtil.fight(player, npc)) return false;
            }

            Actions.stealValuables(id);
            Reward stolen = new Reward(RewardType.COINS, ThreadLocalRandom.current().nextInt(MAX_STOLEN));
            player.giveReward(stolen);
            Actions.addReward(id, stolen);
        } else {
            Actions.sneakInside(id, false);
        }


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
