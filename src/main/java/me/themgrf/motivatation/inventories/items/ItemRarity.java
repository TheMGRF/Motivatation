package me.themgrf.motivatation.inventories.items;

import org.thymeleaf.util.StringUtils;

import java.awt.*;

public enum ItemRarity {

    COMMON(Color.WHITE),
    UNCOMMON(Color.GRAY),
    RARE(Color.BLUE),
    EPIC(Color.MAGENTA),
    LEGENDARY(Color.ORANGE),
    MYTHIC(Color.CYAN),
    SUPREME(Color.GREEN),
    SPECIAL(Color.YELLOW),
    VERY_SPECIAL(Color.RED);

    private final Color color;

    ItemRarity(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getColorAsHex() {
        // TODO: add a 0 to fix V
        return "#" + Integer.toHexString(color.getRed()) + Integer.toHexString(color.getGreen()) + Integer.toHexString(color.getBlue());
    }

    public String getName() {
        return StringUtils.capitalize(name().toLowerCase());
    }


}
