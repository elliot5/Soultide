package net.Soultide.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminGUI implements GUI {

	public String name() {
		return "AdminGUI";
	}
	

	public int size() {
		return 9;
	}
	
	public Inventory constructInventory(Player p) {
		Inventory i = Bukkit.createInventory(p, size());
		
		ItemStack max = new ItemStack(Material.BOOK);
		ItemMeta maxmeta = max.getItemMeta();
		maxmeta.setDisplayName(ChatColor.GOLD + "Set Max Level");
		max.setItemMeta(maxmeta);
		
		i.addItem(max);
		return i;
	}

	public void handleAction(Player p, ItemStack i, ClickType click) {
		
	}
	
}
