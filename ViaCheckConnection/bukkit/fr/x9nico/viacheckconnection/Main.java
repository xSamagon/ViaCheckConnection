package fr.x9nico.viacheckconnection;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import us.myles.ViaVersion.api.Via;
import us.myles.ViaVersion.api.protocol.ProtocolVersion;

public class Main extends JavaPlugin implements Listener{

	FileConfiguration config;
	
	@Override
	public void onEnable() {
		getLogger().info("You are using the plugin on a Spigot server");
		getLogger().info("Plugin version: "+getDescription().getVersion());
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
		boolean isUpdate = Updater.checkForUpdate(this, 31805, false);
		if(isUpdate){
			getLogger().info("We found a plugin update! Downloading it...");
		boolean success = Updater.download(this, 31805);
		if(success){
			getLogger().info("The plugin has been updated, please restart the server.");
		} else {
			getLogger().info("The plugin couldn't be updated. Either Spiget is down or you're using a dev version.");
		}
		}
		if(Bukkit.getVersion().contains("1.12") || Bukkit.getVersion().contains("1.11") || Bukkit.getVersion().contains("1.10") || Bukkit.getVersion().contains("1.9")) {
			getServer().getPluginManager().enablePlugin(this);
		}
		new Metrics(this);
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void join(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(Main.isProtocolSupport()){	
			
			//I'm not sure if there was a need to get the server version. As long as the player has a version, this will send them the "message:" option in the config.
			if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getID() || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_0.getID() || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getID() || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getID() || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3 || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getID() || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getID() || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getID() || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getID() || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_1.getID() || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_2.getID() || Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13.getID()) {
				boolean pv = true;
				if(pv == true){
				  p.sendMessage(getConfig().getString("message").replace("&", "§"));
				  getConfig().replaceAll("%version%", Via.getAPI().getPlayerVersion(p));
				}
			}
		} else {
			p.sendMessage(ChatColor.RED + "ERROR);
		}
	}
	
	public static boolean isProtocolSupport(){
		return true;
	}

}
