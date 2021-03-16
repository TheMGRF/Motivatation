package me.themgrf.motivatation.game.rewards;

public class Reward {

    private final RewardType rewardType;
    private final int amount;

    public Reward(RewardType rewardType, int amount) {
        this.rewardType = rewardType;
        this.amount = amount;
    }

    public RewardType getRewardType() {
        return rewardType;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return amount + " " + rewardType.getName();
    }
}
