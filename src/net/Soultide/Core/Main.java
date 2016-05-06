package net.Soultide.Core;

import net.Soultide.GUIs.GUIListener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		getLogger().info("Enabling Soultide");
		registerClasses();
		registerListeners();
		registerCommandExecutors();
	}
	
	public void onDisable(){
		getLogger().info("Disabling Soultide");
		for(Player p : Bukkit.getOnlinePlayers()){
			p.kickPlayer("Server Restarting");
		}
	}
	
	private void registerClasses(){
		
	}
	
	private void registerListeners(){
		PluginManager pm = Bukkit.getPluginManager();
		GUIListener guil = new GUIListener(this);
		pm.registerEvents(guil, this);
	}
	
	private void registerCommandExecutors(){
		
	}
	
}
