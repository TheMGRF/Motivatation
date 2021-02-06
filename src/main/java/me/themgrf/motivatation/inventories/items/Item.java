package me.themgrf.motivatation.inventories.items;

import me.themgrf.motivatation.inventories.items.attributes.ItemAttribute;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private final String id;

    private String name;
    private Texture texture;
    private List<String> description;
    private ItemRarity rarity;
    private List<ItemAttribute> itemAttributes;

    public Item(String id) {
        this(id, "", Texture.SLIM_IRON_SWORD, new ArrayList<>(), new ArrayList<>(), ItemRarity.COMMON);
    }

    public Item(String id, String name, Texture texture, List<String> description, List<ItemAttribute> itemAttributes, ItemRarity rarity) {
        this.id = id;
        this.name = name;
        this.texture = texture;
        this.description = description;
        this.itemAttributes = itemAttributes;
        this.rarity = rarity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<ItemAttribute> getItemAttributes() {
        return itemAttributes;
    }

    public void setItemAttributes(List<ItemAttribute> itemAttributes) {
        this.itemAttributes = itemAttributes;
    }

    public void addItemAttribute(ItemAttribute itemAttribute) {
        itemAttributes.add(itemAttribute);
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public void setRarity(ItemRarity rarity) {
        this.rarity = rarity;
    }
}
