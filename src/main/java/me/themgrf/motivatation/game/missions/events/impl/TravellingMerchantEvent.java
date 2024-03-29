package me.themgrf.motivatation.game.missions.events.impl;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.RandomEventType;
import me.themgrf.motivatation.game.missions.events.effects.EventEffect;
import me.themgrf.motivatation.game.missions.events.effects.EventEffectType;

import java.util.concurrent.ThreadLocalRandom;

public class TravellingMerchantEvent extends RandomEvent {

    private static final int COIN_GAIN = ThreadLocalRandom.current().nextInt(1, 30);

    public TravellingMerchantEvent() {
        super(
                "Hello There!",
                "You bumped into a travelling merchant on the roads, he purchased some of your miscellaneous goods!",
                RandomEventType.TRAVELLING_MERCHANT,
                new EventEffect(
                        "+" + COIN_GAIN + " Coins",
                        EventEffectType.POSITIVE
                )
        );
    }

    @Override
    public boolean activate(Player player) {
        player.addCoins(COIN_GAIN);
        return true;
    }
}
