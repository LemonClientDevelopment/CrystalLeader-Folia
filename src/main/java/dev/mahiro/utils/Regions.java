package dev.mahiro.utils;

import dev.mahiro.CrystalLeader;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Regions {
    private final Location from;
    private final Location to;

    public Regions(Location from, Location to) {
        this.from = new Location(from.getWorld(),
                Math.min(from.getBlockX(), to.getBlockX()),
                Math.min(from.getBlockY(), to.getBlockY()),
                Math.min(from.getBlockZ(), to.getBlockZ()));

        this.to = new Location(to.getWorld(),
                Math.max(from.getBlockX(), to.getBlockX()),
                Math.max(from.getBlockY(), to.getBlockY()),
                Math.max(from.getBlockZ(), to.getBlockZ()));
    }

    public boolean isInArea(Location loc) {
        if (!loc.getWorld().equals(from.getWorld())) {
            return false;
        }

        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        return x >= from.getBlockX() && x <= to.getBlockX()
                && y >= from.getBlockY() && y <= to.getBlockY()
                && z >= from.getBlockZ() && z <= to.getBlockZ();
    }

    public static boolean isInAnyPvp(Player player) {
        Regions pvpArea1 = new Regions(
                new Location(player.getWorld(), CrystalLeader.configInt("Regions.AnyPvp.pvpArea1.from.x"), CrystalLeader.configInt("Regions.AnyPvp.pvpArea1.from.y"), CrystalLeader.configInt("Regions.AnyPvp.pvpArea1.from.z")),
                new Location(player.getWorld(), CrystalLeader.configInt("Regions.AnyPvp.pvpArea1.to.x"), CrystalLeader.configInt("Regions.AnyPvp.pvpArea1.to.y"), CrystalLeader.configInt("Regions.AnyPvp.pvpArea1.to.z"))
        );
        Regions pvpArea2 = new Regions(
                new Location(player.getWorld(), CrystalLeader.configInt("Regions.AnyPvp.pvpArea2.from.x"), CrystalLeader.configInt("Regions.AnyPvp.pvpArea2.from.y"), CrystalLeader.configInt("Regions.AnyPvp.pvpArea2.from.z")),
                new Location(player.getWorld(), CrystalLeader.configInt("Regions.AnyPvp.pvpArea2.to.x"), CrystalLeader.configInt("Regions.AnyPvp.pvpArea2.to.y"), CrystalLeader.configInt("Regions.AnyPvp.pvpArea2.to.z"))
        );
        return pvpArea1.isInArea(player.getLocation()) || pvpArea2.isInArea(player.getLocation());
    }
}
