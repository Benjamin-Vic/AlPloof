package fr.alwan.alploof;

import fr.alwan.alploof.Files.ConfigFile;
import fr.alwan.alploof.Listeners.PlayerJoin;
import fr.alwan.alploof.Listeners.PlayerQuit;
import fr.alwan.alploof.Memories.ConfigMemory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AlPloof extends JavaPlugin {

    public ArrayList<Player> playersInGame = new ArrayList<>();
    public Location divingboard;
    public Location spectator;

    public static AlPloof instance;

    public static AlPloof getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        start_data();
        registerListeners();
    }

    @Override
    public void onDisable() {
        stop_data();
    }

    //
    // Events
    //

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
    }

    //
    // Data
    //

    private void start_data() {
        createFolder();
        ConfigFile.create_configFile();
        ConfigMemory.init_configMemory();
        Clock.start_playerClock();
    }

    private void stop_data() {

    }

    //
    // Files
    //

    public static void createFolder() {
        final File mainDirectory = new File("plugins/AlPloof");
        if (!mainDirectory.exists())
            mainDirectory.mkdir();
    }

    public static File getFile(String fileName) {
        final File dataDirectory = new File("plugins/AlPloof");
        return (new File(dataDirectory, fileName + ".yml"));
    }

    public static YamlConfiguration getYml(File file) {
        YamlConfiguration config = new YamlConfiguration();
        FileInputStream fileinputstream;
        try {
            fileinputstream = new FileInputStream(file);
            config.load(new InputStreamReader(fileinputstream, StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            System.out.print("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return (config);
    }

    public static void saveYml(File file, YamlConfiguration config) {
        try {
            Writer fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
            fileWriter.write(config.saveToString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
