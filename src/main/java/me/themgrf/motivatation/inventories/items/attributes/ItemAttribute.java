package me.themgrf.motivatation.inventories.items.attributes;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.inventories.items.ItemStat;

public abstract class ItemAttribute {

    private final String id, name;
    private final ItemStat stat;
    private final int amount;
    private final boolean positive;

    public ItemAttribute(String id, String name, ItemStat stat, int amount) {
        this(id, name, stat, amount, true);
    }

    public ItemAttribute(String id, String name, ItemStat stat, int amount, boolean positive) {
        this.id = id;
        this.name = name;
        this.stat = stat;
        this.amount = amount;
        this.positive = positive;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return getNegativePositive() + getAmount() + " " + getName();
    }

    public ItemStat getStat() {
        return stat;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isPositive() {
        return positive;
    }

    public String getSymbol() {
        return "";
    }

    public String getNegativePositive() {
        return isPositive() ? "+" : "-";
    }

    public abstract void applyEffect(Player player);
}