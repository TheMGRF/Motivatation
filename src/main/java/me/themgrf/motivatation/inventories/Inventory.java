package me.themgrf.motivatation.inventories;

import me.themgrf.motivatation.inventories.items.Item;

import java.util.List;

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

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
