package me.themgrf.motivatation.game.missions.events;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.events.effects.EventEffect;

public abstract class RandomEvent implements Event {

    private final String name, description;
    private final RandomEventType type;
    private final EventEffect effect;

    public RandomEvent(String name, String description, RandomEventType type, EventEffect effect) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.effect = effect;
    }

    @Override
    public boolean activate(Player player) {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public RandomEventType getType() {
        return type;
    }

    public EventEffect getEffect() {
        return effect;
    }
}
