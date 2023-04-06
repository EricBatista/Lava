package erbatista.lava.events;

import com.destroystokyo.paper.event.server.ServerTickStartEvent;

import erbatista.lava.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

public class PlayerTick implements Listener {

    @EventHandler
    public void playerTick(ServerTickStartEvent event){
        List<Player> players = (List<Player>) Bukkit.getOnlinePlayers().stream().toList();
        for (int i = 0; i< players.size(); i++) {
            Player p = players.get(i);
            if(p.getGameMode() == GameMode.SURVIVAL){
                if(p.getLocation().getY() < Data.getY()) p.damage(1);
            }
        }
    }
}
