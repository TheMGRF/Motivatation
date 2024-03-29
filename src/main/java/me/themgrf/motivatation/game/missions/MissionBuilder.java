package me.themgrf.motivatation.game.missions;

import me.themgrf.motivatation.game.missions.events.Event;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.rewards.Reward;

import java.util.List;

public class MissionBuilder {

    private String id, name, description;
    private int level;
    private Mission.DangerLevel dangerLevel;
    private Mission.JourneyTime journeyTime;
    private List<RandomEvent> randomEvents;
    private Event event;
    private List<Reward> rewards;

    public MissionBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public MissionBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MissionBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public MissionBuilder setLevel(int level) {
        this.level = level;
        return this;
    }

    public MissionBuilder setDangerLevel(Mission.DangerLevel dangerLevel) {
        this.dangerLevel = dangerLevel;
        return this;
    }

    public MissionBuilder setJourneyTime(Mission.JourneyTime journeyTime) {
        this.journeyTime = journeyTime;
        return this;
    }

    public MissionBuilder setRandomEvents(List<RandomEvent> randomEvents) {
        this.randomEvents = randomEvents;
        return this;
    }

    public MissionBuilder setEvent(Event event) {
        this.event = event;
        return this;
    }

    public MissionBuilder setRewards(List<Reward> rewards) {
        this.rewards = rewards;
        return this;
    }

    public Mission createMission() {
        return new Mission(id, name, description, level, dangerLevel, journeyTime, randomEvents, event, rewards);
    }
}