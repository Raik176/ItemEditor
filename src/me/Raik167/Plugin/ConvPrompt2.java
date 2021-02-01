package me.Raik167.Plugin;

import org.bukkit.ChatColor;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;

import me.Raik167.Plugin.Events.InvClickEvent_v1_14_R1;
import me.Raik167.Plugin.Events.InvClickEvent_v1_15_R1;
import me.Raik167.Plugin.Events.InvClickEvent_v1_16_R1;

public class ConvPrompt2 extends StringPrompt {
	@Override
	public Prompt acceptInput(ConversationContext con, String answer) {
		if (Main.version.startsWith("v1_14")) {
			InvClickEvent_v1_14_R1.AddLoreToItem(ChatColor.translateAlternateColorCodes('&', answer));
		} else if (Main.version.startsWith("v1_15")) {
			InvClickEvent_v1_15_R1.AddLoreToItem(ChatColor.translateAlternateColorCodes('&', answer));
		} else if (Main.version.startsWith("v1_16")) {
			InvClickEvent_v1_16_R1.AddLoreToItem(ChatColor.translateAlternateColorCodes('&', answer));
		}
		return null;
	}
	@Override
	public String getPromptText(ConversationContext arg0) {
		return "Type lore to add (supports color codes using &):";
	}
}
