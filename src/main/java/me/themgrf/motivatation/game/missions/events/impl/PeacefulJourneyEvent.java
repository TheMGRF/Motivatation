package me.themgrf.motivatation.game.missions.events.impl;

import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.missions.events.RandomEvent;
import me.themgrf.motivatation.game.missions.events.RandomEventType;
import me.themgrf.motivatation.game.missions.events.effects.EventEffect;
import me.themgrf.motivatation.game.missions.events.effects.EventEffectType;

public class PeacefulJourneyEvent extends RandomEvent {

    public PeacefulJourneyEvent() {
        super(
                "",
                "",
                RandomEventType.PEACEFUL_JOURNEY,
                new EventEffect(
                        "",
                        EventEffectType.NEUTRAL
                )
        );
    }

    @Override
    public boolean activate(Player player) {
        return true;
    }
}
