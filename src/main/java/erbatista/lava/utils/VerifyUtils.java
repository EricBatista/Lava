package erbatista.lava.utils;

import erbatista.lava.data.Data;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.LinkedList;
import java.util.List;

public class VerifyUtils {
    public static void verifyWinners(){
        List<Player> survivalPlayers = new LinkedList<>();
        List<Player> players = Data.getWorld().getPlayers();
        for (Player player : players) {
            if (survivalPlayers.size() > 1) {
                return;
            }
            if (player.getGameMode().equals(GameMode.SURVIVAL)) {
                survivalPlayers.add(player);
            }
        }

        Data.setIsLavaRising(false);

        if(survivalPlayers.isEmpty()){
            for (Player player : players) {
                TextUtils.sendTitleToPlayer(player,"Empate!");
                EntityUtils.spawnFirework(player);
            }
        }
        else{
            for (Player player : players) {
                TextUtils.sendTitleToPlayer(player,"Vencedor: " + survivalPlayers.get(0).getName());
                EntityUtils.spawnFirework(player);
            }
        }

    }
}
