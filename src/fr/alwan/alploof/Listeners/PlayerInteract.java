package fr.alwan.alploof.Listeners;

import fr.alwan.alploof.AlPloof;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        final AlPloof alPloof = AlPloof.getInstance();
        final Player player = event.getPlayer();

        /*
        player.sendMessage("isBlock " + material.isBlock());
        player.sendMessage("isOccluding " + material.isOccluding());
        player.sendMessage("isInteractable " + material.isInteractable());
        */

        if (event.getItem() == null || alPloof.game.getStartRunnable().isStarting())
            return;
        final Material material = event.getItem().getType();

        if (material == Material.GREEN_WOOL) {
            if (!alPloof.playersInGame.contains(player)) {
                if (alPloof.playersInGame.size() < alPloof.playerlimit) {
                    alPloof.playersInGame.add(player);
                    player.sendMessage(alPloof.prefix + "Vous venez de vous inscrit en tant que §aJoueur");
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                } else {
                    player.sendMessage(alPloof.prefix + "Il n'y a plus de place dans la partie");
                }
            } else {
                player.sendMessage(alPloof.prefix + "Vous êtes déjà inscrit en tant que §aJoueur");
            }
        }

        if (material == Material.RED_WOOL) {
            if (alPloof.playersInGame.contains(player)) {
                alPloof.playersInGame.remove(player);
                player.sendMessage(alPloof.prefix + "Vous venez de vous inscrit en tant que §cSpectateur");
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            } else {
                player.sendMessage(alPloof.prefix + "Vous êtes déjà inscrit en tant que §cSpectateur");
            }
        }
    }
}
