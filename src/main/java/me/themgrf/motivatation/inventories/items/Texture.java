package me.themgrf.motivatation.inventories.items;

public enum Texture {

    // Swords
    SLIM_IRON_SWORD("/items/weapons/swords/slim_iron_sword.png"),
    IRON_SWORD("/items/weapons/swords/iron_sword.png"),
    JEWELED_IRON_SWORD("/items/weapons/swords/jeweled_iron_sword.png"),
    PINCER_SWORD("/items/weapons/swords/pincer_sword.png"),
    JEWELED_PINCER_SWORD("/items/weapons/swords/jeweled_pincer_sword.png"),
    CURVED_SWORD("/items/weapons/swords/curved_sword.png"),
    GREAT_IRON_SWORD("/items/weapons/swords/great_iron_sword.png"),
    GREATER_IRON_SWORD("/items/weapons/swords/greater_iron_sword.png"),

    // Bows
    OAK_BOW("/items/weapons/bows/oak_bow.png"),
    JEWELED_OAK_BOW("/items/weapons/bows/jeweled_oak_bow.png"),
    CURVED_BOW("/items/weapons/bows/curved_bow.png"),
    SPIKED_BOW("/items/weapons/bows/spiked_bow.png"),

    // Spears
    HALBARD("/items/weapons/spears/halbard.png"),
    LANCE("/items/weapons/spears/lance.png"),
    RIBBONED_SPEAR("/items/weapons/spears/ribboned_spear.png"),
    SPEAR("/items/weapons/spears/spear.png"),

    // Staffs
    WOODEN_STAFF("/items/weapons/staffs/wooden_staff.png"),
    DECORATIVE_STAFF("/items/weapons/staffs/decorative_staff.png"),
    EARTH_STAFF("/items/weapons/staffs/earth_staff.png"),
    FIRE_STAFF("/items/weapons/staffs/fire_staff.png"),
    LIGHTNING_STAFF("/items/weapons/staffs/lightning_staff.png"),
    WATER_STAFF("/items/weapons/staffs/water_staff.png"),

    // Axes
    IRON_AXE("/items/weapons/staffs/iron_axe.png"),
    SPEAR_AXE("/items/weapons/staffs/spear_axe.png"),
    EXECUTIONERS_AXE("/items/weapons/staffs/executioners_axe.png"),
    WARHAMMER("/items/weapons/staffs/warhammer.png"),

    // Shields
    WOODEN_SHIELD("/items/shields/wooden_shield.png"),
    BRONZE_SHIELD("/items/shields/bronze_shield.png"),
    IRON_SHIELD("/items/shields/iron_shield.png"),
    GOLD_SHIELD("/items/shields/gold_shield.png"),

    // Potions
    HEALTH_POTION("/items/potions/health_potion.png"),
    PLENTIFUL_HEALTH_POTION("/items/shields/plentiful_health_potion.png"),
    STAMINA_POTION("/items/shields/stamina_potion.png"),
    PLENTIFUL_STAMINA_POTION("/items/shields/plentiful_stamina_potion.png"),

    // Food
    APPLE("/items/food/apple.png"),
    CHEESE_WHEEL("/items/food/cheese_wheel.png"),
    EGG("/items/food/egg.png"),
    PIE("/items/food/pie.png"),

    // Jewelry
    // Amulets
    BONE_AMULET("/items/jewelry/amulets/bone_amulet.png"),
    FANG_AMULET("/items/jewelry/amulets/fang_amulet.png"),
    GEM_AMULET("/items/jewelry/amulets/gem_amulet.png"),
    STAR_AMULET("/items/jewelry/amulets/star_amulet.png"),
    // Rings
    GOLD_RING("/items/jewelry/rings/gold_ring.png"),
    EMERALD_RING("/items/jewelry/rings/emerald_ring.png"),
    RUBY_RING("/items/jewelry/rings/ruby_ring.png"),
    AMETHYST_RING("/items/jewelry/rings/amethyst_ring.png"),
    SAPPHIRE_RING("/items/jewelry/rings/sapphire_ring.png"),

    // Misc
    BLUE_SCROLL("/items/misc/blue_scroll.png"),
    RED_SCROLL("/items/misc/red_scroll.png"),
    READABLE_SCROLL("/items/misc/readable_scroll.png"),
    CANDLE("/items/misc/candle.png"),
    CHALLICE("/items/misc/challice.png"),
    WOODEN_KEY("/items/misc/wooden_key.png"),
    IRON_KEY("/items/misc/iron_key.png"),
    STONE_TABLET("/items/misc/stone_tablet.png"),

    // Armour
    // Boots
    LEATHER_BOOTS("/items/armour/boots/leather_boots.png"),
    IRON_BOOTS("/items/armour/boots/iron_boots.png"),
    GOLDEN_BOOTS("/items/armour/boots/golden_boots.png"),
    // Chestplates
    LEATHER_CHESTPLATE("/items/armour/chestplate/leather_chestplate.png"),
    IRON_CHESTPLATE("/items/armour/chestplate/iron_chestplate.png"),
    IRON_CHESTPLATE_2("/items/armour/chestplate/iron_chestplate_2.png"),
    GOLDEN_CHESTPLATE("/items/armour/chestplate/golden_chestplate.png"),
    // Gauntlets
    WORN_IRON_GAUNTLETS("/items/armour/gauntlets/worin_iron_gauntlets.png"),
    IRON_GAUNTLETS("/items/armour/gauntlets/iron_gauntlets.png"),
    LEATHER_FINGERLESS_GLOVES("/items/armour/gauntlets/leather_fingerless_gloves.png"),
    LEATHER_GLOVES("/items/armour/gauntlets/leather_gloves.png"),
    // Helmets
    IRON_HELMET("/items/armour/helmets/iron_helmets.png"),
    HORNED_IRON_HELMET("/items/armour/helmets/horned_iron_helmets.png"),
    DECORATIVE_IRON_HELMET("/items/armour/helmets/decorative_iron_helmets.png"),
    TEMPLAR_HELMET("/items/armour/helmets/templar_helmets.png"),
    // Hats
    CAP("/items/armour/hats/cap.png"),
    HEADBAND("/items/armour/hats/headband.png"),
    POOR_WITCH_HAT("/items/armour/hats/poor_witch_hat.png"),
    WITCH_HAT("/items/armour/hats/witch_hat.png"),
    ;

    private final String path;

    Texture(String path) {
        this.path = path;
    }

    public String getPath() {
        return "/img" + path;
    }
}
