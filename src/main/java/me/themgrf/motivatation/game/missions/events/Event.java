package me.themgrf.motivatation.game.missions.events;

import me.themgrf.motivatation.entities.Player;

@FunctionalInterface
public interface Event {

    boolean activate(Player player);

}
