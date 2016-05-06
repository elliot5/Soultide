package net.Soultide.GUIs;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface GUI {

	public String name();
	public int size();
	
	public Inventory constructInventory(Player p);
	
}
