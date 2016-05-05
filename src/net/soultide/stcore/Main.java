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
        getServer().getPluginManager().registerEvents(new PlayerJoined(), this);
        getServer().getPluginManager().registerEvents(new BuildHandler(), this);
        getServer().getPluginManager().registerEvents(new InventoryHandler(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageHandler(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeft(), this);
        getServer().getPluginManager().registerEvents(new EntityDeathHandler(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getLabel().equalsIgnoreCase("createsword")) {
            if(args.length == 3) {
                if (args[1].matches("^-?\\d+$")) {
                    Sword sword = new Sword(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                    Player p = (Player) sender;
                    p.getInventory().addItem(sword.sword);
                    sender.sendMessage("Creating a new sword.");
                    return true;
                } else {
                    sender.sendMessage("You must enter the command like so: /createsword [name] [min-damage] [max-damage] damage is an integer.");
                    return true;
                }
            } else {
                sender.sendMessage("You must enter the command like so: /createsword [name] [min-damage] [max-damage] damage is an integer.");
                return true;
            }
        } else {
            sender.sendMessage("Unknown command");
        }
        return false;
    }

    @Override
    public void onDisable(){
        logger.log(Level.INFO, "Soultide Disabled");
    }




}