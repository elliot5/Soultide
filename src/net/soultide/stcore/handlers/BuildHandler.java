package net.soultide.stcore.handlers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildHandler implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if(!player.hasPermission("soultide.build")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to place blocks!");
            event.setCancelled(true);
        } else {
            player.sendMessage(ChatColor.GREEN + "Block placed.");
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(!player.hasPermission("soultide.build")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to break blocks!");
            event.setCancelled(true);
        } else {
            player.sendMessage(ChatColor.GREEN + "Block destroyed.");
        }
    }
}
