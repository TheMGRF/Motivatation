package me.themgrf.motivatation.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    private static Pair<?, ?> pair;

    @BeforeAll
    static void beforeAll() {
        pair = new Pair<>("Hello", "World");
    }

    @Test
    void of() {
        assertNotNull(Pair.of("Hello", "World"));
    }

    @Test
    void getKey() {
        assertNotNull(pair.getKey());
    }

    @Test
    void getValue() {
        assertNotNull(pair.getValue());
    }

    @Test
    void testToString() {
        assertNotNull(pair.toString());
        assertNotEquals(pair.toString(), "");
    }

    @Test
    void testEquals() {
        assertEquals(pair, pair);
    }

    @Test
    void testHashCode() {
        assertNotEquals(pair.hashCode(), 0);
    }
}