package me.themgrf.motivatation.database;

import me.themgrf.motivatation.entities.GameUser;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.util.Auth;

import java.util.HashMap;
import java.util.Optional;

public class PlayerManager {

    private static final HashMap<User, Player> PLAYERS = new HashMap<>();

    public static Player getPlayer(long id) {
        return getDefaultPlayer(); // TODO: Replace with get
    }

    public static Player getPlayer(User user) {
        Player player = PLAYERS.get(user);
        return Optional.ofNullable(player).orElse(new Player(new GameUser(user)));
    }

    public static void savePlayer(Player player) {
        // TODO: Save player
    }

    public static Player getDefaultPlayer() {
        return new Player(new GameUser(Auth.getUser()));
    }

    public static HashMap<User, Player> getPlayers() {
        return PLAYERS;
    }
}
