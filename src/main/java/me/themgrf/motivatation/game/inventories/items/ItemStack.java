package me.themgrf.motivatation.game.inventories.items;

public class ItemStack {

    private final Item item;
    private int amount;

    public ItemStack(Item item) {
        this.item = item;
        this.amount = 1;
    }

    public ItemStack(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
