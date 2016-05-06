package net.soultide.stcore;

import net.soultide.stcore.gui.CharacterSelection;
import net.soultide.stcore.handlers.*;
import net.soultide.stcore.player.SoultidePlayer;
import net.soultide.stcore.player.SoultidePlayerManager;
import net.soultide.stcore.weapon.Sword;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    public static Main plugin;

    public Main() {
        plugin = this;
    }

    Logger logger;

    @Override
    public void onEnable(){
        logger = getLogger();
        logger.log(Level.INFO, "Soultide Enabled");
        addListeners();
        CharacterSelection.Init();
    }

    public void addListeners() {

    }

    @Override
    public void onDisable(){
        logger.log(Level.INFO, "Soultide Disabled");
    }




}