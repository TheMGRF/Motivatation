package me.themgrf.motivatation.game.damage;

import me.themgrf.motivatation.entities.LivingEntity;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.inventories.items.Item;
import me.themgrf.motivatation.game.inventories.items.attributes.HealthAttribute;
import me.themgrf.motivatation.game.inventories.items.attributes.ItemAttribute;
import me.themgrf.motivatation.game.missions.actions.Actions;
import me.themgrf.motivatation.util.BackpackManager;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class FightUtil {

    /**
     * Calculate a fight for a player against another entity
     * and determine the winner of the fight.
     *
     * @param player The player to fight
     * @param entity The entity for the player to fight against
     * @return <code>true</code> if the player wins the fight, <code>false</code> otherwise
     */
    public static boolean fight(Player player, LivingEntity entity) {
        long id = player.getId();
        double speed = player.getSpeed();

        while (player.getHealth() > 0 || entity.getHealth() > 0) {
            if (player.getHealth() <= 0) {
                Actions.playerDeath(id, entity);
                player.setDead(true);
                return false;
            }

            if (entity.getHealth() <= 0) {
                Actions.playerKill(id, entity);
                entity.setDead(true);
                return true;
            }

            // Let player heal if they can and are on low health
            if (player.getHealth() <= 5) {
                Iterator<Item> iterator = BackpackManager.get(player.getId()).getItems().iterator();
                itemLoop:
                while (iterator.hasNext()) {
                    Item item = iterator.next();

                    if (item.getItemAttributes().isEmpty()) continue;

                    for (ItemAttribute attribute : item.getItemAttributes()) {
                        if (attribute.isPositive()) {
                            if (attribute instanceof HealthAttribute) {
                                attribute.applyEffect(player);
                                Actions.playerHeal(id, item.getName(), attribute.getAmount());

                                if (item.isConsumable()) {
                                    iterator.remove(); // Remove the item from the users backpack as it has been used
                                }
                                break itemLoop;
                            }
                        }
                    }
                }
            }

            // If player speed is low zombie attacks first
            double rand = ThreadLocalRandom.current().nextDouble(speed);
            if (rand < (speed / 2)) {
                // player was too slow - zombie attacks
                int damage = DamageHandler.calculateDamage(entity, player);
                player.damage(damage);

                Actions.entityDamagePlayer(id, entity, damage);
            } else {
                // players speed was good and gets first hit
                int damage = DamageHandler.calculateDamage(player, entity);
                entity.damage(damage);

                Actions.playerDamageEntity(id, entity, damage);
            }
        }

        return true;
    }

}
