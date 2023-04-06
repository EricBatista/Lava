package erbatista.lava.events;

import erbatista.lava.data.Data;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if(!Data.isIsLavaRising()){
            event.getPlayer().sendActionBar(Component.text("Espere o evento começar!"));
            event.setCancelled(true);
        }
        if(event.getBlock().getY() > Data.getMaxY()-2){
            event.getPlayer().sendActionBar(Component.text("Você chegou ao limite de construção!"));
            event.setCancelled(true);
        }
    }
}
