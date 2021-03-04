package me.themgrf.motivatation.game.rewards;

import org.springframework.util.StringUtils;

public enum RewardType {

    COINS,
    GEMS;

    public String getName() {
        return StringUtils.capitalize(name().toLowerCase());
    }
}
