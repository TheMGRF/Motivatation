package me.themgrf.motivatation.game.missions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ActionRecorder {

    public static final HashMap<Long, List<String>> EVENT_LIST = new HashMap<>();

    public static void addEvent(long id, String event) {
        List<String> events = EVENT_LIST.get(id);
        if (events == null) {
            List<String> list = new ArrayList<>();
            list.add(event);

            EVENT_LIST.put(id, list);
        } else {
            events.add(event);
            EVENT_LIST.put(id, events);
        }
    }

    public static void setEvents(long id, List<String> events) {
        EVENT_LIST.put(id, events);
    }

    public static void clearEvents(long id) {
        EVENT_LIST.remove(id);
    }

    public enum Action {
        PLAYER_DAMAGE_ENTITY("You dealt %damage%♥ to %entity%"),
        ENTITY_DAMAGE_ENTITY("%entity1% damaged %entity2% for %damage%♥"),
        ENVIRONMENT_DAMAGE_ENTITY("%entity% took %damage%♥ environmental damage"),
        ;

        private String msg;

        Action(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public String getMsg(String... strings) {
            for (int i = 0; i < strings.length; i++) {
                msg = msg.replaceAll("%" + strings[i] + "%", strings[++i]);
            }

            return msg;
        }
    }
}
