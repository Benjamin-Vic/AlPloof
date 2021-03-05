package fr.alwan.alploof;

import fr.alwan.alploof.Commands.PloofCommand;
import fr.alwan.alploof.Files.ConfigFile;
import fr.alwan.alploof.Game.Game;
import fr.alwan.alploof.Handlers.PlayerHandler;
import fr.alwan.alploof.Listeners.*;
import fr.alwan.alploof.Memories.ConfigMemory;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class AlPloof extends JavaPlugin {

    public String prefix;

    public Game game;

    public ArrayList<Player> playersInGame = new ArrayList<>();

    public boolean isEditable;
    public int playerlimit;
    public Location divingboard;
    public Location spectator;
    public Location swimmingpoolx1;
    public Location swimmingpoolx2;

    public static AlPloof instance;

    public static AlPloof getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        start_data();
        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        stop_data();
    }

    //
    // Data
    //

    public void start_data() {
        this.game = new Game();
        this.prefix = "§7[§3AlPloof§7] ";
        this.isEditable = false;
        createFolder();
        ConfigFile.create_configFile();
        ConfigMemory.init_configMemory();
        Clock.start_playerClock();
        for (Player player : Bukkit.getOnlinePlayers())
            PlayerHandler.joinPlayer(player);
    }

    public void stop_data() {
        playersInGame.clear();
    }

    public void reload_data() {
        stop_data();
        start_data();
    }

    //
    // Events
    //

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerInteract(), this);
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerDropItem(), this);
        pm.registerEvents(new PlayerPickupItem(), this);
        pm.registerEvents(new BlockBreak(), this);
        pm.registerEvents(new BlockPlace(), this);
    }

    //
    // Commands
    //

    private void registerCommands() {
        this.getCommand("ploof").setExecutor(new PloofCommand());
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
