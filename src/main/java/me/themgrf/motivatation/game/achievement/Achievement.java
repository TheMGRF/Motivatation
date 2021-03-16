package me.themgrf.motivatation.game.achievement;

import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;
import me.themgrf.motivatation.game.inventories.items.Texture;

public enum Achievement {

    LOG_IN("Logged and loaded!", "Log in for the first time!", Texture.APPLE, 1, new Reward(RewardType.COINS, 10)),
    FIRST_TASK("A Whole New World", "Create your first task!", Texture.READABLE_SCROLL, 1, new Reward(RewardType.COINS, 5)),
    FIVE_TASKS("Dedicated", "Create a total of five tasks!", Texture.BLUE_SCROLL, 5, new Reward(RewardType.COINS, 5)),
    TEN_TASKS("Task Master", "Create a total of ten tasks!", Texture.RED_SCROLL, 10, new Reward(RewardType.GEMS, 10)),

    ;

    public static final Achievement[] VALUES = values();

    private final String name, description;
    private final Texture texture;
    private final int target;
    private final Reward reward;

    Achievement(String name, String description, Texture texture, int target, Reward reward) {
        this.name = name;
        this.description = description;
        this.texture = texture;
        this.target = target;
        this.reward = reward;
    }

    public String getId() {
        return name();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Texture getTexture() {
        return texture;
    }

    public int getTarget() {
        return target;
    }

    public Reward getReward() {
        return reward;
    }
}