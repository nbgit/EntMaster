package me.pluginmaster.entmaster.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandTrample implements CommandExecutor {
    //use the luckperms api to check if the player has the entmaster.trample permission and if they do, activate the onPlayerTrample listener in the FarmListener class.
    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Player player2 = player;
        if (player.hasPermission("entmaster.canusetrample") || player.isOp()) {

            if (args.length != 0) {
                Player player1 = Bukkit.getPlayer(args[0]);
                player2= player1;
            }


            if (player2.hasPermission("entmaster.trample")) {
                sender.sendMessage("Crop trampling enabled");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player2.getName() + " permission set entmaster.trample false");

            } else {
                sender.sendMessage("Crop trampling disabled");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player2.getName() + " permission set entmaster.trample true");
            }

            return true;
        }
    return true;}
}