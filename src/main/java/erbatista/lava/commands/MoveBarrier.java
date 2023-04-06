package erbatista.lava.commands;

import erbatista.lava.data.Data;
import erbatista.lava.utils.TextUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MoveBarrier implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        List<Player> players = (List<Player>) Bukkit.getOnlinePlayers().stream().toList();

        for (Player player : players) {
            TextUtils.sendTitleToPlayer(player,"Diminuindo Barreira!");
        }

        Data.getWorld().getWorldBorder().setSize(25,120);
        return true;
    }
}
