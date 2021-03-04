package me.themgrf.motivatation.game.missions.events;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.events.effects.EventEffect;

public abstract class RandomEvent {

    private final String name, description;
    private final EventEffect effect;

    public RandomEvent(String name, String description, EventEffect effect) {
        this.name = name;
        this.description = description;
        this.effect = effect;
    }

    public abstract void onActivate(Player player);

    public abstract void onEnd(Player player);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public EventEffect getEffect() {
        return effect;
    }
}
