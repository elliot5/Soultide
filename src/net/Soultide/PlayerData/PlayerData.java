package net.Soultide.PlayerData;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class PlayerData {

	private UUID id;
	private int level;
	private int EXP;
	private int totalMana;
	private BossBar healthBar;
	private BossBar manaBar;
	private BossBar experienceBar;
	
	public PlayerData(Player p){
		this.id = p.getUniqueId();
		this.level = 1;
		this.EXP = 0;
		this.totalMana = 10;

		this.healthBar = Bukkit.createBossBar(ChatColor.RED + "Health", BarColor.RED, BarStyle.SOLID);
		this.manaBar = Bukkit.createBossBar(ChatColor.AQUA + "Mana", BarColor.BLUE, BarStyle.SOLID);
		this.experienceBar = Bukkit.createBossBar(ChatColor.GREEN + "Experience", BarColor.GREEN, BarStyle.SEGMENTED_20);
		this.healthBar.addPlayer(p);
		this.healthBar.setProgress(0);
		this.healthBar.setVisible(true);
		this.manaBar.addPlayer(p);
		this.manaBar.setProgress(0);
		this.manaBar.setVisible(true);
		this.experienceBar.setProgress(0);
		this.manaBar.setVisible(true);
	}
	
	public UUID getID(){
		return this.id;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public void incrementLevel(){
		level++;
	}
	
	public int getEXP(){
		return this.EXP;
	}
	
	public void addEXP(int add){
		this.EXP = this.EXP + add;
	}
}
