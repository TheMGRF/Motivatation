package me.themgrf.motivatation.game.market;

import me.themgrf.motivatation.game.inventories.items.Item;
import me.themgrf.motivatation.game.inventories.items.ItemManager;
import me.themgrf.motivatation.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class MarketManager {

    private static final Set<Pair<Item, Integer>> FOR_SALE = new HashSet<>();

    static {
        FOR_SALE.add(Pair.of(ItemManager.getItem("decorative_blade"), 10));
        FOR_SALE.add(Pair.of(ItemManager.getItem("great_iron_sword"), 20));
        FOR_SALE.add(Pair.of(ItemManager.getItem("greater_iron_sword"), 25));
        FOR_SALE.add(Pair.of(ItemManager.getItem("oak_bow"), 10));
        FOR_SALE.add(Pair.of(ItemManager.getItem("curved_bow"), 15));
        FOR_SALE.add(Pair.of(ItemManager.getItem("apple"), 5));
        FOR_SALE.add(Pair.of(ItemManager.getItem("cheese_wheel"), 7));
        FOR_SALE.add(Pair.of(ItemManager.getItem("pie_slice"), 5));
        FOR_SALE.add(Pair.of(ItemManager.getItem("health_potion_1"), 8));
        FOR_SALE.add(Pair.of(ItemManager.getItem("health_potion_2"), 10));
        FOR_SALE.add(Pair.of(ItemManager.getItem("health_potion_3"), 20));
        FOR_SALE.add(Pair.of(ItemManager.getItem("health_potion_4"), 25));
        FOR_SALE.add(Pair.of(ItemManager.getItem("health_potion_5"), 30));
        FOR_SALE.add(Pair.of(ItemManager.getItem("stamina_potion_1"), 8));
        FOR_SALE.add(Pair.of(ItemManager.getItem("stamina_potion_2"), 10));
        FOR_SALE.add(Pair.of(ItemManager.getItem("stamina_potion_3"), 20));
        FOR_SALE.add(Pair.of(ItemManager.getItem("star_amulet"), 10));
        FOR_SALE.add(Pair.of(ItemManager.getItem("gem_amulet"), 12));
        FOR_SALE.add(Pair.of(ItemManager.getItem("bone_amulet"), 15));
    }

    public static Set<Pair<Item, Integer>> getItemsForSale() {
        return FOR_SALE;
    }

}
