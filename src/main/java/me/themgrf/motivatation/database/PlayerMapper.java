package me.themgrf.motivatation.database;

import me.themgrf.motivatation.entities.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(ResultSet rs, int row) throws SQLException {
        long id = rs.getInt("player_id");
        double health = rs.getDouble("health");
        double defence = rs.getDouble("defence");
        double strength = rs.getDouble("strength");
        double speed = rs.getDouble("speed");
        double intelligence = rs.getDouble("intelligence");
        int level = rs.getInt("level");
        int tasks = rs.getInt("tasks");
        int coins = rs.getInt("coins");
        int gems = rs.getInt("gems");
        double experience = rs.getInt("experience");

        return new Player(id, "", level, health, defence, strength, speed, tasks, coins, gems, experience, intelligence);
    }
}
