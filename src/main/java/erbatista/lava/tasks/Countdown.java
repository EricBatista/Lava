package erbatista.lava.tasks;

import erbatista.lava.data.Data;
import erbatista.lava.utils.TextUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

public class Countdown extends BukkitRunnable {
    private int num;

    public Countdown(int num){
        this.num = num;
    }


    @Override
    public void run() {
        List<Player> players = (List<Player>) Bukkit.getOnlinePlayers().stream().toList();
        if(num <= 3){
            for (Player player : players) {
                TextUtils.sendTitleToPlayer(player,String.valueOf(num));
            }
        }
        if(num > 0){
            BukkitTask task = new Countdown(num-1).runTaskLater(Data.getPlugin(),20);
        }
        else{
            for (Player player : players) {
                TextUtils.sendTitleToPlayer(player,"Sobreviva a Lava!");            }
            Data.getBossBar().name(Component.text("Nível da Lava").style(Style.style().color(TextColor.color(252, 132, 3)).build()));
            Data.getWorld().setDifficulty(Difficulty.EASY);
            BukkitTask task = new LavaRise().runTaskLater(Data.getPlugin(), Data.getTimeToRaise());
            BukkitTask verifyWinners = new VerifyWinners().runTaskLater(Data.getPlugin(),Data.getTimeToRaise());

        }
    }
}
