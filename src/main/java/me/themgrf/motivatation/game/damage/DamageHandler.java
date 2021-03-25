package me.themgrf.motivatation.game.damage;

import me.themgrf.motivatation.entities.LivingEntity;
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

        //double damage = source.getStrength();
        double damage = ThreadLocalRandom.current().nextDouble(sourceStrength / 2, sourceStrength);
        // TODO: Add damage from weapon?

        // Target defence lower impact
        damage = damage * (100 / (100 + targetDefence));

        return MathUtil.round(damage);
    }

}
