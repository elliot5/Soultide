package net.soultide.stcore.gui;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class CharacterInformationPanel {
    Scoreboard scoreBoard;

    public void update() {
    }

    public void init(Player player) {
        player.setScoreboard(scoreBoard);
    }
}
