package erbatista.lava.commands;

import erbatista.lava.data.Data;
import erbatista.lava.tasks.Countdown;
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
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.logging.Level;

public class ForceLavaStart implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (label.equalsIgnoreCase("forcelava") && !Data.isIsLavaRising()){

            Bukkit.getLogger().log(Level.INFO,"Forçando subida da lava.");

            Data.setIsLavaRising(true);

            List<Player> players = (List<Player>) Bukkit.getOnlinePlayers().stream().toList();

            for(int i = 0; i<players.size();i++) {
                Player player = players.get(i);
                player.sendTitlePart(TitlePart.TITLE, Component.text("Se prepare!").style(Style.style().color(TextColor.color(252, 132, 3)).build()));
                player.playNote(player.getLocation(), Instrument.PIANO, Note.natural(1, Note.Tone.G));
            }
        }

        return true;

    }
}
