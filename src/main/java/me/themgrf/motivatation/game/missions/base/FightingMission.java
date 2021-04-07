package me.themgrf.motivatation.game.missions.base;

import me.themgrf.motivatation.Motivatation;
import me.themgrf.motivatation.entities.EntityType;
import me.themgrf.motivatation.entities.LivingEntity;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.Zombie;
import me.themgrf.motivatation.game.damage.DamageHandler;
import me.themgrf.motivatation.game.missions.Difficulty;
import me.themgrf.motivatation.game.missions.actions.ActionRecorder;
import me.themgrf.motivatation.game.missions.actions.Actions;

import java.util.concurrent.ThreadLocalRandom;

public class FightingMission implements BaseMission {

    private final String name;
    private final Difficulty difficulty;
    private final Player player;
    private final EntityType enemyType;

    public FightingMission(String name, Difficulty difficulty, Player player, EntityType enemyType) {
        this.name = name;
        this.difficulty = difficulty;
        this.player = player;
        this.enemyType = enemyType;
    }

    @Override
    public boolean start() {
        System.out.println(player.getName() + " has embarked on " + name + "!");

        long id = player.getId();
        double speed = player.getSpeed();

        ActionRecorder.clearEvents(id);

        for (int i = 0; i < difficulty.getQuantity(); i++) {
            LivingEntity entity = Motivatation.getInstance().getEntity(enemyType);
            entity.setHealth(difficulty.getHealth());

            while (player.getHealth() > 0 || entity.getHealth() > 0) {
                if (player.getHealth() <= 0) {
                    Actions.playerDeath(id, entity);
                    return false;
                }

                if (entity.getHealth() <= 0) {
                    Actions.playerKill(id, entity);
                    break;
                }

                // If player speed is low zombie attacks first
                double rand = ThreadLocalRandom.current().nextDouble(speed);
                if (rand < (speed / 2)) {
                    // player was too slow - zombie attacks
                    int damage = DamageHandler.calculateDamage(entity, player);
                    player.damage(damage);

                    Actions.entityDamagePlayer(id, entity, damage);
                } else {
                    // players speed was good and gets first hit
                    int damage = DamageHandler.calculateDamage(player, entity);
                    entity.damage(damage);

                    Actions.playerDamageEntity(id, entity, damage);
                }
            }
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Player getPlayer() {
        return player;
    }

    public EntityType getEnemyType() {
        return enemyType;
    }
}
