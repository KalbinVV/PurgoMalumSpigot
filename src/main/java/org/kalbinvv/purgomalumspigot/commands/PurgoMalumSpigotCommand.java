package org.kalbinvv.purgomalumspigot.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.kalbinvv.purgomalumspigot.PurgoMalumSpigot;

import net.md_5.bungee.api.ChatColor;

public class PurgoMalumSpigotCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, 
			String label, String[] args) {
		if(args.length < 1) {
			return false;
		}

		if(args[0].equals("reload")) {
			Plugin plugin = PurgoMalumSpigot.getPlugin();
			
			if(sender instanceof Player) {
				Player player = (Player) sender;
				
				if(!player.hasPermission("purgomalum.reload")) {
					return false;
				}
				
				player.sendMessage(ChatColor.GREEN + "Plugin was reloaded!");
			}else {
				plugin.getLogger().info("Plugin was reloaded!");
			}
			
			File configurationFile = new File(plugin.getDataFolder(), "config.yml");

			YamlConfiguration configuration = YamlConfiguration
					.loadConfiguration(configurationFile);
			
			PurgoMalumSpigot.setTimeoutDuration(configuration.getLong("timeout"));
			PurgoMalumSpigot.setTimeoutMessage(configuration.getString("message"));
		}else {
			return false;
		}

		return true;
	}

}
