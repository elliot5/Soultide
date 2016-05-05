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
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Objective;

public class InventoryHandler implements Listener {


    boolean selected = false;

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getPlayer();
        if (inventory.getName().equals(CharacterSelection.characterSelectionInventory.getName())) {
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    if(!selected) {
                        CharacterSelection.OpenCharacterSelectionMenu(player);
                    } else {
                        selected = false;
                    }
                }
            }, 2L);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();

        if (inventory == null || clicked == null) {
            return;
        }
        if (inventory.getName().equals(CharacterSelection.characterSelectionInventory.getName())) {
            if (clicked.getType() == Material.DIAMOND_HOE) {
                PlayerConfig config = new PlayerConfig(player.getUniqueId());
                if (config.getUserFile().getInt("chars") >= 5) {
                    player.sendRawMessage(ChatColor.RED + "You can only have 5 characters");
                    event.setCancelled(true);
                    return;
                } else {
                    player.sendRawMessage(ChatColor.GREEN + "Creating new character");
                }

                config.getUserFile().set("chars", config.getUserFile().getInt("chars") + 1);
                config.getUserFile().set("char" + config.getUserFile().getInt("chars") + ".location.x", 5163);
                config.getUserFile().set("char" + config.getUserFile().getInt("chars") + ".location.y", 87);
                config.getUserFile().set("char" + config.getUserFile().getInt("chars") + ".location.z", 1482);
                config.getUserFile().set("char" + config.getUserFile().getInt("chars") + ".targetXP", 100);
                config.getUserFile().set("char" + config.getUserFile().getInt("chars") + ".currentXP", 0);
                config.getUserFile().set("char" + config.getUserFile().getInt("chars") + ".level", 1);

                config.saveUserFile();
                CharacterSelection.OpenCharacterSelectionMenu(player);
                event.setCancelled(true);
            } else if (clicked.getType() == Material.GOLD_HOE) {
                event.setCancelled(true);
            } else if (clicked.getType() == Material.IRON_HOE) {
                SoultidePlayer stplayer = SoultidePlayerManager.getSoultidePlayer(player);
                //if(stplayer != null) { stplayer.saveData(); }

                selected = true;

                PlayerConfig config = new PlayerConfig(player.getUniqueId());
                config.getUserFile().set("selectedChar", Integer.parseInt(clicked.getItemMeta().getLore().get(0)));
                config.saveUserFile();

                int selected = Integer.parseInt(clicked.getItemMeta().getLore().get(0));

                long x = config.getUserFile().getLong("char" + selected + ".location.x");
                long y = config.getUserFile().getLong("char" + selected + ".location.y");
                long z = config.getUserFile().getLong("char" + selected + ".location.z");
                Location loc = new Location(player.getWorld(), (double)x, (double)y, (double)z);
                player.teleport(loc);

                if(stplayer != null) { stplayer.loadData(); }
                ExperienceManager.updateXPBar(player);

                event.setCancelled(true);
            }
        }
        
        if (clicked.getType() == Material.NETHER_STAR) {
            player.sendRawMessage(ChatColor.GREEN + "Opening nexus");
            CharacterSelection.OpenCharacterSelectionMenu(player);
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event)
    {
        Player player = event.getPlayer();
        if(event.getItemDrop().getItemStack().getData().getItemType() == Material.NETHER_STAR)
        {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

    }

}

