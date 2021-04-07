package me.themgrf.motivatation.game.missions;

public enum Difficulty {

    EASY(5, 20),
    MEDIUM(8, 30),
    HARD(10, 40);

    private final int quantity, health;

    Difficulty(int quantity, int health) {
        this.quantity = quantity;
        this.health = health;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getHealth() {
        return health;
    }
}
