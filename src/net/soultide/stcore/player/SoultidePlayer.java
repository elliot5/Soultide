package net.soultide.stcore.player;

import net.soultide.stcore.PlayerConfig;
import net.soultide.stcore.gui.CharacterInformationPanel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class SoultidePlayer {


    public CharacterInformationPanel panel;

    public BossBar experienceBar;
    public BossBar manaBar;
    public BossBar healthBar;

    public Player player;

    public int level;
    public int targetXP;
    public int currentXP;

    public SoultidePlayer(Player nplayer) {
        this.player = nplayer;

        experienceBar = Bukkit.createBossBar(ChatColor.GREEN + "Experience", BarColor.GREEN, BarStyle.SEGMENTED_20);
        experienceBar.addPlayer(nplayer);
        experienceBar.setProgress(0);
        experienceBar.setVisible(true);
        manaBar = Bukkit.createBossBar(ChatColor.AQUA + "Mana", BarColor.BLUE, BarStyle.SOLID);
        manaBar.addPlayer(nplayer);
        manaBar.setProgress(0);
        manaBar.setVisible(true);
        healthBar = Bukkit.createBossBar(ChatColor.RED + "Health", BarColor.RED, BarStyle.SOLID);
        healthBar.addPlayer(nplayer);
        healthBar.setProgress(0);
        healthBar.setVisible(true);
    }

    public void saveData() {
        PlayerConfig config = new PlayerConfig(player.getUniqueId());

        if(config.getUserFile() == null) { return; }

        config.getUserFile().set("char" + config.getUserFile().getInt("selectedChar") + ".location.x", player.getLocation().getX());
        config.getUserFile().set("char" + config.getUserFile().getInt("selectedChar") + ".location.y", player.getLocation().getY());
        config.getUserFile().set("char" + config.getUserFile().getInt("selectedChar") + ".location.z", player.getLocation().getZ());

        config.getUserFile().set("char" + config.getUserFile().getInt("selectedChar") + ".level", level);
        config.getUserFile().set("char" + config.getUserFile().getInt("selectedChar") + ".targetXP", targetXP);
        config.getUserFile().set("char" + config.getUserFile().getInt("selectedChar") + ".currentXP", currentXP);

        config.saveUserFile();
    }

    public void loadData() {
        PlayerConfig config = new PlayerConfig(player.getUniqueId());

        level = config.getUserFile().getInt("char" + config.getUserFile().getInt("selectedChar") + ".level");
        targetXP = config.getUserFile().getInt("char" + config.getUserFile().getInt("selectedChar") + ".targetXP");
        currentXP = config.getUserFile().getInt("char" + config.getUserFile().getInt("selectedChar") + ".currentXP");

    }



}
