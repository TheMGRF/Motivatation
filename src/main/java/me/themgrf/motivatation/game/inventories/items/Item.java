package me.themgrf.motivatation.game.inventories.items;

import me.themgrf.motivatation.game.inventories.items.attributes.ItemAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Item {

    private final UUID internalID;
    private final String id;

    private String name;
    private Texture texture;
    private List<String> description;
    private ItemRarity rarity;
    private List<ItemAttribute> itemAttributes;
    private int value;

    public Item(String id) {
        this(id, "", Texture.SLIM_IRON_SWORD, new ArrayList<>(), new ArrayList<>(), ItemRarity.COMMON, 10);
    }

    public Item(String id, String name, Texture texture, List<String> description, List<ItemAttribute> itemAttributes, ItemRarity rarity) {
        this(id, name, texture, description, itemAttributes, rarity, 10);
    }

    public Item(String id, String name, Texture texture, List<String> description, List<ItemAttribute> itemAttributes, ItemRarity rarity, int value) {
        this.internalID = UUID.randomUUID();
        this.id = id;
        this.name = name;
        this.texture = texture;
        this.description = description;
        this.itemAttributes = itemAttributes;
        this.rarity = rarity;
        this.value = value;
    }

    public UUID getInternalID() {
        return internalID;
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

    public void addItemAttributes(ItemAttribute... itemAttributes) {
        this.itemAttributes.addAll(Arrays.asList(itemAttributes));
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
