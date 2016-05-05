package net.soultide.stcore.handlers;

import net.soultide.stcore.leveling.ExperienceManager;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathHandler implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if(event.getEntity() instanceof Monster) {
            Monster monsterEnt = (Monster) event.getEntity();
            ExperienceManager.addExp(monsterEnt.getKiller(), 10);
        }
    }
}
