package erbatista.lava.events;

import erbatista.lava.data.Data;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;

public class WorldLoad implements Listener {
    @EventHandler
    public void onWeather(WorldLoadEvent event) {
        event.getWorld().setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        event.getWorld().setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        event.getWorld().setGameRule(GameRule.DO_INSOMNIA, false);
        event.getWorld().setGameRule(GameRule.DO_VINES_SPREAD, false);
        event.getWorld().setGameRule(GameRule.MAX_ENTITY_CRAMMING, 0);
        event.getWorld().setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);
    }
}
