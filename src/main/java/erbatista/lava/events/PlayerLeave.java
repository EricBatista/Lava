package erbatista.lava.events;

import erbatista.lava.data.Data;
import erbatista.lava.utils.VerifyUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {
    @EventHandler
    public void PlayerLeave(PlayerQuitEvent event){
        event.getPlayer().hideBossBar(Data.getBossBar());
        if(Data.isIsLavaRising()){
            VerifyUtils.verifyWinners();
        }
    }
}
