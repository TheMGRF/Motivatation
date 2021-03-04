package me.themgrf.motivatation.game.rewards;

import me.themgrf.motivatation.util.Colour;
import org.springframework.util.StringUtils;

public enum RewardType {

    EXP(Colour.GREEN, "fad fa-sparkles"),
    COINS(Colour.GOLD, "fas fa-coins"),
    GEMS(Colour.CYAN, "far fa-gem");

    private final String colour, icon;

    RewardType(String colour, String icon) {
        this.colour = colour;
        this.icon = icon;
    }

    public String getColour() {
        return colour;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return StringUtils.capitalize(name().toLowerCase());
    }
}
