package me.themgrf.motivatation.util.inventory;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InventoryCreatorTest {

    @Test
    void create() {
        assertNotNull(InventoryCreator.create("Test Inventory"));
    }

    @Test
    void testCreate() {
        assertNotNull(InventoryCreator.create("Test Inventory", Size.ONE));
    }

    @Test
    void testCreate1() {
        assertNotNull(InventoryCreator.create("Test Inventory", Size.ONE, new ArrayList<>()));
    }

    @Test
    void createEmptyPlayerInventory() {
        assertNotNull(InventoryCreator.create("Player Inventory", Size.THREE));
    }
}