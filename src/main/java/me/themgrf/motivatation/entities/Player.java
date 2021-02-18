package me.themgrf.motivatation.entities;

import me.themgrf.motivatation.inventories.Inventory;
import me.themgrf.motivatation.inventories.items.ItemRarity;
import me.themgrf.motivatation.inventories.items.Texture;
import me.themgrf.motivatation.inventories.items.attributes.DefenceAttribute;
import me.themgrf.motivatation.inventories.items.attributes.HealthAttribute;
import me.themgrf.motivatation.inventories.items.attributes.SpeedAttribute;
import me.themgrf.motivatation.util.inventory.InventoryCreator;
import me.themgrf.motivatation.util.inventory.ItemBuilder;
import me.themgrf.motivatation.util.inventory.Size;

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

    // TODO: Remove and use real inventories
    @Override
    public Inventory getInventory() {
        return InventoryCreator.create(
                "Player Inventory",
                Size.TEN,
                Arrays.asList(
                        new ItemBuilder("test_1")
                                .name("Training Sword")
                                .description(Collections.singletonList("Used for simple and efficient training!"))
                                .texture(Texture.SLIM_IRON_SWORD)
                                .rarity(ItemRarity.COMMON)
                                .get(),
                        new ItemBuilder("test_2")
                                .name("Decorative Blade")
                                .description(Collections.singletonList("Some damage, mostly decorative!"))
                                .texture(Texture.JEWELED_IRON_SWORD)
                                .addItemAttribute(new HealthAttribute(5))
                                .rarity(ItemRarity.UNCOMMON)
                                .get(),
                        new ItemBuilder("test_3")
                                .name("Great Iron Sword")
                                .description(Collections.singletonList("A two-handed great sword!"))
                                .texture(Texture.GREAT_IRON_SWORD)
                                .addItemAttributes(new HealthAttribute(6), new DefenceAttribute(3))
                                .rarity(ItemRarity.RARE)
                                .get(),
                        new ItemBuilder("test_4")
                                .name("Greater Iron Sword")
                                .description(Collections.singletonList("An even greater two-handed great sword!"))
                                .texture(Texture.GREATER_IRON_SWORD)
                                .addItemAttributes(new HealthAttribute(8), new DefenceAttribute(4), new SpeedAttribute(12))
                                .rarity(ItemRarity.EPIC)
                                .get(),
                        new ItemBuilder("test_5")
                                .name("Oak Bow")
                                .description(Collections.singletonList("A basic oak bow!"))
                                .texture(Texture.OAK_BOW)
                                .rarity(ItemRarity.COMMON)
                                .get(),
                        new ItemBuilder("test_6")
                                .name("Curved Bow")
                                .description(Collections.singletonList("A strong curved bow for even further accuracy!"))
                                .texture(Texture.CURVED_BOW)
                                .addItemAttributes(new HealthAttribute(4), new SpeedAttribute(2))
                                .rarity(ItemRarity.RARE)
                                .get()
                )
        );
    }
}
