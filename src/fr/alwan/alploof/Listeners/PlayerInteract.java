package fr.alwan.alploof.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final Material material = event.getItem().getType();

        player.sendMessage("isBlock " + material.isBlock());
        player.sendMessage("isOccluding " + material.isOccluding());
        player.sendMessage("isInteractable " + material.isInteractable());
    }
}
