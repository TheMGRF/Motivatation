package me.themgrf.motivatation.entities;

import me.themgrf.motivatation.inventories.Inventory;
import me.themgrf.motivatation.util.inventory.InventoryCreator;

public abstract class LivingEntity {

    private String name;
    private int level;
    private double health, defence, strength, speed;
    private Inventory inventory;

    public LivingEntity(String name, int level, double health, double defence, double strength, double speed, Inventory inventory) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.defence = defence;
        this.strength = strength;
        this.speed = speed;
        this.inventory = inventory;
    }

    public LivingEntity(String name, int level, double health, double defence, double strength, double speed) {
        this(name, level, health, defence, strength, speed, InventoryCreator.create(name + "'s Inventory"));
    }

    public LivingEntity() {
        this("Rename Me!", 1, 20, 20, 20, 20);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void heal(double health) {
        this.health += health;
    }

    public void damage(double damage) {
        this.health -= damage;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
