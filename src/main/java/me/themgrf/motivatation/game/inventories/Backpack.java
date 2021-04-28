package me.themgrf.motivatation.game.inventories;

import me.themgrf.motivatation.game.inventories.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Backpack extends Inventory {

    public Backpack() {
        this("Backpack");
    }

    public Backpack(String name) {
        this(name, 9, new ArrayList<>());
    }

    public Backpack(String name, int size, List<Item> items) {
        super(name, size, items);
    }
}
