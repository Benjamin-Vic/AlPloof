package fr.alwan.alploof.Commands;

import fr.alwan.alploof.AlPloof;
import fr.alwan.alploof.Game.Game;
import fr.alwan.alploof.Memories.ConfigMemory;
import fr.alwan.alploof.Utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class PloofCommand implements CommandExecutor {
    final AlPloof alPloof = AlPloof.getInstance();

    private final String prefix = alPloof.getInstance().prefix;
    private final String errorAlreadyStarting = prefix + "Une partie est déjà en cours";
    private final String errorNotEnoughPlayer = prefix + "Il faut au minimum 2 joueurs pour lancer une partie";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ploof")) {
            if (!sender.isOp() || !(sender instanceof Player))
                return (false);
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("start")) {

                    if (alPloof.game.getStartRunnable().isStarting()) {
                        sender.sendMessage(errorAlreadyStarting);
                        return (false);
                    }
                    if (alPloof.playersInGame.size() == 1) {
                        sender.sendMessage(errorNotEnoughPlayer);
                        return (false);
                    }

                    alPloof.game.startCountdown();

                } else if (args[0].equalsIgnoreCase("reset")) {

                    //
                    // Reset
                    //

                } else if (args[0].equalsIgnoreCase("wand")) {

                    ((Player) sender).getInventory().addItem(ItemBuilder.create_item(Material.DIAMOND_SWORD, "§aL'épée de Karim", "Le JavaScript c'est l'avenir !"));

                } else {
                    help(sender);
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("set")) {
                    final File file = alPloof.getFile("config");
                    if (args[1].equalsIgnoreCase("divingboard")) {
                        if (file.exists()) {
                            final YamlConfiguration configFile = alPloof.getYml(file);
                            configFile.set("divingboard.x", ((Player) sender).getLocation().getBlockX());
                            configFile.set("divingboard.y", ((Player) sender).getLocation().getBlockY());
                            configFile.set("divingboard.z", ((Player) sender).getLocation().getBlockZ());
                            alPloof.saveYml(file, configFile);
                            ConfigMemory.init_configMemory();
                            sender.sendMessage(prefix + "Vous venez de définir le plongeoir");
                        }
                    } else if (args[1].equalsIgnoreCase("spectator")) {
                        if (file.exists()) {
                            final YamlConfiguration configFile = alPloof.getYml(file);
                            configFile.set("spectator.x", ((Player) sender).getLocation().getBlockX());
                            configFile.set("spectator.y", ((Player) sender).getLocation().getBlockY());
                            configFile.set("spectator.z", ((Player) sender).getLocation().getBlockZ());
                            alPloof.saveYml(file, configFile);
                            ConfigMemory.init_configMemory();
                            sender.sendMessage(prefix + "Vous venez de définir l'emplacement des spectateurs");
                        }
                    } else if (args[1].equalsIgnoreCase("editable")) {

                        //
                        // Set
                        //

                    } else {
                        help(sender);
                    }
                } else {
                    help(sender);
                }
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (args[1].equalsIgnoreCase("playerlimit")) {

                        //
                        // Set la limite de joueur
                        //

                    } else {
                        help(sender);
                    }
                } else {
                    help(sender);
                }
            } else {
                help(sender);
            }
            return (true);
        }
        return (false);
    }

    private void help(CommandSender sender) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix + "AlPloof help :\n");
        sb.append("- /ploof start\n");
        sb.append("- /ploof reset\n");
        sb.append("- /ploof wand\n");
        sb.append("- /ploof set divingboard\n");
        sb.append("- /ploof set spectator\n");
        sb.append("- /ploof set editable\n");
        sb.append("- /ploof set playerlimit < int >\n");
        sender.sendMessage(sb.toString());
    }
}
