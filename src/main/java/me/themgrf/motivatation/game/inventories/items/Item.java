package me.themgrf.motivatation.game.inventories.items;

import me.themgrf.motivatation.game.inventories.items.attributes.ItemAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Item {

    private final String id;

    private UUID internalID;
    private String name;
    private Texture texture;
    private List<String> description;
    private ItemRarity rarity;
    private ItemType type;
    private List<ItemAttribute> itemAttributes;
    private int value;
    private boolean consumable;

    public Item(String id) {
        this(id, "", Texture.SLIM_IRON_SWORD, new ArrayList<>(), new ArrayList<>(), ItemRarity.COMMON, ItemType.MISC, 10);
    }

    public Item(String id, String name, Texture texture, List<String> description, List<ItemAttribute> itemAttributes, ItemRarity rarity, ItemType type) {
        this(id, name, texture, description, itemAttributes, rarity, type, 10);
    }

    public Item(String id, String name, Texture texture, List<String> description, List<ItemAttribute> itemAttributes, ItemRarity rarity, ItemType type, int value) {
        this.internalID = UUID.randomUUID();
        this.id = id;
        this.name = name;
        this.texture = texture;
        this.description = description;
        this.itemAttributes = itemAttributes;
        this.rarity = rarity;
        this.type = type;
        this.value = value;
        this.consumable = false;
    }

    public UUID getInternalID() {
        return internalID;
    }

    public void setInternalID(UUID internalID) {
        this.internalID = internalID;
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

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isConsumable() {
        return consumable;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", internalID=" + internalID +
                ", name='" + name + '\'' +
                ", texture=" + texture +
                ", description=" + description +
                ", rarity=" + rarity +
                ", itemAttributes=" + itemAttributes +
                ", value=" + value +
                ", consumable=" + consumable +
                '}';
    }
}
