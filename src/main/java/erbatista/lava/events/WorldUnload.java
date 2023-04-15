package erbatista.lava.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldUnloadEvent;

public class WorldUnload implements Listener {
    @EventHandler
    public void onUnloadWorld(WorldUnloadEvent e) {
        e.getWorld().getWorldFolder().delete();
    }
}
