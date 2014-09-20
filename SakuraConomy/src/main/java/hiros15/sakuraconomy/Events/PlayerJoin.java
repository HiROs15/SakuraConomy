package hiros15.sakuraconomy.Events;

import hiros15.sakuraconomy.Config.EconConfig;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoin implements Listener {
	private Plugin plugin;
	public PlayerJoin(Plugin plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		EconConfig econconfig = new EconConfig(plugin);
		Player player = event.getPlayer();
		
		
		if(!(econconfig.getConfig().getBoolean("economy."+player.getName()+".setup"))) {
			econconfig.getConfig().set("economy."+player.getName()+".setup", true);
			econconfig.getConfig().set("economy."+player.getName()+".credits", 10);
			econconfig.saveConfig();
		}
	}
}
