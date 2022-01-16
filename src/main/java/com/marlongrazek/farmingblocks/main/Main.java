package com.marlongrazek.farmingblocks.main;

import com.marlongrazek.datafile.DataFile;
import com.marlongrazek.farmingblocks.commands.CMDfarmingblocks;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {

        plugin = this;

        registerCommands();

        Bukkit.getConsoleSender().sendMessage("§eFarmingBlocks §fsuccessfully enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        getCommand("farmingblock").setExecutor(new CMDfarmingblocks());
    }

    public static DataFile getDataFile(String name) {
        DataFile dataFile = null;
        for (File file : plugin.getDataFolder().listFiles())
            if (file.getName().equalsIgnoreCase(name + ".yml")) dataFile = new DataFile(file);
        return dataFile;
    }

    public static Main getPlugin() {
        return plugin;
    }
}
