package hiros15.sakuraconomy;

import hiros15.sakuraconomy.Config.EconConfig;

import org.bukkit.plugin.java.JavaPlugin;

public class SakuraConomy extends JavaPlugin {
	@Override
	public void onEnable() {
		setupConfig();
		setupEvents();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public void setupConfig() {
	EconConfig econconfig = new EconConfig(this);
	econconfig.getConfig().set("setup", true);
	econconfig.saveConfig();
	}
	
	public void setupEvents() {
		
	}
}
