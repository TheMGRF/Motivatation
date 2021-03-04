package me.themgrf.motivatation.game.missions;

import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.util.Colour;
import org.springframework.util.StringUtils;

import java.util.List;

public class Mission {

    private String name, description;
    private int level;
    private DangerLevel dangerLevel;
    private JourneyTime journeyTime;
    private List<RandomEvent> randomEvents;
    private List<Reward> rewards;

    public Mission(String name, String description, int level, DangerLevel dangerLevel, JourneyTime journeyTime, List<RandomEvent> randomEvents, List<Reward> rewards) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.dangerLevel = dangerLevel;
        this.journeyTime = journeyTime;
        this.randomEvents = randomEvents;
        this.rewards = rewards;
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

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
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
