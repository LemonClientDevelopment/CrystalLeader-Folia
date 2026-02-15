package dev.mahiro.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Utils {
    public static World OVERWORLD, NETHER;
    public static ExecutorService worker;
    public static Plugin PLUGIN_INSTANCE;

    public static void onEnable(Plugin instance) {
        PLUGIN_INSTANCE = instance;
        OVERWORLD = Bukkit.getWorld("world");
        NETHER = Bukkit.getWorld("world_nether");
        worker = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public static void onDisable() {
        worker.shutdownNow();
    }
}
