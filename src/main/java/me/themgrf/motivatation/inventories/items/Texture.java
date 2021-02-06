package me.themgrf.motivatation.inventories.items;

public enum Texture {

    // Swords
    SLIM_IRON_SWORD("/items/swords/slim_iron_sword.png"),
    IRON_SWORD("/items/swords/iron_sword.png"),
    JEWELED_IRON_SWORD("/items/swords/jeweled_iron_sword.png"),
    PINCER_SWORD("/items/swords/pincer_sword.png"),
    JEWELED_PINCER_SWORD("/items/swords/jeweled_pincer_sword.png"),
    CURVED_SWORD("/items/swords/curved_sword.png"),
    GREAT_IRON_SWORD("/items/swords/great_iron_sword.png"),
    GREATER_IRON_SWORD("/items/swords/greater_iron_sword.png");

    private final String path;

    Texture(String path) {
        this.path = path;
    }

    public String getPath() {
        return "/img" + path;
    }
}
