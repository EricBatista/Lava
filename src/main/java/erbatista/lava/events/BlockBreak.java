package erbatista.lava.events;

import erbatista.lava.data.Data;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    @EventHandler
    public void blockBreak(BlockBreakEvent event){
        if(!Data.isIsLavaRising()){
            event.getPlayer().sendActionBar(Component.text("Espere o evento começar!"));
            event.setCancelled(true);
        }
    }
}
