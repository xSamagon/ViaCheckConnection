package fr.x9nico.viacheckconnection.bungee;

import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class Bungee extends Plugin implements Listener{
	
	@Override
	public void onEnable() {
		System.out.println("[ViaCheckConnection] WARNING! It is not a BungeeCord's plugin ! please set this plugin on your spigot's plugins folder.");
	}

}
