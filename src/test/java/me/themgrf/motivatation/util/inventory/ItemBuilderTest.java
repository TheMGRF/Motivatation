package me.themgrf.motivatation.util.inventory;

import me.themgrf.motivatation.game.inventories.items.Item;
import me.themgrf.motivatation.game.inventories.items.ItemRarity;
import me.themgrf.motivatation.game.inventories.items.ItemType;
import me.themgrf.motivatation.game.inventories.items.Texture;
import me.themgrf.motivatation.game.inventories.items.attributes.HealthAttribute;
import me.themgrf.motivatation.game.inventories.items.attributes.ItemAttribute;
import me.themgrf.motivatation.game.inventories.items.attributes.SpeedAttribute;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ItemBuilderTest {

    private static Item item;

    @BeforeAll
    static void beforeAll() {
        item = new Item("Test Item");
    }

    @BeforeEach
    void setUp() {
        assertNotNull(item);
    }

    @Test
    void name() {
        item.setName("Test Name");
        assertNotEquals(item.getName(), "");
    }

    @Test
    void texture() {
        item.setTexture(Texture.APPLE);
        assertNotNull(item.getTexture());
    }

    @Test
    void description() {
        item.setDescription(Arrays.asList("Test1", "Test2"));

        assertNotNull(item.getDescription());
        assertNotEquals(item.getDescription(), Collections.emptyList());
    }

    @Test
    void setItemAttributes() {
        item.setItemAttributes(Arrays.asList(new HealthAttribute(1), new SpeedAttribute(1)));

        assertNotNull(item.getItemAttributes());
        assertNotEquals(item.getItemAttributes(), Collections.emptyList());
    }

    @Test
    void addItemAttributes() {

    }

    @Test
    void addItemAttribute() {
        ItemAttribute attribute = new HealthAttribute(1);

        assertNotNull(attribute);

        item.addItemAttributes(attribute);
    }

    @Test
    void rarity() {
        item.setRarity(ItemRarity.RARE);

        assertNotEquals(item.getRarity(), ItemRarity.COMMON);
        assertNotNull(item.getRarity());
    }

    @Test
    void type() {
        item.setType(ItemType.WEAPON);

        assertNotEquals(item.getType(), ItemType.MISC);
        assertNotNull(item.getType());
    }

    @Test
    void value() {
        item.setValue(100);

        assertNotEquals(item.getValue(), 10);
    }

    @Test
    void consumable() {
        item.setConsumable(true);

        assertTrue(item.isConsumable());
    }

    @Test
    void get() {
        assertNotNull(item);
    }
}