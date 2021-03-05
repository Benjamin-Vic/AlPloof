package fr.alwan.alploof.Files;

import fr.alwan.alploof.AlPloof;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigFile {

    public static void create_configFile() {
        final AlPloof alPloof = AlPloof.getInstance();
        final File file = alPloof.getFile("config");

        if (!file.exists()) {
            try {
                file.createNewFile();
                final YamlConfiguration configFile = alPloof.getYml(file);

                // Payer limit
                configFile.set("playerlimit", 8);

                // Diving board
                configFile.set("divingboard.world", "world");
                configFile.set("divingboard.x", 0);
                configFile.set("divingboard.y", 120);
                configFile.set("divingboard.z", 0);

                // Spectator
                configFile.set("spectator.world", "world");
                configFile.set("spectator.x", 0);
                configFile.set("spectator.y", 120);
                configFile.set("spectator.z", 0);

                // Border
                configFile.set("border", Material.STONE.toString());

                // Swimming Pool
                configFile.set("swimmingpool.x1.world", "world");
                configFile.set("swimmingpool.x1.x", 0);
                configFile.set("swimmingpool.x1.y", 120);
                configFile.set("swimmingpool.x1.z", 0);
                configFile.set("swimmingpool.x2.world", "world");
                configFile.set("swimmingpool.x2.x", 0);
                configFile.set("swimmingpool.x2.y", 120);
                configFile.set("swimmingpool.x2.z", 0);

                alPloof.saveYml(file, configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
