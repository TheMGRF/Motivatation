package me.themgrf.motivatation.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TUtilTest {

    @Test
    void getMessage() {
        String msg = TUtil.getMessage("Hello %place%", "place", "World");

        assertNotNull(msg);
        assertNotEquals(msg, "");

        if (msg.contains("%")) fail();
    }
}