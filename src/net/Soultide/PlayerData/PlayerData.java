package net.Soultide.PlayerData;

import java.util.UUID;

public class PlayerData {

	private UUID id;
	private int level;
	private int EXP;
	private int totalMana;
	
	public PlayerData(UUID id){
		this.id = id;
		this.level = 1;
		this.EXP = 0;
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
