package Refke.src.com.gmail.gamebot1080.Refke.JoinListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class idk implements Listener{

    //****Only working for referees at the moment!****

    /*ChatColor.GRAY + "\u2756") == gray + ❖*/

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(refs.contains(e.getPlayer().getName())){
            e.getPlayer().setDisplayName(ChatColor.GRAY + "\u2756" + e.getPlayer().getDisplayName());


            e.setJoinMessage(ChatColor.GRAY + "\u2756" + e.getJoinMessage());
            return;
        }else{
            return;
        }
    }

    //Constant checker for team joining and other display name changes.

    @EventHandler
    public void onConstant(PlayerMoveEvent e){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(refs.contanins(p.getName()) && !p.getDisplayName().contains(ChatColor.GRAY + "\u2756") ){
                p.setDisplayName(ChatColor.GRAY + "\u2756" + e.getPlayer().getDisplayName());
            }else{
                return;
            }

        }
    }

    //Small improvement so leave message displays the ref star

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        if(!e.getQuitMessage().contains(ChatColor.GRAY + "\u2756")) {
            e.setQuitMessage(ChatColor.GRAY + "\u2756" + e.getQuitMessage());
            return;
        }
    }
}
