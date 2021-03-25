package me.themgrf.motivatation.entities;

public class Zombie extends LivingEntity {

    private static final String NAME = "Zombie";

    public Zombie() {
        super(NAME);

        setStrength(5);
    }
}
