package net.soultide.stcore.weapon;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Sword {

    public ItemStack sword;
    public int maxdamage;
    public int mindamage;

    public Sword(String name, int maxdamage, int mindamage) {
        sword = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta metaData = sword.getItemMeta();
        metaData.setDisplayName(ChatColor.YELLOW + name);
        metaData.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaData.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> description = new ArrayList<String>();
        description.add(ChatColor.RED + "Damage: " + maxdamage + " - " + mindamage);
        metaData.setLore(description);
        sword.setItemMeta(metaData);
        this.maxdamage = maxdamage;
        this.mindamage = mindamage;
    }

}
