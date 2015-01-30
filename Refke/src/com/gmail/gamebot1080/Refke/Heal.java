package com.gmail.gamebot1080.Refke;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            
            if (!(sender instanceof Player)) {
                sender.sendMessage("Console can't run this command!");
                return true;
        }
            
            Player player = (Player) sender;
            
            if (cmd.getName().equalsIgnoreCase("heal")) {
                if (args.length == 0) {
                    player.setHealth(20);
                    player.setFireTicks(0);
                    player.setFoodLevel(20);
                    player.sendMessage(ChatColor.YELLOW + "Healed!");
                    return true;
                }
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "No players matched query.");
                    return true;
                }
                target.setHealth(20);
                target.setFoodLevel(20);
                target.setFireTicks(0);
                target.sendMessage(ChatColor.YELLOW + "Healed by" + player.getName());
           }
        return true;
      }
 }
