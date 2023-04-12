package erbatista.lava.events;

import erbatista.lava.data.Data;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player player = event.getPlayer();
        if(player.hasPermission("lava.adm")){
            player.showTitle(Title.title(Component.text("Você Morreu!"),Component.text("")));
            player.setGameMode(GameMode.SPECTATOR);
        }
        else{
            if(Data.isShouldBan()){
                player.banPlayerFull("Você Morreu!");
            }
            else{
                player.showTitle(Title.title(Component.text("Você Morreu!"),Component.text("")));
                player.setGameMode(GameMode.SPECTATOR);
            }

        }
    }

}
