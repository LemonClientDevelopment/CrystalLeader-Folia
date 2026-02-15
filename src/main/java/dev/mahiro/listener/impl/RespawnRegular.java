package dev.mahiro.listener.impl;

import dev.mahiro.CrystalLeader;
import dev.mahiro.utils.Utils;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnRegular implements Listener {
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        if (!CrystalLeader.INSTANCE.getConfig().getBoolean("RespawnRegular.enable")) return;
        event.setRespawnLocation(new Location(Utils.NETHER, 0.5, 50, 0.5, 1, 0));
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!CrystalLeader.INSTANCE.getConfig().getBoolean("RespawnRegular.enable")) return;

        event.getPlayer().teleportAsync(new Location(Utils.NETHER, 0.5, 50, 0.5, 1, 0)).exceptionally(ex -> {
            event.getPlayer().sendMessage("§c传送至重生点失败: " + ex.getMessage());
            return null;
        });
    }
}
