package me.themgrf.motivatation;

public class Motivatation {

    private static Motivatation instance;

    public Motivatation() {
        instance = this;
    }

    public static Motivatation getInstance() {
        return instance;
    }
}
