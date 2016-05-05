package net.soultide.stcore.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.logging.Level;

public class SoultidePlayerManager {

    static ArrayList<SoultidePlayer> players = new ArrayList<SoultidePlayer>();

    public static void addPlayer(SoultidePlayer player) {
        players.add(player);
        Bukkit.getLogger().log(Level.INFO, "New player:" + player.player.getDisplayName());
    }

    public static void removePlayer(SoultidePlayer player) {
        players.remove(player);
        Bukkit.getLogger().log(Level.INFO, "Player left");
    }

    public static SoultidePlayer getSoultidePlayer(Player player) {
        for(SoultidePlayer soultidePlayer : players) {
            if(soultidePlayer.player.getUniqueId().compareTo(player.getUniqueId()) == 0) {
                return soultidePlayer;
            }
        }
        return null;
    }

}
