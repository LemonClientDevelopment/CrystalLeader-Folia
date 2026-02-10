package dev.mahiro.command;

import dev.mahiro.command.impl.RkitCommand;
import org.bukkit.Bukkit;

public class Commands {
    public static void register() {
        Bukkit.getCommandMap().register("crystalleader", new RkitCommand());
    }
}
