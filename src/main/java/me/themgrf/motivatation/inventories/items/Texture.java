package me.themgrf.motivatation.inventories.items;

public enum Texture {

    TEST("/assets/swords/test.png");

    private final String path;

    Texture(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
