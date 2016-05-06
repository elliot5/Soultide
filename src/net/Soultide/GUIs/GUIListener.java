package net.Soultide.GUIs;

import net.Soultide.Core.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {

	private Main plugin;
	
	public GUIListener(Main pl){
		plugin = pl;
	}
	
	@EventHandler
	public void GUIClickListener(InventoryClickEvent e){
		if(!(e.getWhoClicked() instanceof Player)) return;
		Player p = (Player) e.getWhoClicked();
		
		//Check if in GUI action
		GUI type = null;
		for(GUI gui : GUI.list){
			if(gui.name().equals(e.getClickedInventory().getName())){
				type = gui;
				break;
			}
		}
		if(type == null) return;
		type.handleAction(p, e.getCurrentItem(), e.getClick());
	}
}
