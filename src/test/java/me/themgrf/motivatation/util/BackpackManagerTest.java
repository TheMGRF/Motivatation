package me.themgrf.motivatation.util;

import me.themgrf.motivatation.game.inventories.Backpack;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BackpackManagerTest {

    @Test
    void get() {
        assertNotNull(BackpackManager.get(0));
    }

    @Test
    void getBackpacks() {
        HashMap<Long, Backpack> backpacks = BackpackManager.getBackpacks();
        assertNotNull(backpacks);
        assertNotEquals(backpacks, Collections.emptyList());
    }
}