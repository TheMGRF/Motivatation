package me.themgrf.motivatation.util.inventory;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.inventories.Inventory;
import me.themgrf.motivatation.inventories.items.Item;

import java.util.ArrayList;
import java.util.List;

public class InventoryCreator {

    public static Inventory create(String name) {
        return create(name, Size.ONE, new ArrayList<>());
    }

    public static Inventory create(String name, int size) {
        return create(name, size, new ArrayList<>());
    }

    public static Inventory create(String name, int size, List<Item> items) {
        return new Inventory(name, size, items);
    }

    public static Inventory createEmptyPlayerInventory(Player player) {
        return create(player.getName() + "'s Inventory", Size.THREE);
    }

}
