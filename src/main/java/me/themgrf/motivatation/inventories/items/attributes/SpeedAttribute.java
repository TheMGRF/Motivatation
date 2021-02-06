package me.themgrf.motivatation.inventories.items.attributes;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.inventories.items.ItemStat;
import me.themgrf.motivatation.util.Colour;

public class SpeedAttribute extends ItemAttribute {

    public SpeedAttribute(int amount) {
        this(amount, true);
    }

    public SpeedAttribute(int amount, boolean positive) {
        super("SPEED", "Speed", Colour.CYAN, ItemStat.SPEED, amount, positive);
    }

    @Override
    public void applyEffect(Player player) {

    }

}
