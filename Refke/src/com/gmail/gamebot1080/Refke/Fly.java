package com.gmail.gamebot1080.Refke;
 
import java.util.logging.Logger;
 
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Fly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
  	if(!(sender instanceof Player))
	 	{
			System.out.println("Console can't run this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(!(p.hasPermission("permission.fly")))
		{
			p.sendMessage(ChatColor.RED + "You don't have permission to use this command");
			return true;
		}
		
		if(p.getAllowFlight())
		{
			p.setAllowFlight(false);
			p.setFlying(false);
			
			p.sendMessage(ChatColor.YELLOW + "You can no longer fly!");
		}
		else
		{
			p.setAllowFlight(true);
			p.sendMessage(ChatColor.YELLOW + "You can now fly!");
		}
		return true;
	}

}
