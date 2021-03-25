package me.themgrf.motivatation.util;

import java.text.NumberFormat;

public class MathUtil {

    public static double roundDecimal(double round) {
        return Math.round(round);
    }

    public static int round(double round) {
        return (int) round;
    }

    public static String format(int amount) {
        return NumberFormat.getInstance().format(amount);
    }

}
