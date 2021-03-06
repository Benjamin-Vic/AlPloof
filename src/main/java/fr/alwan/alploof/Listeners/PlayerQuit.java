package fr.alwan.alploof.Listeners;

import fr.alwan.alploof.AlPloof;
import fr.alwan.alploof.Handlers.PlayerHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final AlPloof alPloof = AlPloof.getInstance();

        if (alPloof.playersInGame.contains(player))
            PlayerHandler.removePlayer(player);
    }
}
