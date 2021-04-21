package me.themgrf.motivatation.game.inventories.items.attributes;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.inventories.items.ItemStat;
import me.themgrf.motivatation.util.Colour;

public class HealthAttribute extends ItemAttribute {

    public HealthAttribute(int amount) {
        this(amount, true);
    }

    public HealthAttribute(int amount, boolean positive) {
        super("HEALTH", "Health", Colour.RED, ItemStat.HEALTH, amount, positive);
    }

    @Override
    public void applyEffect(Player player) {
        player.setHealth(player.getHealth() + getAmount());
    }
}
