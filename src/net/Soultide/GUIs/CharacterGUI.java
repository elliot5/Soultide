package net.Soultide.GUIs;

import java.util.ArrayList;

import net.Soultide.PlayerData.DataManager;
import net.Soultide.PlayerData.PlayerData;
import net.Soultide.PlayerData.CharacterData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CharacterGUI implements GUI {

	public String name() {
		return "Character GUI";
	}

	public int size() {
		return 9;
	}

	public Inventory constructInventory(Player p) {
		Inventory i = Bukkit.createInventory(p, size(), name());
		PlayerData pd = DataManager.getPlayerData(p);
		for(int it = 0; it == 5; it++){
			i.addItem(createItemStack(pd.getCharacterData(it)));
		}
		return null;
	}

	public void handleAction(Player p, ItemStack i, ClickType click) {
		//Make sure to save PlayerData and load CharacterData when they select a character
	}
	
	public ItemStack createItemStack(CharacterData cd){
		if(cd == null){
			ItemStack item = new ItemStack(Material.PAPER);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("Empty Character Slot");
			ArrayList<String> lore = new ArrayList<String>(2);
			lore.add(ChatColor.GRAY + "Click here to create a new Character!");
			meta.setLore(lore);
			item.setItemMeta(meta);
			return item;
		}
		ItemStack item = new ItemStack(Material.APPLE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("character");
		ArrayList<String> lore = new ArrayList<String>(2);
		lore.add(ChatColor.GRAY + "Character Stats go here");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

}
