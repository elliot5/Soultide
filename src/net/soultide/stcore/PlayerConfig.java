package net.soultide.stcore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.UUID;

public class PlayerConfig {
    UUID u;
    File userFile;
    FileConfiguration userConfig;

    public PlayerConfig(UUID u) {
        this.u = u;
        userFile = new File("plugins/SoultideCore/data/" + u + ".yml");
        userConfig = YamlConfiguration.loadConfiguration(userFile);
    }

    public void CreateUser(){

        if ( !(userFile.exists()) ) {
            try {

                Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[SoultideData] Created a new File for " + u);

                userConfig = YamlConfiguration.loadConfiguration(userFile);
                userConfig.addDefault("chars", 0);
                userConfig.set("chars", 0);
                userConfig.addDefault("selectedChar", 0);
                userConfig.set("selectedChar", 0);
                userConfig.save(userFile);

            } catch (Exception e) {

                e.printStackTrace();

            }
        }

    }

    public FileConfiguration getUserFile(){
        return userConfig;
    }

    public void saveUserFile(){
        try {

            getUserFile().save(userFile);

        } catch(Exception e) {

            e.printStackTrace();

        }

    }



}