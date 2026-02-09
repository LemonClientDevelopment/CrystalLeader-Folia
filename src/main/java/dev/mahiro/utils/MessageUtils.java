package dev.mahiro.utils;

import org.bukkit.ChatColor;

public class MessageUtils {
    public static String withColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
