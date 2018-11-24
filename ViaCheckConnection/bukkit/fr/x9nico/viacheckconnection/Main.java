package fr.x9nico.viacheckconnection;

import fr.x9nico.viacheckconnection.commands.ViaCheckReloadCommand;
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
	static Main instance;
	public static Main getInstance(){return instance;}

	@Override
	public void onEnable() {
		getLogger().info("You are using the plugin on a Spigot server");
		getLogger().info("Plugin version: "+getDescription().getVersion());
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
		getCommand("viacheck").setExecutor(new ViaCheckReloadCommand());
		instance = this;
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

		if(Bukkit.getVersion().contains("1.12") || Bukkit.getVersion().contains("1.11") || Bukkit.getVersion().contains("1.10") || Bukkit.getVersion().contains("1.9") || Bukkit.getVersion().contains("1.13")) {
			getServer().getPluginManager().enablePlugin(this);
		}
		new Metrics(this);
	}

	@SuppressWarnings("unchecked")
	@EventHandler
	public void join(PlayerJoinEvent e){
		Player p = e.getPlayer();

		int id = Via.getAPI().getPlayerVersion(p);
		if (id == -1 || ProtocolVersion.isRegistered(id) == false)
        {
            p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
            return;
        }

        //Srsly its easier to change your configfile, but anyway: Like this it should support your configfile almost completly
		String name = "v"+ProtocolVersion.getProtocol(id).getName().split("/")[0].split("-")[0].replace(".x", "").replace(".", "_");
		p.sendMessage(getConfig().getString(name).replace("&", "§"));

		//Alternative way ( way simpler, but w/o config)

        p.sendMessage("Your are using Minecraft version: "+ProtocolVersion.getProtocol(id).getName());
	}

}