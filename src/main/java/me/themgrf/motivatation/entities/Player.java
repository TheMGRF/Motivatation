package me.themgrf.motivatation.entities;

import me.themgrf.motivatation.game.achievement.Achievement;
import me.themgrf.motivatation.game.achievement.AchievementManager;
import me.themgrf.motivatation.game.inventories.Backpack;
import me.themgrf.motivatation.game.inventories.Inventory;
import me.themgrf.motivatation.game.inventories.items.ItemManager;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.util.inventory.InventoryCreator;
import xyz.minecrossing.databaseconnector.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Player extends LivingEntity {

    private final long id;
    private final List<Achievement> achievements;

    private int tasks, coins, gems;
    private double experience, intelligence;

    public Player(long id) {
        this(id, "Rename Me!", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false);
    }


    public Player(long id, String name, int level, double health, double defence, double strength, double speed, int tasks, int coins, int gems, double experience, double intelligence, boolean dead) {
        super(name, level, health, defence, strength, speed, dead);
        this.id = id;
        this.tasks = tasks;
        this.coins = coins;
        this.gems = gems;
        this.experience = experience;
        this.intelligence = intelligence;
        this.achievements = new ArrayList<>();

        setInventory(getInventoryFromDB());
    }

    public long getId() {
        return id;
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

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public void removeCoins(int coins) {
        this.coins -= coins;
    }

    public int getGems() {
        return gems;
    }

    public void setGems(int gems) {
        this.gems = gems;
    }

    public void addGems(int gems) {
        this.gems += gems;
    }

    public void removeGems(int gems) {
        this.gems -= gems;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public void giveExperience(double experience) {
        this.experience += experience;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void awardAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    public boolean hasAchievement(Achievement achievement) {
        return achievements.contains(achievement);
    }

    /**
     * Database call to check if an achievement has been completed
     *
     * @param achievement The achievement to check
     * @return <code>true</code> if the achievement has been completed, <code>false</code> otherwise
     */
    public boolean hasCompletedAchievement(Achievement achievement) {
        return AchievementManager.hasCompleted(this, achievement);
    }

    /**
     * Give a player a specified reward containing the reward type and amount
     *
     * @param reward The reward to give the player
     */
    public void giveReward(Reward reward) {
        int amount = reward.getAmount();

        switch (reward.getRewardType()) {
            case EXP:
                giveExperience(amount);
                break;
            case COINS:
                addCoins(amount);
                break;
            case GEMS:
                addGems(amount);
                break;
            default:
                System.out.println("Invalid reward specified!");
                break;
        }
    }

    public Inventory getInventoryFromDB() {
        Inventory inventory = InventoryCreator.createEmptyPlayerInventory(this);

        String items = "";

        try (Connection con = DatabaseConnector.getInstance().getConnection("motivatation")) {
            PreparedStatement ps = con.prepareStatement("SELECT items FROM inventories WHERE player_id = ? LIMIT 1;");
            ps.setLong(1, getId());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items = rs.getString("items");
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        inventory.addItems(ItemManager.itemsFromString(items));

        return inventory;
    }
}
