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
                configFile.set("plongeoir.x", "0");
                configFile.set("plongeoir.y", "120");
                configFile.set("plongeoir.z", "0");
                alPloof.saveYml(file, configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
