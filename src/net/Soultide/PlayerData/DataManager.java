package net.Soultide.PlayerData;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class DataManager {

	private static HashMap<UUID, PlayerData> DataList = new HashMap<UUID, PlayerData>();
	
	public void loadPlayerData(UUID id){
		//Load from SQL database
	}
	
	public void savePlayerData(UUID id){
		//Save to SQL database
	}
	
	public PlayerData getPlayerData(Player p){
		if(DataList.containsKey(p.getUniqueId())) return DataList.get(p.getUniqueId());
		
		//In the event of first login or no playerdata
		PlayerData newData = new PlayerData(p);
		DataList.put(p.getUniqueId(), newData);
		return newData;
	}
}
