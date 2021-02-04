package me.themgrf.motivatation.inventories.items.attributes;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.inventories.items.ItemStat;

public class HealthAttribute extends ItemAttribute {

    public HealthAttribute(int amount) {
        this(amount, true);
    }

    public HealthAttribute(int amount, boolean positive) {
        super("HEALTH", "Health", ItemStat.HEALTH, amount, positive);
    }

    @Override
    public void applyEffect(Player player) {

    }
}
