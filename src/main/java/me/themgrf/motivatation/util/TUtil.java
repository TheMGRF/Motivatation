package me.themgrf.motivatation.util;

public class TUtil {

    public static String getMessage(String msg, String... args) {
        for (int i = 0; i < args.length; i++) {
            msg = msg.replaceAll("%" + args[i] + "%", args[++i]);
        }

        return msg;
    }

}
