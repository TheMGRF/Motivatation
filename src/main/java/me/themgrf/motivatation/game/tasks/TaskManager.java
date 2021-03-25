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

    public static List<Task> loadTasks(Player player) {
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
                        rs.getString("description"),
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

        return tasks;
    }

    public static void saveTasks(Player player) {
        try (Connection con = DBUtil.getConnection()) {
            for (Task task : getTasks(player)) {

                String sql = "INSERT INTO tasks (`player_id`, `task_uuid`, `task`, `description`, `status`, `priority`, `due`, `reward`, `done`, `repeat`)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE `status`=`status`, `done`=`done`, `repeat`=`repeat`;";

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, (int) player.getId());
                ps.setString(2, task.getUUID().toString());
                ps.setString(3, task.getName());
                ps.setString(4, task.getDescription());
                ps.setString(5, task.getStatus().name());
                ps.setString(6, task.getPriority().name());
                ps.setString(7, task.getDue());
                ps.setString(8, task.getReward().toDBString());
                ps.setBoolean(9, task.isDone());
                ps.setFloat(10, task.getRepeat());

                // update stuff
                /*ps.setString(11, task.getStatus().name());
                ps.setBoolean(12, task.isDone());
                ps.setFloat(13, task.getRepeat());*/

                ps.execute();

                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> getTasks(Player player) {
        List<Task> tasks = PLAYER_TASKS.get(player.getId());
        if (tasks == null) {
            return loadTasks(player);
        }
        return tasks;
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
