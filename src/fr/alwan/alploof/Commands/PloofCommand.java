package fr.alwan.alploof.Commands;

import fr.alwan.alploof.AlPloof;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PloofCommand implements CommandExecutor {
    final AlPloof alPloof = AlPloof.getInstance();

    private final String prefix = alPloof.getInstance().prefix;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ploof")) {
            if (!sender.isOp() || !(sender instanceof Player))
                return (false);
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("start")) {

                    //
                    // Start
                    //

                } else if (args[0].equalsIgnoreCase("reset")) {

                    //
                    // Reset
                    //

                } else {

                    //
                    // help
                    //

                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (args[1].equalsIgnoreCase("divingboard")) {

                        //
                        // Set l'endroit du plongeoir
                        //

                    } else if (args[1].equalsIgnoreCase("spectator")) {

                        //
                        // Set l'endroit des spectateurs
                        //

                    } else {

                        //
                        // help
                        //

                    }
                } else {

                    //
                    // help
                    //

                }
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (args[1].equalsIgnoreCase("playerlimit")) {

                        //
                        // Set la limite de joueur
                        //

                    } else {

                        //
                        // help
                        //

                    }
                } else {

                    //
                    // help
                    //

                }
            } else {

                //
                // help
                //

            }
            return (true);
        }
        return (false);
    }
}
