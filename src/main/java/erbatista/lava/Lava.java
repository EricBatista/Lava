package erbatista.lava;

import erbatista.lava.bukkittask.WorldBorderT;
import erbatista.lava.commands.*;
import erbatista.lava.data.Data;
import erbatista.lava.events.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public final class Lava extends JavaPlugin {



    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();

        saveDefaultConfig();

        Data.setPlugin(this);
        Data.setTimeToRaise(getConfig().getInt("TimeToRaise"));
        Data.setY(getConfig().getDouble("MinYCoords"));
        Data.setMaxY(getConfig().getDouble("MaxYCoords"));
        Data.setCenterX(getConfig().getDouble("CenterX"));
        Data.setCenterZ(getConfig().getDouble("CenterZ"));
        Data.setRadius(getConfig().getDouble("Radius"));
        Data.setTimeToStart(getConfig().getInt("TimeToStart"));
        Data.setShouldBan(getConfig().getBoolean("ShouldBan"));

        getCommand("startlava").setExecutor(new LavaRiseCommand());
        getCommand("setlavaspeed").setExecutor(new SetLavaSpeed());
        getCommand("pauselava").setExecutor(new PauseLava());
        getCommand("forcelava").setExecutor(new ForceLavaStart());
        getCommand("closebarrier").setExecutor(new MoveBarrier());

        Bukkit.getPluginManager().registerEvents(new BlockPlace(), this);
        Bukkit.getPluginManager().registerEvents(new DeathEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerLeave(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerTick(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreak(),this);
        Bukkit.getPluginManager().registerEvents(new Damage(),this);
        Bukkit.getPluginManager().registerEvents(new WorldLoad(),this);
        Bukkit.getPluginManager().registerEvents(new WorldUnload(),this);

        BukkitTask taskWorldBorder = new WorldBorderT(
                getConfig().getString("WorldName"))
                .runTaskLater(this, getConfig().getLong("TimeToStartBorder"));

        new BukkitRunnable() {
            int timer = 0;

            @Override
            public void run() {
                Data.getTasks().forEach(task -> task.run(timer));
                timer += 1;
                if (timer > 1000) timer = 0;
            }
        }.runTaskTimer(this, 0, 1);
    }

    //TODO: Salvar nas configs os valores alterados
    @Override
    public void onDisable() {

    }
}
