package me.themgrf.motivatation.game.tasks;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TaskManager {

    public static final HashMap<Long, List<Task>> PLAYER_TASKS = new HashMap<>();

    public static void loadTasks(Player player) {
        List<Task> tasks = new ArrayList<>();
        long id = player.getId();

        try (Connection con = DBUtil.getConnection()) {
            String sql = "SELECT * FROM tasks WHERE player_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tasks.add(new Task(
                        UUID.fromString(rs.getString("task_uuid")),
                        rs.getString("task"),
                        rs.getString("due"),
                        Task.TaskStatus.valueOf(rs.getString("status")),
                        Task.TaskPriority.valueOf(rs.getString("priority")),
                        Reward.fromString(rs.getString("reward")),
                        rs.getInt("done") == 1,
                        rs.getLong("repeat")
                ));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PLAYER_TASKS.put(id, tasks);
    }

    // TODO: save tasks to DB in one bulk save
    public static void saveTasks(Player player) {
        try (Connection con = DBUtil.getConnection()) {
            String sql = "INSERT INTO ...";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "");

            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> getTasks(Player player) {
        return PLAYER_TASKS.get(player.getId());
    }

    public static void addTask(Player player, Task task) {
        long id = player.getId();
        List<Task> tasks = PLAYER_TASKS.get(id);
        if (tasks == null) {
            PLAYER_TASKS.put(id, Collections.singletonList(task));
        } else {
            tasks.add(task);
            PLAYER_TASKS.put(id, tasks);
        }
    }

    public static void removeTask(Player player, Task task) {
        long id = player.getId();
        List<Task> tasks = PLAYER_TASKS.get(id);
        if (tasks != null) {
            tasks.remove(task);
            PLAYER_TASKS.put(id, tasks);
        }
    }

}
