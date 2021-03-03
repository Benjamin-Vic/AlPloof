package fr.alwan.alploof;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class scoreboard {

    public static void update_scoreboard(Player player) {
        final ScoreboardManager manager = Bukkit.getScoreboardManager();
        final Scoreboard board = manager.getNewScoreboard();
        final Objective objective = board.registerNewObjective("dscoreboard", "scoreboard");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§cEpitech à coudre !");
        Score score1 = objective.getScore("                      ");
        score1.setScore(0);
        player.setScoreboard(board);
    }
}
