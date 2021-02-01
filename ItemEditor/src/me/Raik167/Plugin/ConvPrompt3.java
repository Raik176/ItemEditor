package me.Raik167.Plugin;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;

import me.Raik167.Plugin.Events.InvClickEvent_v1_14_R1;
import me.Raik167.Plugin.Events.InvClickEvent_v1_15_R1;
import me.Raik167.Plugin.Events.InvClickEvent_v1_16_R1;

public class ConvPrompt3 extends StringPrompt {
	@Override
	public Prompt acceptInput(ConversationContext con, String answer) {
		if (!NumberUtils.isNumber(answer)) {
			con.getForWhom().sendRawMessage("answer is not a number! set to 1!");
			if (Main.version.startsWith("v1_14")) {
				InvClickEvent_v1_14_R1.SetAmount(1);
			} else if (Main.version.startsWith("v1_15")) {
				InvClickEvent_v1_15_R1.SetAmount(1);
			} else if (Main.version.startsWith("v1_16")) {
				InvClickEvent_v1_16_R1.SetAmount(1);
			}
		} else {
			if (Integer.parseInt(answer) > 64) {
				con.getForWhom().sendRawMessage("Amount cannot be greater than 64, set to 64");
				if (Main.version.startsWith("v1_14")) {
					InvClickEvent_v1_14_R1.SetAmount(64);
				} else if (Main.version.startsWith("v1_15")) {
					InvClickEvent_v1_15_R1.SetAmount(64);
				} else if (Main.version.startsWith("v1_16")) {
					InvClickEvent_v1_16_R1.SetAmount(64);
				}
			} else if (Integer.parseInt(answer) < 1) {
				con.getForWhom().sendRawMessage("Amount cannot be below 1, set to 1");
				if (Main.version.startsWith("v1_14_R1")) {
					InvClickEvent_v1_14_R1.SetAmount(1);
				} else if (Main.version.startsWith("v1_15")) {
					InvClickEvent_v1_15_R1.SetAmount(1);
				} else if (Main.version.startsWith("v1_16")) {
					InvClickEvent_v1_16_R1.SetAmount(1);
				}
			} else {
				if (Main.version.startsWith("v1_14")) {
					InvClickEvent_v1_14_R1.SetAmount(Integer.parseInt(answer));
				} else if (Main.version.startsWith("v1_15")) {
					InvClickEvent_v1_15_R1.SetAmount(Integer.parseInt(answer));
				} else if (Main.version.startsWith("v1_16")) {
					InvClickEvent_v1_16_R1.SetAmount(Integer.parseInt(answer));
				}
			}
		}
		return null;
	}
	@Override
	public String getPromptText(ConversationContext arg0) {
		return "Type a amount:";
	}
}
