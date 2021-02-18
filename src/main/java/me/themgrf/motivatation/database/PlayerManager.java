package me.themgrf.motivatation.database;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xyz.minecrossing.databaseconnector.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

@Service
public class PlayerManager {

    private static final HashMap<User, Player> PLAYERS = new HashMap<>();

    @Autowired
    private static JdbcTemplate db;

    public static Player getPlayer(long id) {
        return getDefaultPlayer(id); // TODO: Replace with get
    }

    public static Player getPlayer(User user) {
        Player player = PLAYERS.get(user);
        if (user != null) {
            player = getPlayerFromDB(user.getId());
            PLAYERS.put(user, player);
            return player;
        }

        return player;
    }

    public static Player getPlayerFromDB(long id) {
        String sql = "SELECT * FROM players WHERE player_id = ? LIMIT 1;";
        Object[] params = new Object[]{id};
        PlayerMapper mapper = new PlayerMapper();

        return db.queryForObject(sql, params, mapper);
    }

    /**
     * Add a player the first time
     *
     * @param player The player to add
     */
    public static void addPlayer(Player player) {
        String sql = "INSERT INTO players (player_id, health, defence, strength, speed, intelligence, level, tasks, coins, gems, experience) " +
                "VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                ";";

        try (Connection con = DatabaseConnector.getInstance().getConnection("motivatation")) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, player.getId());
            ps.setDouble(2, player.getHealth());
            ps.setDouble(3, player.getDefence());
            ps.setDouble(4, player.getStrength());
            ps.setDouble(5, player.getSpeed());
            ps.setDouble(6, player.getIntelligence());
            ps.setInt(7, player.getLevel());
            ps.setInt(8, player.getTasks());
            ps.setInt(9, player.getCoins());
            ps.setInt(10, player.getGems());
            ps.setDouble(11, player.getExperience());

            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void savePlayer(Player player) {
        // TODO: Save player
        String sql = "INSERT INTO players (health, defence, strength, speed, intelligence, level, tasks, coins, gems, experience) " +
                "VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                ";";

        try (Connection con = DatabaseConnector.getInstance().getConnection("motivatation")) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, player.getHealth());
            ps.setDouble(2, player.getDefence());
            ps.setDouble(3, player.getStrength());
            ps.setDouble(4, player.getSpeed());
            ps.setDouble(5, player.getIntelligence());
            ps.setInt(6, player.getLevel());
            ps.setInt(7, player.getTasks());
            ps.setInt(8, player.getCoins());
            ps.setInt(9, player.getGems());
            ps.setDouble(10, player.getExperience());

            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Player getDefaultPlayer(long id) {
        return new Player(id);
    }

    public static HashMap<User, Player> getPlayers() {
        return PLAYERS;
    }
}
