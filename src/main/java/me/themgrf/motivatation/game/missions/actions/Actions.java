package me.themgrf.motivatation.game.missions.actions;

import me.themgrf.motivatation.entities.LivingEntity;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.util.Icons;
import me.themgrf.motivatation.util.TUtil;

public class Actions {

    public static void addReward(long id, Reward reward) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(Icons.MONEY_BAG + " You earned %icon%%reward%!",
                        "icon", reward.getRewardType().getIcon(),
                        "reward", "" + reward.getAmount()
                )
        );
    }

    public static void selfDamage(long id, int damage, String source) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(Icons.HEART + " You took %damage% damage from %source%!",
                        "damage", "" + damage,
                        "source", source
                )
        );
    }

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

    public static void playerHeal(long id, String item, int amount) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(Icons.POTION + "️ You healed yourself with a %item% for +%amount%!",
                        "item", item,
                        "amount", "" + amount)
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

    public static void travelToProperty(long id) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(Icons.WALKING + "You travelled to the property")
        );
    }

    public static void sneakInside(long id, boolean successful) {
        if (successful) {
            ActionRecorder.addEvent(
                    id,
                    TUtil.getMessage(Icons.OLD_HOUSE + "You found a way into the property")
            );
        } else {
            ActionRecorder.addEvent(
                    id,
                    TUtil.getMessage(Icons.OLD_HOUSE + "You failed to find a way into the property")
            );
        }
    }

    public static void creakyFloorboard(long id) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(Icons.WOOD + "You stumbled onto a creaky floorboard and woke the property owner")
        );
    }

    public static void stealValuables(long id) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(Icons.TROPHY + "You successfully stole the valuables from the property")
        );
    }

    public static void deliveryMade(long id, String source) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(Icons.TROPHY + "You successfully delivered the valuables to %source%",
                        "source", source)
        );
    }

    public static void tip(long id, Reward reward) {
        ActionRecorder.addEvent(
                id,
                TUtil.getMessage(Icons.SPARKLE + "You were tipped %icon%%reward% for your speed",
                        "icon", reward.getRewardType().getIcon(),
                        "reward", "" + reward.getAmount()
                )
        );
    }

}
