package me.themgrf.motivatation.database;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.game.tasks.TaskManager;
import me.themgrf.motivatation.util.DBUtil;
import org.springframework.stereotype.Service;
import xyz.minecrossing.coreutilities.CoreUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Service
public class PlayerManager {

    private static final HashMap<User, Player> PLAYERS = new HashMap<>();

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
        String sql = "SELECT * FROM players INNER JOIN users ON players.player_id = users.id WHERE player_id = ? LIMIT 1;";

        String name = "";
        double health = 0;
        double defence = 0;
        double strength = 0;
        double speed = 0;
        double intelligence = 0;
        int level = 0;
        int tasks = 0;
        int coins = 0;
        int gems = 0;
        double experience = 0;
        boolean dead = false;

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("username");
                health = rs.getDouble("health");
                defence = rs.getDouble("defence");
                strength = rs.getDouble("strength");
                speed = rs.getDouble("speed");
                intelligence = rs.getDouble("intelligence");
                level = rs.getInt("level");
                tasks = rs.getInt("tasks");
                coins = rs.getInt("coins");
                gems = rs.getInt("gems");
                experience = rs.getDouble("experience");
                dead = rs.getBoolean("dead");
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return makePlayer(id, name, health, defence, strength, speed, intelligence, level, tasks, coins, gems, experience, dead);
    }

    /**
     * Add a player the first time
     *
     * @param player The player to add
     */
    public static void addPlayer(Player player) {
        String sql = "INSERT INTO players (player_id, health, defence, strength, speed, intelligence, level, tasks, coins, gems, experience, dead) " +
                "VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                ";";

        try (Connection con = DBUtil.getConnection()) {
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
            ps.setBoolean(12, player.isDead());

            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void savePlayer(Player player) {
        try (Connection con = DBUtil.getConnection()) {
            String sql = "UPDATE players SET health = ?, defence = ?, strength = ?, speed = ?, intelligence = ?, level = ?, tasks = ?, coins = ?, gems = ?, experience = ?, dead = ? " +
                    "WHERE player_id = ?" +
                    ";";

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
            ps.setBoolean(11, player.isDead());
            ps.setLong(12, player.getId());

            ps.execute();

            // Update inventories
            //sql = "UPDATE inventories SET items = ? WHERE player_id = ?;";
            sql = "INSERT INTO inventories (player_id, items) VALUES(?, ?) ON DUPLICATE KEY UPDATE items = ?;";

            ps = con.prepareStatement(sql);
            ps.setLong(1, player.getId());
            ps.setString(2, player.getInventory().toString());
            ps.setString(3, player.getInventory().toString());


            ps.execute();

            ps.close();
            con.close();

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        CoreUtilities.getTaskManager().runAsync(() -> TaskManager.saveTasks(player));
    }

    public static Player makePlayer(long id, String name, double health, double defence, double strength, double speed,
                                    double intelligence, int level, int tasks, int coins, int gems, double experience, boolean dead) {
        return new Player(id, name, level, health, defence, strength, speed, tasks, coins, gems, experience, intelligence, dead);
    }

    public static Player getDefaultPlayer(long id) {
        return new Player(id);
    }

    public static HashMap<User, Player> getPlayers() {
        return PLAYERS;
    }
}
