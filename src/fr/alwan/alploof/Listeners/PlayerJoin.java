package fr.alwan.alploof.Listeners;

import fr.alwan.alploof.AlPloof;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final AlPloof alPloof = AlPloof.getInstance();

        alPloof.playersInGame.add(player);


    }
}
