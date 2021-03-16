package me.themgrf.motivatation.game.missions.events.effects;

public class EventEffect {

    private final String name;
    private final EventEffectType type;

    public EventEffect(String name, EventEffectType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public EventEffectType getType() {
        return type;
    }
}
