package me.themgrf.motivatation.entities;

import me.themgrf.motivatation.inventories.Inventory;
import me.themgrf.motivatation.inventories.items.Texture;
import me.themgrf.motivatation.util.inventory.InventoryCreator;
import me.themgrf.motivatation.util.inventory.ItemBuilder;
import me.themgrf.motivatation.util.inventory.Size;

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
                Collections.singletonList(
                        new ItemBuilder("test")
                                .name("Test Item")
                                .description(Collections.singletonList("Test description!"))
                                .texture(Texture.TEST)
                                .get()
                )
        );
    }
}
