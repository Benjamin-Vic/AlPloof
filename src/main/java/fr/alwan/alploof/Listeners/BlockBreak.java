package fr.alwan.alploof.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        final Player player = event.getPlayer();

        if (!player.isOp())
            event.setCancelled(true);
    }
}
