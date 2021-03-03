package fr.alwan.alploof.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickupItem implements Listener {

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        final Player player = event.getPlayer();

        if (!player.isOp())
            event.setCancelled(true);
    }
}
