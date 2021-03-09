package fr.alwan.alploof.Handlers;

import fr.alwan.alploof.AlPloof;
import fr.alwan.alploof.Utils.ItemBuilder;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PlayerHandler {

    public static void setPlayerSpectator(Player player) {
        player.getInventory().clear();
        player.setGameMode(GameMode.SPECTATOR);

    }

    public static void setPlayer(Player player) {
        player.getInventory().clear();
    }

    public static void teleportPlayerLivingboard(Player player) {
        final AlPloof alPloof = AlPloof.getInstance();

        player.teleport(alPloof.divingboard);
        Bukkit.broadcastMessage(alPloof.prefix + "C'est au tour de §b" + player.getName());
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("%aA toi de jouer !"));
        player.playSound(player.getLocation(), Sound.BLOCK_BAMBOO_BREAK, 1, 1);
    }

    public static void removePlayer(Player player) {
        final AlPloof alPloof = AlPloof.getInstance();

        alPloof.playersInGame.remove(player);
        setPlayerSpectator(player);
        for (Player players : Bukkit.getOnlinePlayers())
            players.playSound(players.getLocation(), Sound.BLOCK_ANVIL_BREAK, 1, 1);
    }

    public static void joinPlayer(Player player) {
        final Inventory inventory = player.getInventory();

        player.setGameMode(GameMode.ADVENTURE);
        player.setInvulnerable(true);
        player.setHealth(20);
        player.setFoodLevel(20);
        inventory.clear();
        inventory.setItem(0, ItemBuilder.create_item(Material.GREEN_WOOL, ChatColor.GREEN + "Join the game"));
        inventory.setItem(1, ItemBuilder.create_item(Material.RED_WOOL, ChatColor.RED + "Join spectator"));
    }

    public static void winPlayer(Player player) {
        final AlPloof alPloof = AlPloof.getInstance();

        player.getLocation().getBlock().setType(Material.STONE);
        player.teleport(alPloof.spectator);
    }


}
