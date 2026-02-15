package dev.mahiro.listener;

import dev.mahiro.CrystalLeader;
import dev.mahiro.listener.impl.FrameItems;
import dev.mahiro.listener.impl.Player;
import dev.mahiro.listener.impl.RespawnRegular;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Listeners {
    public static void register() {
        register(new FrameItems());
        register(new Player());
        register(new RespawnRegular());
    }

    private static void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, CrystalLeader.INSTANCE);
    }
}