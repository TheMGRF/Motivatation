package me.themgrf.motivatation.game.missions;

import me.themgrf.motivatation.game.missions.events.impl.MuggingEvent;
import me.themgrf.motivatation.game.missions.events.impl.TravellingMerchantEvent;
import me.themgrf.motivatation.game.missions.events.impl.TripAndFallEvent;
import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;

import java.util.Arrays;
import java.util.Collections;

public enum Missions {

    KILL_ZOMBIES_1(
            new MissionBuilder()
                    .setId("KILL_ZOMBIES_1")
                    .setName("Zombie Hunter I")
                    .setDescription("A local town has put an ad out for an adventurer to kill a nearby group of zombies!")
                    .setLevel(1)
                    .setDangerLevel(Mission.DangerLevel.EASY)
                    .setJourneyTime(Mission.JourneyTime.SHORT)
                    .setRandomEvents(Collections.singletonList(new TravellingMerchantEvent()))
                    .setEvent(player -> System.out.println(player.getName() + " has ran Zombie hunter I!"))
                    .setRewards(
                            Arrays.asList(
                                    new Reward(RewardType.EXP, 10),
                                    new Reward(RewardType.COINS, 5)
                            )
                    )
                    .createMission()
    ),
    KILL_ZOMBIES_2(
            new MissionBuilder()
                    .setId("KILL_ZOMBIES_2")
                    .setName("Zombie Hunter II")
                    .setDescription("A nearby port settlement has put an ad out for an adventurer to kill a nearby group of zombies!")
                    .setLevel(2)
                    .setDangerLevel(Mission.DangerLevel.EASY)
                    .setJourneyTime(Mission.JourneyTime.MEDIUM)
                    .setRandomEvents(Collections.singletonList(new TravellingMerchantEvent()))
                    .setEvent(player -> System.out.println(player.getName() + " has ran Zombie hunter II!"))
                    .setRewards(
                            Arrays.asList(
                                    new Reward(RewardType.EXP, 15),
                                    new Reward(RewardType.COINS, 10)
                            )
                    )
                    .createMission()
    ),
    KILL_ZOMBIES_3(
            new MissionBuilder()
                    .setId("KILL_ZOMBIES_3")
                    .setName("Zombie Hunter III")
                    .setDescription("The city of Galen has heard of your zombie slaying skills and wants you to clear out their crypts!")
                    .setLevel(5)
                    .setDangerLevel(Mission.DangerLevel.MEDIUM)
                    .setJourneyTime(Mission.JourneyTime.MEDIUM)
                    .setRandomEvents(Collections.singletonList(new MuggingEvent()))
                    .setEvent(player -> System.out.println(player.getName() + " has ran Zombie hunter III!"))
                    .setRewards(
                            Arrays.asList(
                                    new Reward(RewardType.EXP, 30),
                                    new Reward(RewardType.COINS, 20)
                            )
                    )
                    .createMission()
    ),
    PILGRIMAGE(
            new MissionBuilder()
                    .setId("PILGRIMAGE")
                    .setName("Pilgrimage")
                    .setDescription("The Monks of Arigi have requested a supply drop to their remote temple.")
                    .setLevel(4)
                    .setDangerLevel(Mission.DangerLevel.EASY)
                    .setJourneyTime(Mission.JourneyTime.LONG)
                    .setRandomEvents(Arrays.asList(new MuggingEvent(), new TripAndFallEvent()))
                    .setEvent(player -> System.out.println(player.getName() + " has ran Pilgrimage!"))
                    .setRewards(
                            Arrays.asList(
                                    new Reward(RewardType.EXP, 30),
                                    new Reward(RewardType.COINS, 40)
                            )
                    )
                    .createMission()
    ),
    BUSINESS(
            new MissionBuilder()
                    .setId("BUSINESS")
                    .setName("Taking Care of Business")
                    .setDescription("The ever mysterious Thieves Guild reached out to you about helping them \"re-acquire\" some of their lost belongings.")
                    .setLevel(10)
                    .setDangerLevel(Mission.DangerLevel.HARD)
                    .setJourneyTime(Mission.JourneyTime.MEDIUM)
                    .setRandomEvents(Collections.singletonList(new MuggingEvent()))
                    .setEvent(player -> System.out.println(player.getName() + " has ran Business!"))
                    .setRewards(
                            Arrays.asList(
                                    new Reward(RewardType.EXP, 40),
                                    new Reward(RewardType.COINS, 80)
                            )
                    )
                    .createMission()
    )

    ;

    public static final Missions[] VALUES = values();

    private final Mission mission;

    Missions(Mission mission) {
        this.mission = mission;
    }

    public Mission getMission() {
        return mission;
    }
}
