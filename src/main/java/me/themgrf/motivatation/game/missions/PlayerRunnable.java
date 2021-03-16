package me.themgrf.motivatation.game.missions;

import me.themgrf.motivatation.entities.Player;

@FunctionalInterface
public interface PlayerRunnable {

    boolean activate(Player player);

}
