package me.themgrf.motivatation.game.missions.events;

import me.themgrf.motivatation.entities.Player;

@FunctionalInterface
public interface Event {

    void activate(Player player);

}
