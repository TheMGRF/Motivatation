package me.themgrf.motivatation.game.achievement;

import me.themgrf.motivatation.game.rewards.Reward;
import me.themgrf.motivatation.game.rewards.RewardType;
import me.themgrf.motivatation.game.inventories.items.Texture;

public enum Achievement {

    LOG_IN("Logged and loaded!", "Log in for the first time!", Texture.APPLE, 1, new Reward(RewardType.COINS, 10)),
    FIRST_TASK("A Whole New World", "Create your first task!", Texture.READABLE_SCROLL, 1, new Reward(RewardType.COINS, 5)),
    FIVE_TASKS("Dedicated", "Create a total of five tasks!", Texture.BLUE_SCROLL, 5, new Reward(RewardType.COINS, 5)),
    TEN_TASKS("Task Master", "Create a total of ten tasks!", Texture.RED_SCROLL, 10, new Reward(RewardType.GEMS, 10)),
    FIRST_ADVENTURE("First Adventure!", "Embark on your first mission!", Texture.JEWELED_IRON_SWORD, 1, new Reward(RewardType.COINS, 10)),
    SEASONED_ADVENTURER("Seasoned Adventurer!", "Complete your first 5 missions!", Texture.DECORATIVE_IRON_HELMET, 5, new Reward(RewardType.COINS, 50)),
    PRESTIGIOUS("Prestigious", "Reset missions for the first time!", Texture.AMETHYST_RING, 1, new Reward(RewardType.GEMS, 5)),
    APPRENTICE("Apprentice", "Reach Level 5", Texture.CAP, 5, new Reward(RewardType.COINS, 10)),
    ADEPT("Adept", "Reach Level 10", Texture.FANG_AMULET, 10, new Reward(RewardType.COINS, 20)),
    EXPERT("Expert", "Reach Level 25", Texture.EMERALD_RING, 25, new Reward(RewardType.COINS, 50)),
    MASTER("Master", "Reach Level 50", Texture.TEMPLAR_HELMET, 50, new Reward(RewardType.COINS, 100)),
    GOLDEN_TOUCH("Golden Touch", "Have 100,000 Gold", Texture.CHALLICE, 100_000, new Reward(RewardType.GEMS, 50)),
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