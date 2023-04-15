package erbatista.lava.tasks;

import com.fastasyncworldedit.core.Fawe;
import com.fastasyncworldedit.core.FaweAPI;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;;
import com.sk89q.worldedit.function.pattern.RandomPattern;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldedit.world.block.BlockState;
import erbatista.lava.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Set;
import java.util.logging.Level;

public class LavaRise implements Task {

    private final World world = BukkitAdapter.adapt(Bukkit.getWorld("world"));

    private double x1;
    private double x2;
    private double z1;
    private double z2;

    public LavaRise(double x1, double x2, double z1,double z2){
        this.x1 = x1;
        this.x2 = x2;
        this.z1 = z1;
        this.z2 = z2;
    }

    @Override
    public void run(int i) {
        if(i % Data.getTimeToRaise() == 0 && Data.isIsLavaRising()){
            if(Data.limit()) return;


            Region selection = new CuboidRegion(world, BlockVector3.at(x1, Data.getY(), z1), BlockVector3.at(x2, Data.getY(), z2)); // make a selection with two points

            Bukkit.getLogger().log(Level.INFO,"Subindo Lava: " + Data.getY());



            try{

                RandomPattern pat = new RandomPattern();

                BlockState stone = BukkitAdapter.adapt(Material.LAVA.createBlockData());

                pat.add(stone, 1);;

                int blocksAffected = FaweAPI.getWorld(world.getName()).replaceBlocks(selection,
                        Set.of(
                                BukkitAdapter.adapt(Material.WATER.createBlockData()).toBaseBlock(),
                                BukkitAdapter.adapt(Material.AIR.createBlockData()).toBaseBlock(),
                                BukkitAdapter.adapt(Material.FIRE.createBlockData()).toBaseBlock(),
                                BukkitAdapter.adapt(Material.SNOW.createBlockData()).toBaseBlock()
                        )
                        , pat);

                Bukkit.getLogger().log(Level.INFO,"Blocks Affected: " + blocksAffected);

            } catch (MaxChangedBlocksException ex) {
                ex.printStackTrace();
            }


            if(Data.isIsLavaRising()) {
                try {
                    Data.getBossBar().progress((float)(Data.getY()+64)/310);
                }
                catch (Exception e){
                    Bukkit.getLogger().log(Level.INFO,e.toString());
                }
                Data.addY();
            }
        }
    }
}
