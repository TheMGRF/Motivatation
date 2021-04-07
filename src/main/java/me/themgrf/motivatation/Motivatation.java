package me.themgrf.motivatation;

import me.themgrf.motivatation.entities.EntityType;
import me.themgrf.motivatation.entities.LivingEntity;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.Zombie;
import me.themgrf.motivatation.game.inventories.items.ItemManager;
import me.themgrf.motivatation.game.inventories.items.ItemRarity;
import me.themgrf.motivatation.game.inventories.items.Texture;
import me.themgrf.motivatation.game.inventories.items.attributes.DefenceAttribute;
import me.themgrf.motivatation.game.inventories.items.attributes.HealthAttribute;
import me.themgrf.motivatation.game.inventories.items.attributes.SpeedAttribute;
import me.themgrf.motivatation.util.inventory.ItemBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

public class Motivatation {

    private static Motivatation instance;

    public Motivatation() {
        instance = this;
    }

    public static Motivatation getInstance() {
        if (instance == null) instance = new Motivatation();
        return instance;
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public LivingEntity getEntity(EntityType type) {
        LivingEntity entity;
        switch (type) {
            case ZOMBIE:
                entity = new Zombie();
                break;
            case SKELETON:
                entity = new Zombie(); // TODO: Add skeleton
                break;
            default:
                entity = null;
                break;
        }

        return entity;
    }

    public void setupItems() {
        ItemManager.addItem(
                new ItemBuilder("training_sword")
                        .name("Training Sword")
                        .description(Collections.singletonList("Used for simple and efficient training!"))
                        .texture(Texture.SLIM_IRON_SWORD)
                        .rarity(ItemRarity.COMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("decorative_blade")
                        .name("Decorative Blade")
                        .description(Collections.singletonList("Some damage, mostly decorative!"))
                        .texture(Texture.JEWELED_IRON_SWORD)
                        .addItemAttribute(new HealthAttribute(5))
                        .rarity(ItemRarity.UNCOMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("test_3")
                        .name("Great Iron Sword")
                        .description(Collections.singletonList("A two-handed great sword!"))
                        .texture(Texture.GREAT_IRON_SWORD)
                        .addItemAttributes(new HealthAttribute(6), new DefenceAttribute(3))
                        .rarity(ItemRarity.RARE)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("greater_iron_sword")
                        .name("Greater Iron Sword")
                        .description(Collections.singletonList("An even greater two-handed great sword!"))
                        .texture(Texture.GREATER_IRON_SWORD)
                        .addItemAttributes(new HealthAttribute(8), new DefenceAttribute(4), new SpeedAttribute(12))
                        .rarity(ItemRarity.EPIC)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("oak_bow")
                        .name("Oak Bow")
                        .description(Collections.singletonList("A basic oak bow!"))
                        .texture(Texture.OAK_BOW)
                        .rarity(ItemRarity.COMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("curved_bow")
                        .name("Curved Bow")
                        .description(Collections.singletonList("A strong curved bow for even further accuracy!"))
                        .texture(Texture.CURVED_BOW)
                        .addItemAttributes(new HealthAttribute(4), new SpeedAttribute(2))
                        .rarity(ItemRarity.RARE)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("apple")
                        .name("Apple")
                        .description(Collections.singletonList("A crunchy green apple!"))
                        .texture(Texture.APPLE)
                        .addItemAttributes(new HealthAttribute(2))
                        .rarity(ItemRarity.COMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("cheese_wheel")
                        .name("Cheese Wheel")
                        .description(Collections.singletonList("A very old wheel of cheese."))
                        .texture(Texture.CHEESE_WHEEL)
                        .addItemAttributes(new HealthAttribute(3))
                        .rarity(ItemRarity.UNCOMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("pie_slice")
                        .name("Slice of Pie")
                        .description(Collections.singletonList("It's some form of pie, hard to tell what the filling is though..."))
                        .texture(Texture.PIE)
                        .addItemAttributes(new HealthAttribute(4))
                        .rarity(ItemRarity.RARE)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("health_potion_1")
                        .name("Health Potion I")
                        .description(Collections.singletonList("A basic health potion!"))
                        .texture(Texture.HEALTH_POTION)
                        .addItemAttributes(new HealthAttribute(5))
                        .rarity(ItemRarity.UNCOMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("health_potion_2")
                        .name("Health Potion II")
                        .description(Collections.singletonList("An improved health potion!"))
                        .texture(Texture.HEALTH_POTION)
                        .addItemAttributes(new HealthAttribute(6))
                        .rarity(ItemRarity.UNCOMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("health_potion_3")
                        .name("Health Potion III")
                        .description(Collections.singletonList("A perfected health potion!"))
                        .texture(Texture.HEALTH_POTION)
                        .addItemAttributes(new HealthAttribute(7))
                        .rarity(ItemRarity.UNCOMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("health_potion_4")
                        .name("Health Potion IV")
                        .description(Collections.singletonList("A restoring and refreshing health potion!"))
                        .texture(Texture.PLENTIFUL_HEALTH_POTION)
                        .addItemAttributes(new HealthAttribute(8))
                        .rarity(ItemRarity.RARE)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("health_potion_5")
                        .name("Health Potion V")
                        .description(Collections.singletonList("A refined and fulfilling health potion!"))
                        .texture(Texture.PLENTIFUL_HEALTH_POTION)
                        .addItemAttributes(new HealthAttribute(10))
                        .rarity(ItemRarity.EPIC)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("stamina_potion_1")
                        .name("Stamina Potion I")
                        .description(Collections.singletonList("A basic stamina potion!"))
                        .texture(Texture.STAMINA_POTION)
                        .addItemAttributes(new SpeedAttribute(2))
                        .rarity(ItemRarity.UNCOMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("stamina_potion_2")
                        .name("Stamina Potion II")
                        .description(Collections.singletonList("An improved stamina potion!"))
                        .texture(Texture.STAMINA_POTION)
                        .addItemAttributes(new SpeedAttribute(4))
                        .rarity(ItemRarity.UNCOMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("stamina_potion_3")
                        .name("Stamina Potion III")
                        .description(Collections.singletonList("A perfected and invigorating stamina potion!"))
                        .texture(Texture.PLENTIFUL_STAMINA_POTION)
                        .addItemAttributes(new SpeedAttribute(6))
                        .rarity(ItemRarity.UNCOMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("star_amulet")
                        .name("Star Amulet")
                        .description(Collections.singletonList("An amulet forged from the stars."))
                        .texture(Texture.STAR_AMULET)
                        .addItemAttributes(new DefenceAttribute(5))
                        .rarity(ItemRarity.EPIC)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("gem_amulet")
                        .name("Gem Amulet")
                        .description(Collections.singletonList("A decorative and luxurious amulet."))
                        .texture(Texture.GEM_AMULET)
                        .rarity(ItemRarity.COMMON)
                        .get()
        );
        ItemManager.addItem(
                new ItemBuilder("bone_amulet")
                        .name("Bone Amulet")
                        .description(Collections.singletonList("An old and rustic amulet formed from bone."))
                        .texture(Texture.BONE_AMULET)
                        .rarity(ItemRarity.COMMON)
                        .get()
        );
    }
}
