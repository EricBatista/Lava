package erbatista.lava.tasks;

import erbatista.lava.data.Data;
import erbatista.lava.utils.TextUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Difficulty;
import org.bukkit.entity.Player;

import java.util.List;

    public class Countdown implements Task {
    private int num;

    public Countdown(int num){
        this.num = num;
    }


    @Override
    public void run(int i) {
        if(i % 20 == 0) {
            List<Player> players = Data.getWorld().getPlayers();
            if(num <= 3){
                for (Player player : players) {
                    TextUtils.sendTitleToPlayer(player,String.valueOf(num));
                }
            }
            if(num > 0){
                num--;
            }
            else{
                for (Player player : players) {
                    TextUtils.sendTitleToPlayer(player,"Sobreviva a Lava!");            }
                Data.getBossBar().name(Component.text("Nível da Lava").style(Style.style().color(TextColor.color(252, 132, 3)).build()));
                Data.getWorld().setDifficulty(Difficulty.EASY);
                Data.setIsLavaRising(true);
                Data.getTasks().remove(0);
                Data.addTask(new LavaRise(
                        Data.getCenterX() + Data.getRadius()/2,
                        Data.getCenterX() - Data.getRadius()/2,
                        Data.getCenterZ() + Data.getRadius()/2,
                        Data.getCenterZ() - Data.getRadius()/2
                ));
            }
        }
    }
}
