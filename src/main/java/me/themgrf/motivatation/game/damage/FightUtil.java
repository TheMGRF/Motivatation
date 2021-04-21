package me.themgrf.motivatation.game.damage;

import me.themgrf.motivatation.entities.LivingEntity;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.game.inventories.items.Item;
import me.themgrf.motivatation.game.inventories.items.attributes.HealthAttribute;
import me.themgrf.motivatation.game.inventories.items.attributes.ItemAttribute;
import me.themgrf.motivatation.game.missions.actions.Actions;

import java.util.concurrent.ThreadLocalRandom;

public class FightUtil {

    public static boolean fight(Player player, LivingEntity entity) {
        long id = player.getId();
        double speed = player.getSpeed();

        while (player.getHealth() > 0 || entity.getHealth() > 0) {
            if (player.getHealth() <= 0) {
                Actions.playerDeath(id, entity);
                System.out.println("Player died!");
                return false;
            }

            if (entity.getHealth() <= 0) {
                Actions.playerKill(id, entity);
                System.out.println("Entity died!");
                return true;
            }

            // Let player heal if they can and are on low health
            if (player.getHealth() <= 5) {
                itemLoop: for (Item item : player.getInventory().getItems()) {
                    if (item.getItemAttributes().isEmpty()) continue;

                    for (ItemAttribute attribute : item.getItemAttributes()) {
                        if (attribute.isPositive()) {
                            if (attribute instanceof HealthAttribute) {
                                attribute.applyEffect(player);
                                Actions.playerHeal(id, item.getName(), attribute.getAmount());
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
