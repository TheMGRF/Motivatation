package me.themgrf.motivatation.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthTest {

    @Test
    void getUser() {
        assertNotNull(Auth.getUser());
    }
}