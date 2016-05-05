package net.soultide.stcore.handlers;

import net.soultide.stcore.Main;
import net.soultide.stcore.PlayerConfig;
import net.soultide.stcore.gui.CharacterSelection;
import net.soultide.stcore.leveling.ExperienceManager;
import net.soultide.stcore.player.SoultidePlayer;
import net.soultide.stcore.player.SoultidePlayerManager;
import net.soultide.stcore.weapon.WeaponList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoined implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerJoin(PlayerLoginEvent event) {

        //Items
        ItemStack nexus = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta data = nexus.getItemMeta();
        data.setDisplayName(ChatColor.BLUE + "Nexus");
        nexus.setItemMeta(data);

        //Getting Player
        Player player = event.getPlayer();

        //Config Creation
        PlayerConfig config = new PlayerConfig(player.getUniqueId());
        config.CreateUser();

        //Permission
        if (player.hasPermission("lostsouls.admin")) {
            player.setDisplayName(ChatColor.RED + player.getDisplayName() + ChatColor.WHITE);
            player.setPlayerListName(ChatColor.RED + player.getDisplayName());
            player.setCustomNameVisible(true);
        } else {
            player.setDisplayName(ChatColor.WHITE + player.getDisplayName() + ChatColor.WHITE);
            player.setPlayerListName(ChatColor.WHITE + player.getDisplayName());
            player.setCustomNameVisible(true);
        }

        //GUI
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
            @Override
            public void run() {

                //Player creation
                if(SoultidePlayerManager.getSoultidePlayer(player.getPlayer()) == null) {
                    SoultidePlayer soultidePlayer = new SoultidePlayer(player);
                    SoultidePlayerManager.addPlayer(soultidePlayer);
                } else {
                    player.kickPlayer("Already logged in");
                    return;
                }

                SoultidePlayer stplayer = SoultidePlayerManager.getSoultidePlayer(player);
                if(stplayer != null) { stplayer.loadData();
                    ExperienceManager.updateXPBar(player); }

                player.getInventory().setItem(0, nexus);
                player.getInventory().setItem(1, WeaponList.bunnySword.sword);
                CharacterSelection.OpenCharacterSelectionMenu(player);
            }
        }, 10L);


    }

}

