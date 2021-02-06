package me.themgrf.motivatation.inventories.items;

import me.themgrf.motivatation.util.Colour;
import org.thymeleaf.util.StringUtils;

public enum ItemRarity {

    COMMON(Colour.WHITE),
    UNCOMMON(Colour.GREEN),
    RARE(Colour.BLUE),
    EPIC(Colour.PURPLE),
    LEGENDARY(Colour.ORANGE),
    MYTHIC(Colour.CYAN),
    SPECIAL(Colour.RED);

    private final String colour;

    ItemRarity(String color) {
        this.colour = color;
    }

    public String getColour() {
        return colour;
    }

    public String getName() {
        return StringUtils.capitalize(name().toLowerCase());
    }


}
