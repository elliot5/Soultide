package net.Soultide.PlayerData;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

public class PlayerData {

	private UUID id;
	private ArrayList<CharacterData> characterDataList;
	
	public PlayerData(Player p){
		this.id = p.getUniqueId();
		this.characterDataList = new ArrayList<CharacterData>(5);
	}
	
	public UUID getUUID(){
		return this.id;
	}
	
	public CharacterData getCharacterData(int slotNumber){
		return this.characterDataList.get(slotNumber);
	}
}
