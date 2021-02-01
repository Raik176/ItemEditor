package me.Raik167.Plugin;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;

import me.Raik167.Plugin.Events.InvClickEvent_v1_14_R1;
import me.Raik167.Plugin.Events.InvClickEvent_v1_15_R1;
import me.Raik167.Plugin.Events.InvClickEvent_v1_16_R1;

public class ConvPrompt extends StringPrompt {
	@Override
	public Prompt acceptInput(ConversationContext con, String answer) {
		if (!NumberUtils.isNumber(answer)) {
			con.getForWhom().sendRawMessage("answer is not a number! set to 1!");
			if (Main.version.startsWith("v1_14")) {
				InvClickEvent_v1_14_R1.EnchantItem(1);
			} else if (Main.version.startsWith("v1_15")) {
				InvClickEvent_v1_15_R1.EnchantItem(1);
			} else if (Main.version.startsWith("v1_16")) {
				InvClickEvent_v1_16_R1.EnchantItem(1);
			}
		} else if (Long.parseLong(answer) > 2147483647) {
			con.getForWhom().sendRawMessage("answer cannot be above 2,147,483,647! set to 1!");
			if (Main.version.startsWith("v1_14")) {
				InvClickEvent_v1_14_R1.EnchantItem(1);
			} else if (Main.version.startsWith("v1_15")) {
				InvClickEvent_v1_15_R1.EnchantItem(1);
			} else if (Main.version.startsWith("v1_16")) {
				InvClickEvent_v1_16_R1.EnchantItem(1);
			}
		} else {
			if (Main.version.startsWith("v1_14")) {
				InvClickEvent_v1_14_R1.EnchantItem(Integer.parseInt(answer));
			} else if (Main.version.startsWith("v1_15")) {
				InvClickEvent_v1_15_R1.EnchantItem(Integer.parseInt(answer));
			} else if (Main.version.startsWith("v1_16")) {
				InvClickEvent_v1_16_R1.EnchantItem(Integer.parseInt(answer));
			}
		}
		return null;
	}
	@Override
	public String getPromptText(ConversationContext arg0) {
		return "Type a number of the enchantment level:";
	}
}
