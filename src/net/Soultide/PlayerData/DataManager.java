package net.Soultide.PlayerData;

import java.util.HashMap;
import java.util.UUID;

public class DataManager {

	private static HashMap<UUID, PlayerData> DataList = new HashMap<UUID, PlayerData>();
	
	public void loadPlayerData(UUID id){
		//Load from SQL database
	}
	
	public void savePlayerData(UUID id){
		//Save to SQL database
	}
	
	public PlayerData getPlayerData(UUID id){
		if(DataList.containsKey(id)) return DataList.get(id);
		
		//In the event of first login or no playerdata
		PlayerData newData = new PlayerData(id);
		DataList.put(id, newData);
		return newData;
	}
}
