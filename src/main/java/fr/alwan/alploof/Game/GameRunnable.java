package fr.alwan.alploof.Game;

import fr.alwan.alploof.AlPloof;
import fr.alwan.alploof.Handlers.PlayerHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameRunnable extends BukkitRunnable {
    private final AlPloof alPloof = AlPloof.getInstance();
    private final Game game;

    public GameRunnable(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        if (alPloof.playersInGame.size() == 1) {
            Bukkit.broadcastMessage("§eGG à §b" + alPloof.playersInGame.get(0).getName() + "§e qui vient de remporter cette partie !");
            cancel();
            alPloof.reload_data();
            for (Player player : Bukkit.getOnlinePlayers())
                player.teleport(alPloof.spectator);
            return;
        }
        if (game.getI() > alPloof.playersInGame.size() - 1)
            game.setI(0);

        final Player player = alPloof.playersInGame.get(game.getI());

        if (player.getFallDistance() < 1 && player.getLocation().getBlockY() < alPloof.swimmingpoolx1.getBlockY() + 2) {
            if (player.isInWater()) {
                Bukkit.broadcastMessage(alPloof.prefix + "§b" + player.getName() + "§7 vient de réussir son saut !");
                PlayerHandler.winPlayer(player);
                next();
            } else {
                Bukkit.broadcastMessage(alPloof.prefix + "§b" + player.getName() + "§7 vient de rater son saut !");
                PlayerHandler.removePlayer(player);
                next();
            }
        }
    }

    private void next() {
        game.setI(game.getI() + 1);
        if (game.getI() > alPloof.playersInGame.size() - 1)
            game.setI(0);
        PlayerHandler.teleportPlayerLivingboard(alPloof.playersInGame.get(game.getI()));
    }
}
