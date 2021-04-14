package me.themgrf.motivatation.util;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.inventories.items.Item;

public class Economy {

    public static boolean canAfford(Player player, Item item) {
        return canAfford(player, item.getValue());
    }

    public static boolean canAfford(Player player, int value) {
        return player.getCoins() > value;
    }

    public static void purchase(Player player, Item item) {
        purchase(player, item.getValue());
    }

    public static void purchase(Player player, int value) {
        int coins = Math.max(player.getCoins() - value, 0);
        player.setCoins(coins);
    }

}
