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
		getLogger().info("[ViaCheckConnection] You use this plugin from your spigot server.");
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
		boolean isUpdate = Updater.checkForUpdate(this, 31805, false);
		if(isUpdate){
			getLogger().info("[ViaCheckConnection] Update available ! updating...");
		boolean success = Updater.download(this, 31805);
		if(success){
			getLogger().info("[ViaCheckConnection] The plugin has been updated.Please restart your server");
		} else {
			getLogger().info("[ViaCheckConnection] Error for update the plugin, maybe spiget or spigot down ?");
			getLogger().info("[ViaCheckConnection] Or maybe you are running a dev-version ?");
		}
		}
		if(Bukkit.getVersion().contains("1.12") || Bukkit.getVersion().contains("1.11") || Bukkit.getVersion().contains("1.10") || Bukkit.getVersion().contains("1.9")) {
			Bukkit.getPluginManager().enablePlugin(this);
		}
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void join(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(Main.isProtocolSupport()){
			if(Bukkit.getVersion().contains("1.8")) {
				if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getId()){
					p.sendMessage(getConfig().getString("v1_8").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()){
					p.sendMessage(getConfig().getString("v1_9_0").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()){
					p.sendMessage(getConfig().getString("v1_9_1").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()){
					p.sendMessage(getConfig().getString("v1_9_2").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()){
					p.sendMessage(getConfig().getString("v1_9_3").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
					p.sendMessage(getConfig().getString("v1_10").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
					p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
					p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
				}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
					p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
					p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()){
					p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()){
					p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
				}
			} else if(Bukkit.getVersion().contains("1.9")) {
				if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()){
					p.sendMessage(getConfig().getString("v1_9_0").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()){
					p.sendMessage(getConfig().getString("v1_9_1").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()){
					p.sendMessage(getConfig().getString("v1_9_2").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()){
					p.sendMessage(getConfig().getString("v1_9_3").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
					p.sendMessage(getConfig().getString("v1_10").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
					p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
					p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
				}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
					p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
					p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()){
					p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()){
					p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
				}
			} else if(Bukkit.getVersion().contains("1.10")) {
				if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
					p.sendMessage(getConfig().getString("v1_10").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
					p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
					p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
				}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
					p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
					p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()){
					p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()){
					p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
				}
			} else if(Bukkit.getVersion().contains("1.11")) {
				if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
					p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
					p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
				}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
					p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
					p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()){
					p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()){
					p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
				}
			} else if(Bukkit.getVersion().contains("1.12")) {
				 if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
						p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
					} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
						p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
					} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()){
						p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
					} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()){
						p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
				}
			}
		} else {
			if(Bukkit.getVersion().contains("1.8")) {
				if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getId()){
					p.sendMessage(getConfig().getString("v1_8").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()){
					p.sendMessage(getConfig().getString("v1_9_0").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()){
					p.sendMessage(getConfig().getString("v1_9_1").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()){
					p.sendMessage(getConfig().getString("v1_9_2").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()){
					p.sendMessage(getConfig().getString("v1_9_3").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
					p.sendMessage(getConfig().getString("v1_10").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
					p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
					p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
				}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
					p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
					p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
				}
			} else if(Bukkit.getVersion().contains("1.9")) {
				if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()){
					p.sendMessage(getConfig().getString("v1_9_0").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()){
					p.sendMessage(getConfig().getString("v1_9_1").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()){
					p.sendMessage(getConfig().getString("v1_9_2").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()){
					p.sendMessage(getConfig().getString("v1_9_3").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
					p.sendMessage(getConfig().getString("v1_10").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
					p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
					p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
				}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
					p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
					p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
				}
			} else if(Bukkit.getVersion().contains("1.10")) {
				if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
					p.sendMessage(getConfig().getString("v1_10").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
					p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
					p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
				}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
					p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
					p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
				}
			} else if(Bukkit.getVersion().contains("1.11")) {
				if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
					p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
					p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
				}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
					p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
					p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
				}
			} else if(Bukkit.getVersion().contains("1.12")) {
				if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
					p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
				} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
					p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
				}
			}
		}
	}
	
	public static boolean isProtocolSupport(){
		return true;
	}

}
