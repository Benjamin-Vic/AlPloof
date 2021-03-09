package fr.alwan.alploof.Memories;

import fr.alwan.alploof.AlPloof;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigMemory {

    public static void init_configMemory() {
        final AlPloof alPloof = AlPloof.getInstance();
        final YamlConfiguration configFile = alPloof.getYml(alPloof.getFile("config"));

        alPloof.playerlimit = configFile.getInt("playerlimit");

        alPloof.divingboard = new Location(
                Bukkit.getWorld(configFile.getString("divingboard.world")),
                configFile.getDouble("divingboard.x") + 0.5,
                configFile.getDouble("divingboard.y") + 0.5,
                configFile.getDouble("divingboard.z") + 0.5);

        alPloof.spectator = new Location(
                Bukkit.getWorld(configFile.getString("spectator.world")),
                configFile.getDouble("spectator.x") + 0.5,
                configFile.getDouble("spectator.y") + 0.5,
                configFile.getDouble("spectator.z") + 0.5);

        alPloof.swimmingpoolx1 = new Location(
                Bukkit.getWorld(configFile.getString("swimmingpool.x1.world")),
                configFile.getDouble("swimmingpool.x1.x"),
                configFile.getDouble("swimmingpool.x1.y"),
                configFile.getDouble("swimmingpool.x1.z"));

        alPloof.swimmingpoolx2 = new Location(
                Bukkit.getWorld(configFile.getString("swimmingpool.x2.world")),
                configFile.getDouble("swimmingpool.x2.x"),
                configFile.getDouble("swimmingpool.x2.y"),
                configFile.getDouble("swimmingpool.x2.z"));

    }
}
