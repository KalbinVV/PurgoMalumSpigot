package org.kalbinvv.purgomalumspigot;

import org.bukkit.plugin.java.JavaPlugin;
import org.kalbinvv.purgomalumspigot.commands.PurgoMalumSpigotCommand;
import org.kalbinvv.purgomalumspigot.commands.PurgoMalumSpigotTabCompleter;
import org.kalbinvv.purgomalumspigot.events.ChatEvent;

public class PurgoMalumSpigot extends JavaPlugin{

	private static JavaPlugin plugin;
	
	private static Long timeoutDuration;
	private static String timeoutMessage;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		plugin = this;
		
		enableMetrics();
		
		setTimeoutDuration(getConfig().getLong("timeout"));
		setTimeoutMessage(getConfig().getString("message"));
		
		getServer().getPluginManager().registerEvents(new ChatEvent(), plugin);
		
		getCommand("purgomalum").setExecutor(new PurgoMalumSpigotCommand());
		getCommand("purgomalum").setTabCompleter(new PurgoMalumSpigotTabCompleter());
	}
	
	private void enableMetrics() {
		int pluginId = 17351;
		new Metrics(this, pluginId);
	}

	public static JavaPlugin getPlugin() {
		return plugin;
	}

	public static Long getTimeoutDuration() {
		return timeoutDuration;
	}

	public static void setTimeoutDuration(Long timeoutDuration) {
		PurgoMalumSpigot.timeoutDuration = timeoutDuration;
	}

	public static String getTimeoutMessage() {
		return timeoutMessage;
	}

	public static void setTimeoutMessage(String timeoutMessage) {
		PurgoMalumSpigot.timeoutMessage = timeoutMessage;
	}
	
	
}
