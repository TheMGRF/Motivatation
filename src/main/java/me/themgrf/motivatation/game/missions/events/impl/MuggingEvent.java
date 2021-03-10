package me.themgrf.motivatation.game.missions.events.impl;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.RandomEventType;
import me.themgrf.motivatation.game.missions.events.effects.EventEffect;
import me.themgrf.motivatation.game.missions.events.effects.EventEffectType;

import java.util.concurrent.ThreadLocalRandom;

public class MuggingEvent extends RandomEvent {

    private static final int COIN_LOSS = ThreadLocalRandom.current().nextInt(50);

    public MuggingEvent() {
        super(
                "Never should have come here!",
                "You decided to try a new shortcut! It was filled with bandits at every turn... They stole a lot of your gold.",
                RandomEventType.MUGGING,
                new EventEffect(
                        "-" + COIN_LOSS + " Coins",
                        EventEffectType.NEGATIVE
                )
        );
    }

    @Override
    public boolean activate(Player player) {
        player.removeCoins(COIN_LOSS);
        return true;
    }
}
