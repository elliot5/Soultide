package net.Soultide.GUIs;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface GUI {

	public String name();
	public int size();
	
	public Inventory constructInventory(Player p);
	
	public void handleAction(Player p, ItemStack i, ClickType click);
	
	public static ArrayList<GUI> list = new ArrayList<GUI>();
	
}
