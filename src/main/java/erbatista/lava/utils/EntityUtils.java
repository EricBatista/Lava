package erbatista.lava.utils;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class EntityUtils {
    public static void spawnFirework(Player player) {
        Location loc = player.getLocation();
        Firework f = player.getWorld().spawn(loc, Firework.class);
        FireworkMeta fm = f.getFireworkMeta();
        fm.addEffect(FireworkEffect.builder()
                .flicker(true)
                .trail(true)
                .with(FireworkEffect.Type.BALL_LARGE)
                .withColor(Color.ORANGE).build());
        fm.setPower(1);
        f.setFireworkMeta(fm);
    }
}
