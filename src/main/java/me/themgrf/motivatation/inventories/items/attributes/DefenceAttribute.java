package me.themgrf.motivatation.inventories.items.attributes;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.inventories.items.ItemStat;

public class DefenceAttribute extends ItemAttribute {

    public DefenceAttribute(int amount) {
        this(amount, true);
    }

    public DefenceAttribute(int amount, boolean positive) {
        super("DEFENCE", "Defence", ItemStat.DEFENCE, amount, positive);
    }

    @Override
    public void applyEffect(Player player) {

    }
}
