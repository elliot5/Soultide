package net.Solitude.GUIs;

import org.bukkit.entity.Player;

public class GUIManager {
	
	public void openNewGUI(GUI type, Player p){
		p.openInventory(type.constructInventory(p));
		//Put PlayerData into GUI action
	}
}
