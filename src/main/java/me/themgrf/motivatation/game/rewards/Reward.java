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

    public static Reward fromString(String rewardString) {
        String[] args = rewardString.split(",");
        return new Reward(RewardType.valueOf(args[0].toUpperCase()), Integer.parseInt(args[1]));
    }

    public String toDBString() {
        return rewardType.name() + "," + amount;
    }

    @Override
    public String toString() {
        return amount + " " + rewardType.getName();
    }
}
