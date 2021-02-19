package me.themgrf.motivatation.entities;

import me.themgrf.motivatation.inventories.Inventory;
import me.themgrf.motivatation.inventories.items.ItemManager;
import me.themgrf.motivatation.inventories.items.ItemRarity;
import me.themgrf.motivatation.inventories.items.Texture;
import me.themgrf.motivatation.inventories.items.attributes.DefenceAttribute;
import me.themgrf.motivatation.inventories.items.attributes.HealthAttribute;
import me.themgrf.motivatation.inventories.items.attributes.SpeedAttribute;
import me.themgrf.motivatation.util.inventory.InventoryCreator;
import me.themgrf.motivatation.util.inventory.ItemBuilder;
import me.themgrf.motivatation.util.inventory.Size;
import xyz.minecrossing.databaseconnector.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;

public class Player extends LivingEntity {

    private final long id;
    private int tasks, coins, gems;
    private double experience, intelligence;

    public Player(long id) {
        super();

        this.id = id;
        this.tasks = 0;
        this.coins = 0;
        this.gems = 0;
        this.experience = 0;
        this.intelligence = 0;
    }

    public Player(long id, String name, int level, double health, double defence, double strength, double speed, int tasks, int coins, int gems, double experience, double intelligence) {
        super(name, level, health, defence, strength, speed);
        this.id = id;
        this.tasks = tasks;
        this.coins = coins;
        this.gems = gems;
        this.experience = experience;
        this.intelligence = intelligence;

        getInventory().addItem(ItemManager.getItem("apple"));
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

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public Inventory getInventory() {
        Inventory inventory = InventoryCreator.createEmptyPlayerInventory(this);

        String items = "";

        try (Connection con = DatabaseConnector.getInstance().getConnection("motivatation")) {
            PreparedStatement ps = con.prepareStatement("SELECT items FROM inventories WHERE player_id = ? LIMIT 1;");
            ps.setLong(1, getId());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items = rs.getString("items");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        inventory.addItems(ItemManager.itemsFromString(items));

        return inventory;
    }
}
