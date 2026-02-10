package dev.mahiro.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {
    // General
    public static String cantUseThisInPvp() {
        return "你不能在PVP场地使用这个命令.";
    }

    // Prefixes
    public static final String PREFIX = ChatColor.GRAY + "[" + ChatColor.GREEN + "CrystalLeader" + ChatColor.GRAY + "] " + ChatColor.WHITE;

    public static void sendMessage(String string) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(string);
        }
    }

    public static void sendMessage(String... string) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(string);
        }
    }
}
