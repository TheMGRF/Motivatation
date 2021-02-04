package me.themgrf.motivatation.util.inventory;

import me.themgrf.motivatation.inventories.items.Item;
import me.themgrf.motivatation.inventories.items.attributes.ItemAttribute;

import java.util.List;

public class ItemBuilder {

    private final Item item;

    public ItemBuilder(String id) {
        this.item = new Item(id);
    }

    public ItemBuilder setName(String name) {
        item.setName(name);
        return this;
    }

    public ItemBuilder setDescription(List<String> description) {
        item.setDescription(description);
        return this;
    }

    public ItemBuilder setItemAttributes(List<ItemAttribute> itemAttributes) {
        item.setItemAttributes(itemAttributes);
        return this;
    }

    public ItemBuilder addItemAttribute(ItemAttribute itemAttribute) {
        item.addItemAttribute(itemAttribute);
        return this;
    }

    public Item get() {
        return item;
    }
}
