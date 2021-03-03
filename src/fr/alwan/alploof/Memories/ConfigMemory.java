package fr.alwan.alploof.Memories;

import fr.alwan.alploof.AlPloof;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigMemory {

    public static void init_configMemory() {
        final AlPloof alPloof = AlPloof.getInstance();
        final YamlConfiguration configFile = alPloof.getYml(alPloof.getFile("config"));

        alPloof.divingboard = new Location(
                Bukkit.getWorld(configFile.getString("divingboard.world")),
                configFile.getDouble("divingboard.x"),
                configFile.getDouble("divingboard.y"),
                configFile.getDouble("divingboard.z"));

        alPloof.spectator = new Location(
                Bukkit.getWorld(configFile.getString("spectator.world")),
                configFile.getDouble("spectator.x"),
                configFile.getDouble("spectator.y"),
                configFile.getDouble("spectator.z"));

    }
}
