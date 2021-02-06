package me.themgrf.motivatation.util.inventory;

import me.themgrf.motivatation.inventories.items.Item;
import me.themgrf.motivatation.inventories.items.ItemRarity;
import me.themgrf.motivatation.inventories.items.Texture;
import me.themgrf.motivatation.inventories.items.attributes.ItemAttribute;

import java.util.List;

public class ItemBuilder {

    private final Item item;

    public ItemBuilder(String id) {
        this.item = new Item(id);
    }

    public ItemBuilder name(String name) {
        item.setName(name);
        return this;
    }

    public ItemBuilder texture(Texture texture) {
        item.setTexture(texture);
        return this;
    }

    public ItemBuilder description(List<String> description) {
        item.setDescription(description);
        return this;
    }

    public ItemBuilder setItemAttributes(List<ItemAttribute> itemAttributes) {
        item.setItemAttributes(itemAttributes);
        return this;
    }

    public ItemBuilder addItemAttributes(ItemAttribute... itemAttributes) {
        item.addItemAttributes(itemAttributes);
        return this;
    }

    public ItemBuilder addItemAttribute(ItemAttribute itemAttribute) {
        item.addItemAttribute(itemAttribute);
        return this;
    }

    public ItemBuilder rarity(ItemRarity rarity) {
        item.setRarity(rarity);
        return this;
    }

    public Item get() {
        return item;
    }
}
