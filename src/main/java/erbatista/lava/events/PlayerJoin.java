package erbatista.lava.events;

import erbatista.lava.data.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent event){
        event.getPlayer().showBossBar(Data.getBossBar());
    }
}
