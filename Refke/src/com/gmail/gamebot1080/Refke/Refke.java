package com.gmail.gamebot1080.Refke;
 
import java.util.logging.Logger;
 
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Refke extends JavaPlugin {

    public static ArrayList<String> mplayers = new ArrayList<>();
    
    public static ArrayList<String> refs = new ArrayList<>();

        private Logger logger = Logger.getLogger("Minecraft");
    public void sendConsole(String Message){
        this.logger.info("[Refke]" + Message);      
       
    }
    public void onEnable() {
     
     refs.add("vYuri");
     refs.add("lauty01capo");
     refs.add("Vixo1");
     refs.add("C4477");
     refs.add("javipepe");

      Bukkit.getServer().registerEvents(this, this);
      Bukkit.getServer().registerEvents(ConnectionListener.class, this);
       
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
                         player.sendMessage(ChatColor.GRAY + "Referees: " + compoundList(refs, "", ChatColor.DARK_GRAY + "");
                         return true;
                 
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
               return true;
            }else if(!(args.length > 1)){
               Player target = Bukkit.getPlayer(args[0]);
               
               if(target == null){
                 sender.sendMessage(ChatColor.RED + "Player not online!");
                 return true;
               }
               
               if(mplayers.contains(target.getName())){
                 sender.sendMessage(ChatColor.DARK_RED + target.getDisplayName() + ChatColor.YELLOW + " is already muted! Use /unmute " + target.getName() + " to unmute him/her!");
                 return true;
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
         if(CommandLabel.equalsIgnoreCase("captain")){
           if(sender.isOp()){
            if(args.length == 0){
               sender.sendMessage(ChatColor.RED + "/captain <player>");
               return true;
            }else if(!(args.length > 1)){
               Player target = Bukkit.getPlayer(args[0]);
               
               if(target == null){
                 sender.sendMessage(ChatColor.RED + "Player not online!");
                 return true;
               }
               
               if(target.getDisplayName().contains("Captain"){
                 String newdisp = target.getDisplayName().replace("[Captain]", "");
                 target.setDisplayName(newdisp);
                 sender.sendMessage(ChatColor.RED + "Succesfully un-captained " + target.getName());
                 target.sendMessage(ChatColor.RED + "You are no longer a captain!");
                 return true;
               }
               
               target.setDisplayName(ChatColor.GRAY + "[" + ChatColor.GREEN + "Captain" + ChatColor.GRAY + "] " + target.getDisplayName());
               sender.sendMessage(ChatColor.YELLOW + "You captained " + target.getName());
               target.sendMessage(ChatColor.YELLOW + "You are now a captain!");
               return true;
            }
           }
         }return false;
  
 } 

 //****only testing! ****

  @Override
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("m"))
        {
            if (sender.isOp()) {
                if (args.length < 2)
                {
                    sender.sendMessage(ChatColor.RED + "Usage: /m chat [message]");
                }
                else
                {
                    String ReportName = args[0];
                    String ReportReson = "";
                    for (int i = 1; i <= args.length - 1; i++)
                    {
                        ReportReson = ReportReson + args[i];
                        if (i != args.length - 1) {
                            ReportReson = ReportReson + " ";
                        }
                    }
                    Player[] arrayOfPlayer;
                    int j = (arrayOfPlayer = getServer().getOnlinePlayers()).length;
                    for (int i = 0; i < j; i++)
                    {
                        Player player = arrayOfPlayer[i];
                        Player s = (Player) sender
                        Location location = player.getLocation();
                        if (player.isOp())
                        {
                            player.sendMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + "M" + ChatColor.WHITE + "]" + ChatColor.WHITE + " [" + ChatColor.GOLD + "Kyetho" + ChatColor.WHITE + "] " + ChatColor.DARK_AQUA + s.getDisplayName() + ChatColor.YELLOW + ": " + ReportReson);
                            player.playSound(location, Sound.NOTE_BASS_GUITAR, 1.0F, 0.0F);
                        }
                    }
                }
            }else{
                sender.sendMessage(ChatColor.RED + "You don´t have permission to use modchat!");
               return true;
            }
           }
         }return false;
           
 } 
 
 @Override
 public boolean onCommand(CommandSender sender, Command command, String CommandLabel, String[] args) {
         if(CommandLabel.equalsIgnoreCase("ref")){
           if(sender.isOp()){
            if(args.length == 0){
               sender.sendMessage(ChatColor.RED + "/ref <player>");
               return true;
            }else if(!(args.length > 1)){
               Player target = Bukkit.getPlayer(args[0]);
               
               if(target == null){
                 sender.sendMessage(ChatColor.RED + "Player not online!");
                 return true;
               }
               
               if(target.getDisplayName().contains("ref"){
                 String newdisp = target.getDisplayName().replace("[Ref]", "");
                 target.setDisplayName(newdisp);
                 sender.sendMessage(ChatColor.RED + "Successfully un-referee " + target.getName());
                 target.sendMessage(ChatColor.RED + "You are no longer a referee!");
                 return true;
               }
               
               target.setDisplayName(ChatColor.GRAY + "[" + ChatColor.GREEN + "Referee" + ChatColor.GRAY + "] " + target.getDisplayName());
               sender.sendMessage(ChatColor.YELLOW + "You referee" + target.getName());
               target.sendMessage(ChatColor.YELLOW + "You are now a referee!");
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
               return true;
            }else if(!(args.length > 1)){
               Player target = Bukkit.getPlayer(args[0]);
               
               if(target == null){
                 sender.sendMessage(ChatColor.RED + "Player not online!");
                 return true;
               }
               
               if(mplayers.contains(target.getName()){
                 sender.sendMessage(target.getDisplayName() + ChatColor.YELLOW + " is not muted. Use /mute " + target.getName() + " to mute him/her!");
                 return true;
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
