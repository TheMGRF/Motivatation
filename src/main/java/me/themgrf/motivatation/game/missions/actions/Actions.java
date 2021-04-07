package me.themgrf.motivatation.game.missions.actions;

import me.themgrf.motivatation.entities.LivingEntity;
import me.themgrf.motivatation.util.Icons;
import me.themgrf.motivatation.util.TUtil;

public class Actions {

    public static void playerDeath(long id, LivingEntity entity) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(Icons.SKULL + " You were killed by a %entity%!", "entity", entity.getName())
        );
    }

    public static void playerKill(long id, LivingEntity entity) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(Icons.SKULL_AND_BONES + "️ You killed a %entity%!", "entity", entity.getName())
        );
    }

    public static void entityDamagePlayer(long id, LivingEntity entity, double damage) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(
                        Icons.BANG + "%entity% damaged you for %damage%" + Icons.HEART,
                        "entity", entity.getName(),
                        "damage", String.valueOf(damage)
                )
        );
    }

    public static void playerDamageEntity(long id, LivingEntity entity, double damage) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(
                        Icons.BANG + "You dealt %damage%" +  Icons.HEART + " to %entity%",
                        "damage", String.valueOf(damage),
                        "entity", entity.getName()
                )
        );
    }

}
