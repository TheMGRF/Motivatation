package me.themgrf.motivatation.game.inventories.items;

import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ItemManager {

    private static final HashMap<String, Item> ITEMS = new HashMap<>();

    public static void addItem(Item item) {
        ITEMS.put(item.getId(), item);
    }

    public static void removeItem(Item item) {
        ITEMS.remove(item.getId());
    }

    @Nullable
    public static Item getItem(String id) {
        Item item = ITEMS.get(id);
        if (item == null) return null;

        // make sure items have a UUID
        item.setInternalID(UUID.randomUUID());
        return item;
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
