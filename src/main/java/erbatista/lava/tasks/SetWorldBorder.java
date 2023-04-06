package erbatista.lava.tasks;

import erbatista.lava.data.Data;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public class SetWorldBorder extends BukkitRunnable {

    private String worldName = "world";

    public SetWorldBorder(String worldName) {
        this.worldName = worldName;
    }

    @Override
    public void run() {
        World world = Bukkit.getServer().getWorld(worldName);
        if(world == null){
            Bukkit.getLogger().log(new LogRecord(Level.INFO,"ERRO AO LOCALIZAR O MUNDO."));
            return;
        }
        world.getWorldBorder().setCenter(Data.getCenterX(),Data.getCenterZ());
        world.getWorldBorder().setSize(Data.getRadius());
        world.getWorldBorder().setDamageAmount(200.0);
        Data.getPlugin().getServer().broadcast(Component.text("BORDA GERADA."));

        world.showBossBar(Data.getBossBar());

        world.setDifficulty(Difficulty.PEACEFUL);


    }
}
