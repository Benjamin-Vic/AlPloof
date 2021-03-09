package fr.alwan.alploof.Game;

import fr.alwan.alploof.AlPloof;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class StartRunnable extends BukkitRunnable {
    private final Game game;
    private boolean starting;
    private int countdown;

    public StartRunnable(Game game) {
        this.game = game;
        this.starting = false;
        this.countdown = 10;
    }

    @Override
    public void run() {
        if (countdown == 0) {
            cancel();
            game.startGame();
            this.starting = true;
        }
        Bukkit.broadcastMessage("§7La partie commence dans §b" + countdown + "§7 seconde(s)");
        countdown -= 1;
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(boolean starting) {
        this.starting = starting;
    }
}
