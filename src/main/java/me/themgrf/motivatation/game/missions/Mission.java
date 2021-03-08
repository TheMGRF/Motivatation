package me.themgrf.motivatation.game.missions;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.events.Event;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.util.Colour;
import org.springframework.util.StringUtils;

import java.util.List;

public class Mission implements PlayerRunnable, Completable {

    private String id, name, description;
    private int level;
    private DangerLevel dangerLevel;
    private JourneyTime journeyTime;
    private List<RandomEvent> randomEvents;
    private Event event;
    private List<Reward> rewards;

    public Mission(String id, String name, String description, int level, DangerLevel dangerLevel, JourneyTime journeyTime, List<RandomEvent> randomEvents, Event event, List<Reward> rewards) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.level = level;
        this.dangerLevel = dangerLevel;
        this.journeyTime = journeyTime;
        this.randomEvents = randomEvents;
        this.event = event;
        this.rewards = rewards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public DangerLevel getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(DangerLevel dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public JourneyTime getJourneyTime() {
        return journeyTime;
    }

    public void setJourneyTime(JourneyTime journeyTime) {
        this.journeyTime = journeyTime;
    }

    public List<RandomEvent> getRandomEvents() {
        return randomEvents;
    }

    public void setRandomEvents(List<RandomEvent> randomEvents) {
        this.randomEvents = randomEvents;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    @Override
    public void activate(Player player) {
        event.activate(player);
    }

    @Override
    public void complete(Player player) {
        for (Reward reward : rewards) {
            player.giveReward(reward);
        }
    }

    public enum DangerLevel {

        EASY(Colour.DARK_GREEN),
        MEDIUM(Colour.ORANGE),
        HARD(Colour.LIGHT_RED),
        CHALLENGING(Colour.RED),
        IMPOSSIBLE(Colour.DARK_RED);

        private final String colour;

        DangerLevel(String colour) {
            this.colour = colour;
        }

        public String getColour() {
            return colour;
        }

        public String getName() {
            return StringUtils.capitalize(name().toLowerCase());
        }

    }

    public enum JourneyTime {

        SHORT(Colour.DARK_GREEN),
        MEDIUM(Colour.ORANGE),
        LONG(Colour.LIGHT_RED);

        private final String colour;

        JourneyTime(String colour) {
            this.colour = colour;
        }

        public String getColour() {
            return colour;
        }

        public String getName() {
            return StringUtils.capitalize(name().toLowerCase());
        }

    }
}
