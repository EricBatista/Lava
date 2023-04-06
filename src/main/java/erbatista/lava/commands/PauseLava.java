package erbatista.lava.commands;

import erbatista.lava.data.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class PauseLava implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        try{
            Data.setIsLavaRising(false);
            sender.sendMessage("Parando a subida da Lava");
        }
        catch (Exception e){
            sender.sendMessage("Erro ao executar o comando");
            return false;
        }

        return true;
    }
}
