package dev.mahiro;

import dev.mahiro.listeners.FrameItems;
import dev.mahiro.utils.MessageUtils;
import dev.mahiro.utils.TimerUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class CrystalLeader extends JavaPlugin {
    public static CrystalLeader INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        Long time = calcTime(() -> {
            getLogger().info(MessageUtils.withColor("&aStart loading CrystalLeader..."));

            saveDefaultConfig();
            getLogger().info(MessageUtils.withColor("&aLoaded configuration"));

            // 这里注册事件
            register(new FrameItems());

            getLogger().info(ChatColor.BLUE + """
                    
                       ____                _        _   _                   _          \s
                      / ___|_ __ _   _ ___| |_ __ _| | | |    ___  __ _  __| | ___ _ __\s
                     | |   | '__| | | / __| __/ _` | | | |   / _ \\/ _` |/ _` |/ _ \\ '__|
                     | |___| |  | |_| \\__ \\ || (_| | | | |__|  __/ (_| | (_| |  __/ |  \s
                      \\____|_|   \\__, |___/\\__\\__,_|_| |_____\\___|\\__,_|\\__,_|\\___|_|  \s
                                 |___/                                                 \s
                    """);
        });
        getLogger().info(MessageUtils.withColor("Loaded CrystalLeader, it took time: " + time + "ms"));
    }

    @Override
    public void onDisable() {
        getLogger().info(MessageUtils.withColor(ChatColor.RED + "Disabled CrystalLeader, thanks for using OwO"));
    }

    private void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, INSTANCE);
    }

    private Long calcTime(Runnable runnable) {
        TimerUtils timer = new TimerUtils();
        runnable.run();
        return timer.passedMs();
    }

    public static int configInt(String path) {
        return INSTANCE.getConfig().getInt(path);
    }

    public static double configDouble(String path) {
        return INSTANCE.getConfig().getDouble(path);
    }

    public static String configString(String path) {
        return INSTANCE.getConfig().getString(path);
    }

    public static List<String> configStringList(String path) {
        return INSTANCE.getConfig().getStringList(path);
    }
}
