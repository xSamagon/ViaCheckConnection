package fr.x9nico.viacheckconnection;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import us.myles.ViaVersion.api.Via;
import us.myles.ViaVersion.api.protocol.ProtocolVersion;

public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		System.out.println("[ViaCheckConnection] You use this plugin from your spigot server.");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void join(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getId()){
			p.sendMessage("§6[ViaCheck] §rYou are connected from the server with a §b1.8§r's version");
		} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()){
			p.sendMessage("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version");
		} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()){
			p.sendMessage("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version");
		} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()){
			p.sendMessage("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version");
		} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()){
			p.sendMessage("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version");
		} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
			p.sendMessage("§6[ViaCheck] §rYou are connected from the server with a §b1.10§r's version");
		} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
			p.sendMessage("§6[ViaCheck] §rYou are connected from the server with a §b1.11§r's version");
		}
	}

}
