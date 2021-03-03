package fr.alwan.alploof.Files;

import fr.alwan.alploof.AlPloof;
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
                configFile.set("limit", 8);
                configFile.set("divingboard.world", "world");
                configFile.set("divingboard.x", 0);
                configFile.set("divingboard.y", 120);
                configFile.set("divingboard.z", 0);
                configFile.set("spectator.world", "world");
                configFile.set("spectator.x", 0);
                configFile.set("spectator.y", 120);
                configFile.set("spectator.z", 0);
                alPloof.saveYml(file, configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
