package net.soultide.stcore.handlers;

import net.soultide.stcore.PlayerConfig;
import net.soultide.stcore.player.SoultidePlayer;
import net.soultide.stcore.player.SoultidePlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeft implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        //Getting Player
        Player player = event.getPlayer();

        //Player creation
        if(SoultidePlayerManager.getSoultidePlayer(player) != null) {
            SoultidePlayerManager.getSoultidePlayer(player).saveData();
            SoultidePlayerManager.removePlayer(SoultidePlayerManager.getSoultidePlayer(player));
        }
    }
}
