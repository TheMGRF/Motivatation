package me.themgrf.motivatation.game.missions.base;

import me.themgrf.motivatation.Motivatation;
import me.themgrf.motivatation.entities.EntityType;
import me.themgrf.motivatation.entities.LivingEntity;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.Zombie;
import me.themgrf.motivatation.game.damage.DamageHandler;
import me.themgrf.motivatation.game.damage.FightUtil;
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

        ActionRecorder.clearEvents(id);

        for (int i = 0; i < difficulty.getQuantity(); i++) {
            LivingEntity entity = Motivatation.getInstance().getEntity(enemyType);
            entity.setHealth(difficulty.getHealth());

            if (!FightUtil.fight(player, entity)) {
                return false;
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
