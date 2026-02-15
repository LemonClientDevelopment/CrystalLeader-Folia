package dev.mahiro.listener.impl;

import dev.mahiro.CrystalLeader;
import dev.mahiro.utils.Regions;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Player implements Listener {
    private final FileConfiguration config = CrystalLeader.INSTANCE.getConfig();

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().spigot().respawn();

        event.setJoinMessage(ChatColor.GREEN + event.getPlayer().getName() + ChatColor.GRAY + " joined");

        if (config.getBoolean("RespawnRegular.clearInventory")) {
            event.getPlayer().getInventory().clear();
        }
    }

    @EventHandler
    private void onPlayerQuit(PlayerQuitEvent event) {
        if (Regions.isInAnyPvp(event.getPlayer())) {
            event.getPlayer().setHealth(0);
        }

        event.setQuitMessage(ChatColor.RED + event.getPlayer().getName() + ChatColor.GRAY + " left");

        event.getPlayer().getEnderChest().clear();
    }

    @EventHandler
    private void onPlayerDeath(PlayerDeathEvent event) {
        event.setDroppedExp(0);
    }
}
