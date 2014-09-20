package hiros15.sakuraconomy.Config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class EconConfig {
	private Plugin plugin;
	public EconConfig(Plugin plugin) {
		this.plugin = plugin;
	}
	
	private FileConfiguration config = null;
	private File file = null;
	
	public void reloadConfig() {
		if(file == null) {
			file = new File(plugin.getDataFolder(), "economy.yml");
		}
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public FileConfiguration getConfig() {
		if(config == null) {
			reloadConfig();
		}
		return config;
	}
	
	public void saveConfig() {
		try {
			config.save(file);
		} catch(Exception e) {}
	}
}
