package net.soultide.stcore.gui;

import net.soultide.stcore.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CharacterSelection {

    public static Inventory characterSelectionInventory;

    static ItemStack filledSlot;
    static  ItemStack newSlot;
    static ItemStack emptySlot;

    public static ItemStack GenerateFilledSlot(int number) {
        filledSlot = new ItemStack(Material.IRON_HOE, 1);
        ItemMeta filledSlotMeta = filledSlot.getItemMeta();
        List<String> lore = new ArrayList<String>();
        filledSlotMeta.setDisplayName("Filled character slot");
        lore.add("" + number);
        filledSlotMeta.setLore(lore);
        filledSlot.setItemMeta(filledSlotMeta);
        return filledSlot;
    }

    public static void Init() {
        newSlot = new ItemStack(Material.DIAMOND_HOE, 1);
        ItemMeta newSlotMeta = newSlot.getItemMeta();
        newSlotMeta.setDisplayName("Create a new character");
        newSlot.setItemMeta(newSlotMeta);

        emptySlot = new ItemStack(Material.GOLD_HOE, 1);
        ItemMeta emptySlotMeta = emptySlot.getItemMeta();
        emptySlotMeta.setDisplayName("Empty character slot");
        emptySlot.setItemMeta(emptySlotMeta);

        characterSelectionInventory = Bukkit.createInventory(null, 9, "Select a character slot");

    }

    public static void OpenCharacterSelectionMenu(Player p) {
        PlayerConfig config = new PlayerConfig(p.getUniqueId());

        for(int i = 0; i < 5; i++) {
            if(i == config.getUserFile().getInt("chars")) {
                characterSelectionInventory.setItem(i, newSlot);
            } else if (i < config.getUserFile().getInt("chars")) {
                characterSelectionInventory.setItem(i, GenerateFilledSlot(i+1));
            } else if(i >  config.getUserFile().getInt("chars")) {
                characterSelectionInventory.setItem(i, emptySlot);
            }
        }

        p.openInventory(characterSelectionInventory);
    }
}
