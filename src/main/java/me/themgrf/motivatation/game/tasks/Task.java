package me.themgrf.motivatation.game.tasks;

import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;
import org.apache.commons.text.WordUtils;

import java.util.UUID;

public class Task {

    private final UUID uuid;
    private String name, description, due;
    private TaskStatus status;
    private TaskPriority priority;
    private Reward reward;
    private boolean done;
    private long repeat;

    private String formRewardType;
    private int formRewardAmount;

    public Task() {
        this.uuid = UUID.randomUUID();
    }

    public Task(String name, String description, String due, TaskStatus status, TaskPriority priority, Reward reward, boolean done, long repeat) {
        this(UUID.randomUUID(), name, description, due, status, priority, reward, done, repeat);
    }

    public Task(UUID uuid, String name, String description, String due, TaskStatus status, TaskPriority priority, Reward reward, boolean done, long repeat) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public long getRepeat() {
        return repeat;
    }

    public void setRepeatable(long repeat) {
        this.repeat = repeat;
    }

    public boolean isRepeatable() {
        return getRepeat() > 0;
    }

    public Reward getFormReward() {
        return new Reward(RewardType.valueOf(formRewardType), formRewardAmount);
    }

    public String getFormRewardType() {
        return formRewardType;
    }

    public void setFormRewardType(String formRewardType) {
        this.formRewardType = formRewardType;
    }

    public int getFormRewardAmount() {
        return formRewardAmount;
    }

    public void setFormRewardAmount(int formRewardAmount) {
        this.formRewardAmount = formRewardAmount;
    }

    @Override
    public String toString() {
        return "Task{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", due='" + due + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", reward=" + reward +
                ", done=" + done +
                ", repeat=" + repeat +
                '}';
    }

    public enum TaskStatus {

        TODO,
        STARTED,
        IN_PROGRESS,
        ON_HOLD,
        FINISHED,
        OVERDUE;

        public String toLowerString() {
            return name().toLowerCase().replace("_", " ");
        }

        @Override
        public String toString() {
            return WordUtils.capitalize(name().toLowerCase().replace("_", " "));
        }
    }

    public enum TaskPriority {

        LOW,
        MEDIUM,
        HIGH;

        public String toLowerString() {
            return name().toLowerCase();
        }

        @Override
        public String toString() {
            return WordUtils.capitalize(name().toLowerCase());
        }

    }
}
