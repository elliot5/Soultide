package net.Solitude.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class AdminGUI implements GUI {

	public String name() {
		return "AdminGUI";
	}
	

	public int size() {
		return 9;
	}
	
	public Inventory constructInventory(Player p) {
		Inventory i = Bukkit.createInventory(p, size());
		return i;
	}
	
	
}
