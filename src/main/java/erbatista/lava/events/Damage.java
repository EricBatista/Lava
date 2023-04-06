package erbatista.lava.events;

import erbatista.lava.data.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {
    @EventHandler
    public void playerDamage(EntityDamageEvent event){
        if(!Data.isIsLavaRising()){
            event.setCancelled(true);
        }
    }
}
