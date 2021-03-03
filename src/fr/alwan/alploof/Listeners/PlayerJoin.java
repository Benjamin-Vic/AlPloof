package fr.alwan.alploof.Listeners;

import com.sun.javafx.tk.quantum.MasterTimer;
import fr.alwan.alploof.AlPloof;
import fr.alwan.alploof.Utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final Inventory inventory = player.getInventory();

        inventory.clear();
        inventory.setItem(0, ItemBuilder.create_item(Material.GREEN_WOOL, ChatColor.GREEN + "Join the game"));
        inventory.setItem(1, ItemBuilder.create_item(Material.RED_WOOL, ChatColor.RED + "Join spectator"));

    }
}
