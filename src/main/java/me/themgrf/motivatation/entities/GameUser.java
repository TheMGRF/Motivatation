package me.themgrf.motivatation.entities;

public class GameUser {

    private int level, tasks, coins, gems;
    private double experience;
    private User user;

    public GameUser(User user) {
        this(0, 0, 0, 0, 0, user);
    }

    public GameUser(int level, int tasks, int coins, int gems, double experience, User user) {
        this.level = level;
        this.tasks = tasks;
        this.coins = coins;
        this.gems = gems;
        this.experience = experience;
        this.user = user;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTasks() {
        return tasks;
    }

    public void setTasks(int tasks) {
        this.tasks = tasks;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getGems() {
        return gems;
    }

    public void setGems(int gems) {
        this.gems = gems;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
