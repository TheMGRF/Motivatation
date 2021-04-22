package me.themgrf.motivatation.game.inventories;

import me.themgrf.motivatation.game.inventories.items.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    private String name;
    private int size;
    private List<Item> items;

    public Inventory(String name, int size, List<Item> items) {
        this.name = name;
        this.size = size;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addItems(List<Item> items) {
        this.items.addAll(items);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        HashMap<String, Integer> itemMap = new HashMap<>();

        for (Item item : items) {
            String id = item.getId();

            itemMap.merge(id, 1, Integer::sum);
        }

        int loop = 0;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue());
            if (loop != itemMap.size() - 1) {
                sb.append(",");
            }
            loop++;
        }

        return sb.toString();
    }
}
