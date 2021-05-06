package me.themgrf.motivatation.database;

import me.themgrf.motivatation.entities.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerManagerTest {

    @Test
    void getPlayer() {
        assertNotNull(PlayerManager.getPlayer(0));
    }

    @Test
    void getPlayerFromDB() {
        assertNotNull(PlayerManager.getPlayerFromDB(0));
    }

    @Test
    void addPlayer() {
        Player player = PlayerManager.getPlayer(0);
        assertNotNull(player);
    }

    @Test
    void savePlayer() {
        Player player = PlayerManager.getPlayer(0);
        assertNotNull(player);
    }

    @Test
    void makePlayer() {
        Player player = PlayerManager.getPlayer(0);
        assertNotNull(player);
    }

    @Test
    void getDefaultPlayer() {
        Player player = PlayerManager.getPlayer(0);
        assertNotNull(player);
    }

    @Test
    void getPlayers() {
        assertNotNull(PlayerManager.getPlayers());
    }
}