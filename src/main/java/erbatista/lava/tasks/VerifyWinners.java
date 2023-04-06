package erbatista.lava.tasks;

import erbatista.lava.data.Data;
import erbatista.lava.utils.EntityUtils;
import erbatista.lava.utils.TextUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.LinkedList;
import java.util.List;

public class VerifyWinners extends BukkitRunnable {
    @Override
    public void run() {
        List<Player> survivalPlayers = new LinkedList<>();
        List<Player> players = Data.getWorld().getPlayers();
        for (Player player : players) {
            if (survivalPlayers.size() > 1) {
                BukkitTask task = new VerifyWinners().runTaskLater(Data.getPlugin(), Data.getTimeToRaise());
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
