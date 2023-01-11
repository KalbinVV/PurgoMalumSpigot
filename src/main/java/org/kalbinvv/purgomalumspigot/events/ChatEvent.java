package org.kalbinvv.purgomalumspigot.events;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.kalbinvv.purgomalumspigot.PurgoMalumSpigot;
import org.kalbinvv.purgomalumspigot.requests.PurgoMalumRequest;

public class ChatEvent implements Listener{

	private Set<String> playersTimeouts = new HashSet<String>();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {

		Plugin plugin = PurgoMalumSpigot.getPlugin();

		final Player player = event.getPlayer();
		final String username = player.getName();

		if(playersTimeouts.contains(player.getName())) {
			player.sendMessage(PurgoMalumSpigot.getTimeoutMessage());
			event.setCancelled(true);
			return;
		}

		String unfilteredString = event.getMessage();

		String filteredString = PurgoMalumRequest
				.filterStringFromSwearWords(unfilteredString);

		event.setMessage(filteredString);

		playersTimeouts.add(username);

		Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, () -> {
			playersTimeouts.remove(username);
		}, 20l * PurgoMalumSpigot.getTimeoutDuration());
	}
}
