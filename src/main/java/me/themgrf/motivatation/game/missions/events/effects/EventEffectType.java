package me.themgrf.motivatation.game.missions.events.effects;

import me.themgrf.motivatation.util.Colour;

public enum EventEffectType {

    NEGATIVE(Colour.RED),
    NEUTRAL(Colour.ORANGE),
    POSITIVE(Colour.GREEN);

    private final String colour;

    EventEffectType(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}
