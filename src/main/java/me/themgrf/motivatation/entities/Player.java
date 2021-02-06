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

    private final GameUser gameUser;
    private double intelligence;

    public Player(GameUser gameUser) {
        this.gameUser = gameUser;

        this.intelligence = 0;
    }

    public GameUser getGameUser() {
        return gameUser;
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
                                .get()
                )
        );
    }
}
