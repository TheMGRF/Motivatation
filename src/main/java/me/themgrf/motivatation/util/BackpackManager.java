package me.themgrf.motivatation.util;

import me.themgrf.motivatation.game.inventories.Backpack;

import java.util.HashMap;

public class BackpackManager {

    private static final HashMap<Long, Backpack> BACKPACKS = new HashMap<>();

    public static void update(long id, Backpack backpack) {
        BACKPACKS.put(id, backpack);
    }

    public static Backpack get(long id) {
        Backpack backpack = BACKPACKS.get(id);
        if (backpack == null) {
            backpack = new Backpack();
            BACKPACKS.put(id, backpack);
            return backpack;
        }

        return backpack;
    }

    public static HashMap<Long, Backpack> getBackpacks() {
        return BACKPACKS;
    }
}
