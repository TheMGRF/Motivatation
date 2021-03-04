package me.themgrf.motivatation.game.achievement;

import me.themgrf.motivatation.entities.Player;
import xyz.minecrossing.databaseconnector.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

public class AchievementManager {

    /**
     * Perform a DB call to see if the player has completed
     * an achievement, indicated by its target count.
     *
     * @param player      The player to check for
     * @param achievement The achievement to check if completed
     * @return <code>true</code> if the achievement was completed, <code>false</code> otherwise
     */
    public static boolean hasCompleted(Player player, Achievement achievement) {
        AtomicBoolean completed = new AtomicBoolean(false);

        try (Connection con = DatabaseConnector.getInstance().getConnection("motivatation")) {
            PreparedStatement ps = con.prepareStatement("SELECT current FROM achievements WHERE player_id = ? AND achievement_id = ? LIMIT 1;");
            ps.setLong(1, player.getId());
            ps.setString(2, achievement.getId());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int current = rs.getInt("current");
                if (current >= achievement.getTarget()) {
                    completed.set(true);
                    System.out.println(player.getName() + " has completed " + achievement.getId());
                }
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return completed.get();
    }

    public static void updateAchievement(Player player, Achievement achievement, int current) {
        String sql = "UPDATE achievements SET player_id = ?, achievement_id = ?, current = ? WHERE player_id = ? AND achievement_id = ?;";

        try (Connection con = DatabaseConnector.getInstance().getConnection("motivatation")) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, player.getId());
            ps.setString(2, achievement.getId());
            ps.setInt(3, current);
            ps.setLong(4, player.getId());
            ps.setString(5, achievement.getId());

            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
