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
         e.setCancelled(true);
         
         p.sendMessage(ChatColor.RED + "Message was not sent because you are muted!");
      }


    }
    
    @EventHandler
    public void onCommandProccess(PlayerCommandPreprocessEvent e){
      Player p = e.getPlayer();

      if(mplayers.contains(p.getName)){
         e.setCancelled(true);
         
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
       return false;
     }

 @Override
 public boolean onCommand(CommandSender sender, Command command, String CommandLabel, String[] args) {
         if(CommandLabel.equalsIgnoreCase("mute")){
           if(sender.isOp()){
            if(args.length == 0){
               sender.sendMessage(ChatColor.RED + "/mute <player>");
            }else if(!(args.length > 1)){
               Player target = Bukkit.getPlayer(args[0]);
               
               if(target == null){
                 sender.sendMessage(ChatColor.RED + "Player not online!");
                 return false;
               }
               
               if(mplayers.contains(target.getName())){
                 sender.sendMessage(ChatColor.DARK_RED + target.getDisplayName() + ChatColor.YELLOW + " is already muted! Use /unmute " + target.getName() + " to unmute him/her!");
                 return false;
               }
               
               mplayers.add(target.getName);
               sender.sendMessage(ChatColor.YELLOW + "You muted " + target.getDisplayName());
               target.sendMessage(ChatColor.YELLOW + "You were muted by " + sender.getDisplayName());
               return true;
            }
           }
         }return false;
  
 } 
 
 
  @Override
 public boolean onCommand(CommandSender sender, Command command, String CommandLabel, String[] args) {
         if(CommandLabel.equalsIgnoreCase("unmute")){
           if(sender.isOp()){
            if(args.length == 0){
               sender.sendMessage(ChatColor.RED + "/unmute <player>");
            }else if(!(args.length > 1)){
               Player target = Bukkit.getPlayer(args[0]);
               
               if(target == null){
                 sender.sendMessage(ChatColor.RED + "Player not online!");
                 return false;
               }
               
               if(mplayers.contains(target.getName()){
                 sender.sendMessage(target.getDisplayName() + ChatColor.YELLOW + " is not muted. Use /mute " + target.getName() + " to mute him/her!");
                 return false;
               }
               
               mplayers.add(target.getName);
               sender.sendMessage(ChatColor.YELLOW + "You unmuted " + target.getDisplayName());
               target.sendMessage(ChatColor.YELLOW + "You were unmuted by " + sender.getDisplayName());
               return true;
            }
           }
         }return false;
  
 } 
 
}
