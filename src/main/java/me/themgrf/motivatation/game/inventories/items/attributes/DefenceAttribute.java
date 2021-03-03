package me.themgrf.motivatation.game.inventories.items.attributes;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.inventories.items.ItemStat;
import me.themgrf.motivatation.util.Colour;

public class DefenceAttribute extends me.themgrf.motivatation.game.inventories.items.attributes.ItemAttribute {

    public DefenceAttribute(int amount) {
        this(amount, true);
    }

    public DefenceAttribute(int amount, boolean positive) {
        super("DEFENCE", "Defence", Colour.YELLOW, ItemStat.DEFENCE, amount, positive);
    }

    @Override
    public void applyEffect(Player player) {

    }
}
