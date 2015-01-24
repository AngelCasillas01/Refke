package com.gmail.gamebot1080.Refke;
 
import java.util.logging.Logger;
 
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Refke extends JavaPlugin {

    public static ArrayList<String> mplayers = new ArrayList<>();

        private Logger logger = Logger.getLogger("Minecraft");
    public void sendConsole(String Message){
        this.logger.info("[Refke]" + Message);      
       
    }
    public void onEnable() {

      Bukkit.getServer().registerEvents(this, this);
       
    }
    public void onDisable() {
       
    }

    @EventHandler
    public void onChat(PlayerChatEvent e){
      Player p = e.getPlayer();

      if(mplayers.contains(p.getName)){
         e.setCancelled(true)
         
         p.sendMessage(ChatColor.RED + "Message was not sent because you are muted!");
      }


    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String CommandLabel, String[] args) {
       
               
    	 Player player = (Player)sender;
         
         if(CommandLabel.equalsIgnoreCase("ref")){
                 if(args.length == 0){
                         player.sendMessage(ChatColor.GREEN + "Referees: "); player.sendMessage(ChatColor.AQUA + "{PLAYERS}");
                 
                 }
                
                
         }

         if(CommandLabel.equalsIgnoreCase("mute")){
           if(sender.isOp()){
            if(args.length == 0){
               sender.sendMessage(ChatColor.RED + "/mute <player>");
            }
           }
         }



 return false;

}
}
