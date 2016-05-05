package net.soultide.stcore.leveling;

import net.soultide.stcore.player.SoultidePlayer;
import net.soultide.stcore.player.SoultidePlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.List;

public class ExperienceManager {


    public static void updateXPBar(Player player) {
        SoultidePlayer soultidePlayer = SoultidePlayerManager.getSoultidePlayer(player);
        if(soultidePlayer != null) {
            float decimal = ((float)soultidePlayer.currentXP / (float)soultidePlayer.targetXP);
            soultidePlayer.experienceBar.setProgress(decimal);
            soultidePlayer.experienceBar.setTitle(ChatColor.GREEN + "Level " + soultidePlayer.level + ChatColor.DARK_GREEN + " (" + soultidePlayer.currentXP + "/" + soultidePlayer.targetXP + ")");
        }
    }

    public static void addExp(Player player, int experience) {
        if(player == null) { return; }
        SoultidePlayer soultidePlayer = SoultidePlayerManager.getSoultidePlayer(player);
        if(soultidePlayer != null) {
            soultidePlayer.currentXP += experience;
            if(soultidePlayer.currentXP > soultidePlayer.targetXP) {
                soultidePlayer.currentXP = Math.abs(soultidePlayer.currentXP - soultidePlayer.targetXP);
                soultidePlayer.targetXP = (soultidePlayer.targetXP * 2);
                soultidePlayer.level += 1;
                player.sendMessage(ChatColor.GOLD + "Level up! You are now level: " + soultidePlayer.level);
            }
            if(soultidePlayer.currentXP == 0) {
                soultidePlayer.currentXP = 1;
            }
            float decimal = ((float)soultidePlayer.currentXP / (float)soultidePlayer.targetXP);
            player.sendMessage(ChatColor.GOLD + "XP:" + soultidePlayer.currentXP + "   TXP:" + soultidePlayer.targetXP +    "   LVL:" + soultidePlayer.level    +  "    DEC:" + decimal );
            updateXPBar(player);
        }

    }


}
