package fr.alwan.alploof;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class Clock {

    private static void update_scoreboard(Player player) {
        final AlPloof alPloof = AlPloof.getInstance();
        final Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective objective = board.registerNewObjective("dscoreboard", "scoreboard");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.GOLD + "Epitech à coudre !");

        Score score3 = objective.getScore(" ");
        score3.setScore(3);

        Score score2 = objective.getScore(ChatColor.AQUA + "Players in game : " + ChatColor.GOLD + alPloof.playersInGame.size() + "/" + alPloof.playerlimit);
        score2.setScore(2);

        Score score1 = objective.getScore("  ");
        score1.setScore(1);

        Score score0;
        if (alPloof.playersInGame.contains(player))
            score0 = objective.getScore(ChatColor.GREEN + "You are in the game !");
        else
            score0 = objective.getScore(ChatColor.RED + "You are not in the game");
        score0.setScore(0);

        player.setScoreboard(board);
    }

    public static void start_playerClock() {
        final AlPloof alPloof = AlPloof.getInstance();

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(alPloof, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                update_scoreboard(player);
            }
        },0, 20L);
    }
}
