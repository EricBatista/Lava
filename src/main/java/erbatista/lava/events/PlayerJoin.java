package erbatista.lava.events;

import erbatista.lava.data.Data;
import org.bukkit.block.data.FaceAttachable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent event){
        event.getPlayer().showBossBar(Data.getBossBar());
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,PotionEffect.INFINITE_DURATION,0, false,false));
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,PotionEffect.INFINITE_DURATION,0, false,false));
    }
}
