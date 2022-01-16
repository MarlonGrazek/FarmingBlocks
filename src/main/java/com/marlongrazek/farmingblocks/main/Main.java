package com.marlongrazek.farmingblocks.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage("§eFarmingBlocks §fsuccessfully enabled");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
