package fr.alwan.alploof.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        final Player player = event.getPlayer();

        if (!player.isOp())
            event.setCancelled(true);
    }
}
