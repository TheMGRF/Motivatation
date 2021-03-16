package me.themgrf.motivatation.game.inventories.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemManager {

    private static final HashMap<String, Item> ITEMS = new HashMap<>();

    public static void addItem(Item item) {
        ITEMS.put(item.getId(), item);
    }

    public static void removeItem(Item item) {
        ITEMS.remove(item.getId());
    }

    public static Item getItem(String id) {
        return ITEMS.get(id);
    }

    public static List<Item> itemsFromString(String itemsString) {
        List<Item> items = new ArrayList<>();

        if (itemsString.isEmpty()) return items;

        String[] itemStrings = itemsString.split(",");
        for (String itemString : itemStrings) {
            String[] results = itemString.split(":");
            String itemID = results[0];
            int amount = Integer.parseInt(results[1]);

            ItemStack itemStack = new ItemStack(ItemManager.getItem(itemID), amount);
            for (int i = 0; i < itemStack.getAmount(); i++) {
                items.add(itemStack.getItem());
            }
        }

        return items;
    }

    public static HashMap<String, Item> getItems() {
        return ITEMS;
    }
}
