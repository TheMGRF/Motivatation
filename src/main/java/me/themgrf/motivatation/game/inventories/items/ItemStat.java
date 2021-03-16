package me.themgrf.motivatation.game.inventories.items;

public enum ItemStat {

    HEALTH("Health", "Gives a boost to the player's health."),
    REGENERATION("Regeneration", "Provides a regeneration buff to the player."),
    STRENGTH("Strength", "Gives additional strength for attacks."),
    DEFENCE("Defence", "Reduces the player's damage taken."),
    SPEED("Speed", "Increases the player' speed."),
    INTELLIGENCE("Intelligence", "Boosts the player's intelligence.");

    private final String name, description;

    ItemStat(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
