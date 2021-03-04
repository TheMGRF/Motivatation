package me.themgrf.motivatation.game.missions.events.impl;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.effects.EventEffect;
import me.themgrf.motivatation.game.missions.events.effects.EventEffectType;

import java.util.concurrent.ThreadLocalRandom;

public class TripAndFallEvent extends RandomEvent {

    private static final int HEALTH_LOSS = ThreadLocalRandom.current().nextInt(5);

    public TripAndFallEvent() {
        super(
                "Another Happy Landing",
                "In your haste you weren't looking at where you were going and tripped and fell! You saved your face but dropped a few coins on the way down.",
                new EventEffect(
                        "-" + HEALTH_LOSS + " Health",
                        EventEffectType.NEGATIVE
                )
        );
    }

    @Override
    public void onActivate(Player player) {
        player.setHealth(player.getHealth() - HEALTH_LOSS);
    }

    @Override
    public void onEnd(Player player) {

    }
}
