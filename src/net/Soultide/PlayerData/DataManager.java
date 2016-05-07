package net.Soultide.PlayerData;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class DataManager {

	private static HashMap<UUID, PlayerData> PlayerDataList = new HashMap<UUID, PlayerData>();
	private static HashMap<UUID, CharacterData> CharacterDataList = new HashMap<UUID, CharacterData>();
	
	public void loadPlayerData(UUID id){
		//Load from SQL database
	}
	
	public void savePlayerData(UUID id){
		//Save to SQL database
	}
	
	public static PlayerData getPlayerData(Player p){
		if(PlayerDataList.containsKey(p.getUniqueId())) return PlayerDataList.get(p.getUniqueId());
		
		//In the event of first login or no playerdata
		PlayerData newData = new PlayerData(p);
		PlayerDataList.put(p.getUniqueId(), newData);
		return newData;
	}
	
	public static CharacterData getCharacterData(Player p){
		if(CharacterDataList.containsKey(p.getUniqueId())) return CharacterDataList.get(p.getUniqueId());
		
		//In the event of first character choice
		CharacterData newData = new CharacterData(p);
		CharacterDataList.put(p.getUniqueId(), newData);
		return newData;
	}
}
