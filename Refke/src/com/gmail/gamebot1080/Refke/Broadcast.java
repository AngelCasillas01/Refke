package com.gmail.gamebot1080.Refke;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Broadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length > 0){
            String  broadcast = "";
            for(String message : args){
                broadcast = (broadcast + message + " ");
            }
            Bukkit.broadcastMessage(ChatColor.RED + "[Broadcast]" + " " + broadcast);
        }
        return true;
    }
    
}
