package erbatista.lava.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;

import java.util.List;

public class TextUtils {

    public static void sendTitleToPlayer(Player player, String text) {
        player.sendTitlePart(TitlePart.TITLE, Component.text(text).style(Style.style().color(TextColor.color(252, 132, 3)).build()));
        player.playNote(player.getLocation(), Instrument.PIANO, Note.natural(1, Note.Tone.E));
    }
}
