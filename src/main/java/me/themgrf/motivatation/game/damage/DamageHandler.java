package me.themgrf.motivatation.game.damage;

import me.themgrf.motivatation.entities.LivingEntity;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.inventories.items.Item;
import me.themgrf.motivatation.game.inventories.items.attributes.HealthAttribute;
import me.themgrf.motivatation.game.inventories.items.attributes.ItemAttribute;
import me.themgrf.motivatation.game.missions.actions.Actions;
import me.themgrf.motivatation.util.MathUtil;

import java.util.concurrent.ThreadLocalRandom;

public class DamageHandler {

    /**
     * Calculate an entity's damage using formula: attack * (100 / (100 + defence))
     *
     * @param source The entity to calculate the damage for
     * @param target The target entity who's defence to use
     * @return The total damage for the source to deal to the target
     */
    public static int calculateDamage(LivingEntity source, LivingEntity target) {
        double sourceStrength = source.getStrength();
        double targetDefence = target.getDefence();

        double damage = ThreadLocalRandom.current().nextDouble(sourceStrength / 2, sourceStrength);
        if (targetDefence <= 0) {
            return (int) damage;
        }

        // If the source is a player check their current weapon for extra damage
        if (source instanceof Player) {
            Item weapon = FightUtil.getFightingWeapon((Player) source);
            if (weapon != null) {
                for (ItemAttribute attribute : weapon.getItemAttributes()) {
                    if (attribute instanceof HealthAttribute) {
                        damage += attribute.getAmount();
                        break;
                    }
                }
            }
        }

        // Target defence lower impact
        double calc = (100 / (100 + targetDefence));
        double defence = damage - calc;
        damage = damage * calc;
        if (target instanceof Player) {
            Actions.defenceKickedIn(((Player) target).getId(), (int) defence);
        }

        return MathUtil.round(damage);
    }

}
