package com.gmail.gamebot1080.Refke;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable()
	{
		System.out.println("Refke enabled");
		
		this.getCommand("fly").setExecutor(new Fly());
                this.getCommand("heal").setExecutor(new Heal());
                this.getCommand("broadcast").setExecutor(new Broadcast());
	}	
	@Override
	public void onDisable()
	{
		System.out.println("Refke disabled");
	}	
}
