package me.themgrf.motivatation.game.missions.impl.zombies;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.Zombie;
import me.themgrf.motivatation.game.damage.DamageHandler;
import me.themgrf.motivatation.game.missions.ActionRecorder;
import me.themgrf.motivatation.game.missions.Mission;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.impl.TravellingMerchantEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;
import me.themgrf.motivatation.util.Icons;
import me.themgrf.motivatation.util.MathUtil;
import me.themgrf.motivatation.util.TUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
        System.out.println(player.getName() + " has embarked on Zombie hunter I!");

        long id = player.getId();
        double speed = player.getSpeed();
        double defence = player.getDefence();
        double strength = player.getStrength();

        ActionRecorder.clearEvents(id);

        for (int i = 0; i < 5; i++) {
            Zombie zombie = new Zombie();

            //for (int j = 0; j < 4; j++) {
            while (player.getHealth() > 0 || zombie.getHealth() > 0) {
                if (player.getHealth() <= 0) {
                    ActionRecorder.addEvent(
                            id,
                            TUtil.getMessage(Icons.SKULL + " You were killed by a %entity%!", "entity", zombie.getName())
                    );
                    return false;
                }

                if (zombie.getHealth() <= 0) {
                    ActionRecorder.addEvent(
                            id,
                            TUtil.getMessage(Icons.SKULL_AND_BONES + "️ You killed a %entity%!", "entity", zombie.getName())
                    );
                    break;
                }

                // If player speed is low zombie attacks first
                double rand = ThreadLocalRandom.current().nextDouble(speed);
                if (rand < (speed / 2)) {
                    // player was too slow - zombie attacks
                    int damage = DamageHandler.calculateDamage(zombie, player);
                    player.damage(damage);

                    ActionRecorder.addEvent(
                            id,
                            TUtil.getMessage(
                                    Icons.BANG + "%entity1% damaged %entity2% for %damage%" + Icons.HEART,
                                    "entity1", zombie.getName(),
                                    "entity2", player.getName(),
                                    "damage", String.valueOf(damage)
                            )
                    );
                } else {
                    // players speed was good and gets first hit
                    int damage = DamageHandler.calculateDamage(player, zombie);
                    zombie.damage(damage);

                    ActionRecorder.addEvent(
                            id,
                            TUtil.getMessage(
                                    Icons.BANG + "You dealt %damage%" +  Icons.HEART + " to %entity%",
                                    "damage", String.valueOf(damage),
                                    "entity", zombie.getName()
                            )
                    );
                }
            }
        }

        return true;
    }

    @Override
    public List<Reward> getRewards() {
        return Arrays.asList(
                new Reward(RewardType.EXP, 10),
                new Reward(RewardType.COINS, 5)
        );
    }
}
