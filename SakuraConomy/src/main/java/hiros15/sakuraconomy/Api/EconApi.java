package hiros15.sakuraconomy.Api;

import hiros15.sakuraconomy.Config.EconConfig;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class EconApi {
	private Plugin plugin;
	public EconApi(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public int getCredits(Player player) {
		EconConfig econconfig = new EconConfig(plugin);
		return econconfig.getConfig().getInt("economy."+player.getName()+".credits");
	}
	
	public void setCredits(Player player, int amount) {
		EconConfig econconfig = new EconConfig(plugin);
		econconfig.getConfig().set("economy."+player.getName()+".credits", amount);
		econconfig.saveConfig();
		econconfig.reloadConfig();
	}
	
	public void addCredits(Player player, int amount) {
		EconConfig econconfig = new EconConfig(plugin);
		int credits = econconfig.getConfig().getInt("economy."+player.getName()+".credits");
		credits = credits+amount;
		setCredits(player, credits);
	}
	
	public void removeCredits(Player player, int amount) {
		EconConfig econconfig = new EconConfig(plugin);
		int credits = econconfig.getConfig().getInt("economy."+player.getName()+".credits");
		credits = credits - amount;
		setCredits(player, credits);
	}
	
	public boolean hasEnoughCredits(Player player, int amount) {
		EconConfig econconfig = new EconConfig(plugin);
		int credits = econconfig.getConfig().getInt("economy."+player.getName()+".credits");
		if((credits-amount) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
