package me.themgrf.motivatation.controllers.home;

import me.themgrf.motivatation.controllers.ControllerBase;
import me.themgrf.motivatation.database.PlayerManager;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.game.inventories.Backpack;
import me.themgrf.motivatation.game.inventories.items.Item;
import me.themgrf.motivatation.game.inventories.items.attributes.ItemAttribute;
import me.themgrf.motivatation.util.Auth;
import me.themgrf.motivatation.util.BackpackManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import xyz.minecrossing.coreutilities.CoreUtilities;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

@Controller
public class InventoryController extends ControllerBase {

    @GetMapping("/home/inventory")
    public String inventory(Model model) {
        model = super.setup(model);

        User user = Auth.getUser();
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            Player player = PlayerManager.getPlayer(user);
            model.addAttribute("player", player);

            model.addAttribute("backpack", BackpackManager.get(player.getId()));
        }

        return "home/inventory";
    }

    @GetMapping("/home/inventory/use/{id}")
    public RedirectView useItem(HttpServletRequest req, RedirectAttributes attributes, @PathVariable String id) {
        RedirectView redirectView = new RedirectView("/home/inventory", true);

        User user = Auth.getUser();
        if (user != null) {
            Player player = PlayerManager.getPlayer(user);

            Iterator<Item> items = player.getInventory().getItems().iterator();
            while (items.hasNext()) {
                Item item = items.next();
                if (item.getId().equals(id)) {
                    for (ItemAttribute attribute : item.getItemAttributes()) {
                        attribute.applyEffect(player);
                    }

                    if (item.isConsumable()) {
                        items.remove();
                    }

                    System.out.println(player.getUuid().toString() + " used item: " + item.toString());
                    break;
                }
            }

            CoreUtilities.getTaskManager().runAsync(() -> PlayerManager.savePlayer(player));
        }

        return redirectView;
    }

    @GetMapping("/home/inventory/drop/{id}")
    public RedirectView dropItem(HttpServletRequest req, RedirectAttributes attributes, @PathVariable String id) {
        RedirectView redirectView = new RedirectView("/home/inventory", true);

        User user = Auth.getUser();
        if (user != null) {
            Player player = PlayerManager.getPlayer(user);

            player.getInventory().getItems().removeIf(item -> {
                System.out.println(player.getUuid().toString() + " dropped item: " + item.toString());
                return item.getId().equals(id);
            });

            CoreUtilities.getTaskManager().runAsync(() -> PlayerManager.savePlayer(player));
        }

        return redirectView;
    }

    @GetMapping("/home/inventory/backpack/add/{id}")
    public RedirectView addToBackpack(HttpServletRequest req, RedirectAttributes attributes, @PathVariable String id) {
        RedirectView redirectView = new RedirectView("/home/inventory", true);

        User user = Auth.getUser();
        if (user != null) {
            Player player = PlayerManager.getPlayer(user);

            Backpack backpack = BackpackManager.get(player.getId());
            if (backpack.getItems().size() >= backpack.getSize()) {
                attributes.addFlashAttribute("backpackFull", true);
                return redirectView;
            }

            Iterator<Item> items = player.getInventory().getItems().iterator();
            while (items.hasNext()) {
                Item item = items.next();
                if (item.getId().equals(id)) {
                    backpack.addItem(item);
                    items.remove();

                    System.out.println(player.getUuid().toString() + " moved an item to their backpack: " + item.toString());
                    break;
                }
            }

            CoreUtilities.getTaskManager().runAsync(() -> PlayerManager.savePlayer(player));
        }

        return redirectView;
    }

    @GetMapping("/home/inventory/backpack/remove/{id}")
    public RedirectView removeFromBackpack(HttpServletRequest req, RedirectAttributes attributes, @PathVariable String id) {
        RedirectView redirectView = new RedirectView("/home/inventory", true);

        User user = Auth.getUser();
        if (user != null) {
            Player player = PlayerManager.getPlayer(user);

            //Iterator<Item> items = player.getBackpack().getItems().iterator();
            Backpack backpack = BackpackManager.get(player.getId());
            Iterator<Item> items = backpack.getItems().iterator();
            while (items.hasNext()) {
                Item item = items.next();
                if (item.getId().equals(id)) {
                    player.getInventory().addItem(item);
                    items.remove();

                    System.out.println(player.getUuid().toString() + " moved an item to their inventory: " + item.toString());
                    break;
                }
            }

            CoreUtilities.getTaskManager().runAsync(() -> PlayerManager.savePlayer(player));
        }

        return redirectView;
    }

    @Override
    public String getPageName() {
        return "Motivatation | Home";
    }
}
