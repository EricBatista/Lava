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
            int i = Integer.parseInt(args[0]);
            Data.setTimeToRaise(i);
            sender.sendMessage("Configurando velocidade da Lava para "+i);
        }
        catch (Exception e){
            sender.sendMessage("Erro ao executar o comando");
            return false;
        }

        return true;
    }
}
