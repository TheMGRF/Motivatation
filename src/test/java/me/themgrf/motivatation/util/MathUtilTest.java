package me.themgrf.motivatation.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {

    @Test
    void roundDecimal() {
        assertNotEquals(MathUtil.roundDecimal(5.55), 0);
    }

    @Test
    void round() {
        assertNotEquals(MathUtil.round(5.55), 0);
    }

    @Test
    void format() {
        String format = MathUtil.format(1000);

        assertNotNull(format);

        if (!format.contains(",")) fail();
    }
}