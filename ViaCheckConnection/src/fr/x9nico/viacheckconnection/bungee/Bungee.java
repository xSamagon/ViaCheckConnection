package fr.x9nico.viacheckconnection.bungee;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;
import us.myles.ViaVersion.api.Via;
import us.myles.ViaVersion.api.protocol.ProtocolVersion;

public class Bungee extends Plugin implements Listener{
	
	@Override
	public void onEnable() {
		getLogger().info("[ViaCheckConnection] You use this plugin with BungeeCord.Don't forget to remove this plugin from yours spigot servers");
		getProxy().getPluginManager().registerListener(this, this);
	}
	
	@SuppressWarnings({ "unchecked" })
	@EventHandler
	public void join(ServerConnectedEvent e){
		ProxiedPlayer p = e.getPlayer();
		if(Bungee.isProtocolSupport()){
			if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.8§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.10§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.11§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.11§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.12§r's snapshot version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §cERROR! We don't find your minecraft's version.Please report this bug."));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.7§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.7§r's version"));
			}
		} else {
			if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.8§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.9§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.10§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.11§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.11§r's version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §rYou are connected from the server with a §b1.12§r's snapshot version"));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
				p.sendMessage(new TextComponent("§6[ViaCheck] §cERROR! We don't find your minecraft's version.Please report this bug."));
			}
		}
	}
	
	public static boolean isProtocolSupport(){
		return true;
	}

}
