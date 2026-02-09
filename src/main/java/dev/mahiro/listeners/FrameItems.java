package dev.mahiro.listeners;

import dev.mahiro.CrystalLeader;
import dev.mahiro.utils.MessageUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class FrameItems implements Listener {
    @EventHandler
    public void onInteractFrame(PlayerInteractAtEntityEvent event) {
        FileConfiguration config = CrystalLeader.INSTANCE.getConfig();
        if (!config.getBoolean("FrameItems.enable")) return;
        if (event.getRightClicked() instanceof ItemFrame frame) {
            Player player = event.getPlayer();
            ItemStack mainHand = player.getInventory().getItemInMainHand();
            ItemStack offHand = player.getInventory().getItemInOffHand();
            if (player.isSneaking()) return;
            if (player.isOp() && isEmptyItem(frame.getItem()) && (!isEmptyItem(mainHand) || !isEmptyItem(offHand))) {
                frame.setItem(isEmptyItem(mainHand) ? offHand : mainHand);
            } else if (!isEmptyItem(frame.getItem())) {
                Inventory inventory = Bukkit.createInventory(
                        null,
                        config.getInt("FrameItems.size"),
                        Component.text(MessageUtils.withColor(config.getString("FrameItems.title")))
                );
                inventory.clear();
                for (int i = 0; i < inventory.getSize(); i++) {
                    inventory.setItem(i, withAmount(frame.getItem()));
                }
                player.openInventory(inventory);
                event.setCancelled(true);
            }
        }
    }

    private boolean isEmptyItem(ItemStack itemStack) {
        return itemStack.getType() == Material.AIR;
    }

    private ItemStack withAmount(ItemStack itemStack) {
        ItemStack item = itemStack.clone();
        item.setAmount(Math.min(64, item.getMaxStackSize()));
        return item;
    }
}
