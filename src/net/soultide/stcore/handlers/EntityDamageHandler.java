package net.soultide.stcore.handlers;

import net.soultide.stcore.weapon.WeaponList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Random;

public class EntityDamageHandler implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event){

        if(event.getEntity() instanceof Zombie || event.getEntity() instanceof Player){
            if(event.getDamager() instanceof Player) {
                Player p = (Player) event.getDamager();
                if(p.getInventory().getItemInMainHand().getType() != Material.IRON_SWORD) { return; }
                if(p.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).startsWith(ChatColor.RED + "Damage:")) {
                    String s = p.getInventory().getItemInMainHand().getItemMeta().getLore().get(0);
                    String dmg = s.substring(s.lastIndexOf(':') + 2);
                    String[] stats = dmg.split(" - ");
                    p.sendRawMessage("Min:" +stats[0] + "  Max:" + stats[1] );
                    Random r = new Random();
                    int damage = r.nextInt(Integer.parseInt(stats[1]) - Integer.parseInt(stats[0])) + Integer.parseInt(stats[0]);
                    event.setDamage(damage);
                    p.sendRawMessage(ChatColor.GREEN + "You did " + damage + " points damage");
                    p.getInventory().getItemInMainHand().setDurability((short)0);
                }
            }
        }
    }
}
