package me.themgrf.motivatation.util;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilTest {

    @Test
    void getConnection() {
        try {
            assertNotNull(DBUtil.getConnection());
        } catch (SQLException ignored) {
        }
    }
}