package dev.mahiro.command.impl;

import dev.mahiro.CrystalLeader;
import dev.mahiro.command.MyCommand;
import dev.mahiro.utils.ChatUtils;
import dev.mahiro.utils.Regions;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RkitCommand extends MyCommand {
    public RkitCommand() {
        super("rkit", "Teleports you to kit creator.");
    }

    @Override
    protected boolean onCommand(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player player)) return false;

        if (Regions.isInAnyPvp(player)) {
            sender.sendMessage(ChatUtils.PREFIX + ChatUtils.cantUseThisInPvp());
            return true;
        }

        Location destination = new Location(CrystalLeader.INSTANCE.getServer().getWorld(CrystalLeader.configString("Regions.kitCreator.world")), CrystalLeader.configInt("Regions.kitCreator.x"), CrystalLeader.configInt("Regions.kitCreator.y"), CrystalLeader.configInt("Regions.kitCreator.z"));

        player.teleportAsync(destination).thenAccept(success -> {
            if (!success) return;
            player.sendMessage(ChatUtils.PREFIX + ChatColor.BLUE + "您已传送到kit制作室");
        });

        return true;
    }
}
