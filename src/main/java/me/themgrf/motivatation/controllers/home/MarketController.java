package me.themgrf.motivatation.controllers.home;

import me.themgrf.motivatation.controllers.ControllerBase;
import me.themgrf.motivatation.database.PlayerManager;
import me.themgrf.motivatation.entities.Player;
import me.themgrf.motivatation.entities.User;
import me.themgrf.motivatation.game.inventories.items.Item;
import me.themgrf.motivatation.game.inventories.items.ItemManager;
import me.themgrf.motivatation.util.Auth;
import me.themgrf.motivatation.util.Economy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MarketController extends ControllerBase {

    @GetMapping("/home/market")
    public String market(Model model) {
        model = super.setup(model);

        User user = Auth.getUser();
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            Player player = PlayerManager.getPlayer(user);
            model.addAttribute("player", player);
            model.addAttribute("items", ItemManager.getItems().values());
        }

        return "home/market";
    }

    @PostMapping("/home/market/item/{item}")
    public RedirectView buyItem(HttpServletRequest req, RedirectAttributes attributes, @PathVariable String item) {
        RedirectView redirectView = new RedirectView("/home/market", true);

        //model = super.setup(model);

        User user = Auth.getUser();
        if (user != null) {
            attributes.addFlashAttribute("username", user.getUsername());
            Player player = PlayerManager.getPlayer(user);
            attributes.addFlashAttribute("player", player);
            attributes.addFlashAttribute("items", ItemManager.getItems().values());

            // Get the item from param and give it to the player whilst subtracting the cost from their balance
            Item realItem = ItemManager.getItem(item);
            if (Economy.canAfford(player, realItem)) {
                Economy.purchase(player, realItem);
                player.getInventory().addItem(realItem);
                PlayerManager.savePlayer(player);

                attributes.addFlashAttribute("purchasedItem", realItem);
            } else {
                attributes.addFlashAttribute("error", true);
            }
        }

        //return "home/market";
        return redirectView;
    }

    @Override
    public String getPageName() {
        return "Motivatation | Home";
    }

}
