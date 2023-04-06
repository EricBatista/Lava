package erbatista.lava.commands;

import erbatista.lava.data.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class SetLavaSpeed implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        try{
            long l = Long.parseLong(args[0]);
            Data.setTimeToRaise(l);
            sender.sendMessage("Configurando velocidade da Lava para "+l);
        }
        catch (Exception e){
            sender.sendMessage("Erro ao executar o comando");
            return false;
        }

        return true;
    }
}
