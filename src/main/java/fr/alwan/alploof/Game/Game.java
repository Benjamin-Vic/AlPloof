package fr.alwan.alploof.Game;

import fr.alwan.alploof.AlPloof;
import fr.alwan.alploof.Handlers.PlayerHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Game {
    private final AlPloof alPloof = AlPloof.getInstance();

    private StartRunnable startRunnable;
    private GameRunnable gameRunnable;
    private int i;

    public Game() {
        this.startRunnable = new StartRunnable(this);
        this.gameRunnable = new GameRunnable(this);
        this.i = 0;
    }

    public void startCountdown() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (alPloof.playersInGame.contains(player))
                PlayerHandler.setPlayer(player);
            else
                PlayerHandler.setPlayerSpectator(player);
            player.teleport(alPloof.spectator);
        }
        startRunnable.runTaskTimer(alPloof, 0, 20L);
    }

    public void stopCountdown() {
        if (startRunnable.getCountdown() > 0) {
            startRunnable.cancel();
            startRunnable = new StartRunnable(this);
        }
    }

    public void startGame() {
        PlayerHandler.teleportPlayerLivingboard(alPloof.playersInGame.get(i));
        gameRunnable.runTaskTimer(alPloof, 0, 2L);
    }

    public StartRunnable getStartRunnable() {
        return startRunnable;
    }

    public GameRunnable getGameRunnable() {
        return gameRunnable;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    /*
    public static void start_game() {
        final AlPloof alPloof = AlPloof.getInstance();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for ()
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (alPloof.playersInGame.contains(player))
                PlayerHandler.setPlayer(player);
            else
                PlayerHandler.setPlayerSpectator(player);
            player.teleport(alPloof.spectator);
            player.sendMessage("§7BITE");
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("%aBITe"));
        }

        if (alPloof.playersInGame.size() != 1)
            start_game();
    }
    */
}
