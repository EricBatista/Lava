package erbatista.lava.data;

import erbatista.lava.Lava;

import erbatista.lava.tasks.Task;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static final List<Task> tasks = new ArrayList<>();
    private static World world = Bukkit.getWorld("world");
    private static boolean shouldBan = true;
    private static boolean isLavaRising = false;
    private static double y = 0;
    private static double maxY = 202;
    private static JavaPlugin plugin = JavaPlugin.getPlugin(Lava.class);
    private static int timeToRaise = 40;
    private static int timeToStart = 180;
    private static double centerX = 0.0;
    private static double centerZ = 0.0;
    private static double radius = 200.0;
    private static BossBar bossBar = BossBar.bossBar(
            Component.text("Sejam bem-vindos a §bFesta dos Inscritos!"),
            1f,
            BossBar.Color.YELLOW,
            BossBar.Overlay.PROGRESS);

    public static World getWorld() {
        return world;
    }

    public static void setWorld(World world) {
        Data.world = world;
    }

    public static boolean isIsLavaRising() {
        return isLavaRising;
    }

    public static void setIsLavaRising(boolean isLavaRising) {
        Data.isLavaRising = isLavaRising;
    }

    public static BossBar getBossBar() {
        return bossBar;
    }

    public static void setBossBar(BossBar bossBar) {
        Data.bossBar = bossBar;
    }

    public static double getRadius() {
        return radius;
    }

    public static void setRadius(double radius) {
        Data.radius = radius;
    }

    public static double getCenterX() {
        return centerX;
    }

    public static void setCenterX(double centerX) {
        Data.centerX = centerX;
    }

    public static double getCenterZ() {
        return centerZ;
    }

    public static void setCenterZ(double centerZ) {
        Data.centerZ = centerZ;
    }

    public static int getTimeToRaise() {
        return timeToRaise;
    }

    public static void setTimeToRaise(int timeToRaise) {
        Data.timeToRaise = timeToRaise;
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(JavaPlugin plugin) {
        Data.plugin = plugin;
    }

    public static double getY() {
        return y;
    }

    public static void setY(double y) {
        Data.y = y;
    }

    public static void addY(){
        Data.y = Data.y<=maxY ? Data.y + 1 : maxY;
    }

    public static boolean limit(){
        return Data.y >= Data.maxY;
    }

    public static double getMaxY() {
        return maxY;
    }

    public static void setMaxY(double maxY) {
        Data.maxY = maxY;
    }

    public static int getTimeToStart() {
        return timeToStart;
    }

    public static void setTimeToStart(int timeToStart) {
        Data.timeToStart = timeToStart;
    }

    public static boolean isShouldBan() {
        return shouldBan;
    }

    public static void setShouldBan(boolean shouldBan) {
        Data.shouldBan = shouldBan;
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void addTask(Task task){
        tasks.add(task);
    }
}
