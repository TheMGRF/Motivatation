package me.themgrf.motivatation.game.tasks;

import me.themgrf.motivatation.game.rewards.Reward;

import java.util.UUID;

public class Task {

    private final UUID uuid;
    private final String name, due;
    private final TaskStatus status;
    private final TaskPriority priority;
    private final Reward reward;
    private final boolean done;
    private final long repeat;

    public Task(String name, String due, TaskStatus status, TaskPriority priority, Reward reward, boolean done, long repeat) {
        this(UUID.randomUUID(), name, due, status, priority, reward, done, repeat);
    }

    public Task(UUID uuid, String name, String due, TaskStatus status, TaskPriority priority, Reward reward, boolean done, long repeat) {
        this.uuid = uuid;
        this.name = name;
        this.due = due;
        this.status = status;
        this.priority = priority;
        this.reward = reward;
        this.done = done;
        this.repeat = repeat;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDue() {
        return due;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public Reward getReward() {
        return reward;
    }

    public boolean isDone() {
        return done;
    }

    public long getRepeat() {
        return repeat;
    }

    public boolean isRepeatable() {
        return getRepeat() > 0;
    }

    public enum TaskStatus {

        TODO,
        STARTED,
        IN_PROGRESS,
        FINISHED,
        OVERDUE;

    }

    public enum TaskPriority {

        LOW,
        MEDIUM,
        HIGH

    }
}
