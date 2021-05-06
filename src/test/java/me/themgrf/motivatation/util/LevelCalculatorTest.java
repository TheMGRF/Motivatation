package me.themgrf.motivatation.util;

import me.themgrf.motivatation.database.PlayerManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LevelCalculatorTest {

    @Test
    void getLevel() {
        assertNotEquals(LevelCalculator.getLevel(PlayerManager.getPlayer(0)), 0);
    }
}