package me.themgrf.motivatation.entities;

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
}
