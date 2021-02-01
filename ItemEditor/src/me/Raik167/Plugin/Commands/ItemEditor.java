package me.Raik167.Plugin.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Raik167.Plugin.Main;

public class ItemEditor implements CommandExecutor,TabCompleter {
	private static Inventory inv;
	private static Player p;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!sender.hasPermission("itemeditor.use")) {
			sender.sendMessage(Bukkit.getPluginCommand("itemeditor").getPermissionMessage());
			return false;
		}
		inv = Bukkit.createInventory(null, 45, "Item Editor");
		ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Enchant");
		item.setItemMeta(meta);
		inv.setItem(4, item);
		ItemStack item3 = new ItemStack(Material.NAME_TAG);
		ItemMeta meta3 = item3.getItemMeta();
		meta3.setDisplayName(ChatColor.GRAY+ "" + ChatColor.BOLD + "Rename");
		item3.setItemMeta(meta3);
		inv.setItem(14, item3);
		ItemStack item4 = new ItemStack(Material.ANVIL);
		ItemMeta meta4 = item4.getItemMeta();
		meta4.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Lore");
		item4.setItemMeta(meta4);
		inv.setItem(32, item4);
		ItemStack item6 = new ItemStack(Material.COMMAND_BLOCK);
		ItemMeta meta6 = item6.getItemMeta();
		meta6.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Set Itemflags");
		item6.setItemMeta(meta6);
		inv.setItem(30, item6);
		ItemStack item5 = new ItemStack(Material.OAK_SAPLING);
		ItemMeta meta5 = item5.getItemMeta();
		meta5.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Change Amount");
		item5.setItemMeta(meta5);
		inv.setItem(40, item5);
		ItemStack item7 = new ItemStack(Material.KNOWLEDGE_BOOK);
		ItemMeta meta7 = item7.getItemMeta();
		meta7.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Add Glow");
		meta7.addEnchant(Main.Glow, 1, true);
		item7.setItemMeta(meta7);
		inv.setItem(20, item7);
		if (sender instanceof Player) {
			p = (Player) sender;
			if (p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
				if (args.length != 1) {
					p.sendMessage("you did not specify a id and do not have a item in the hand, no item will be edited");
				}
				try {
					String itemId = args[0];
					if (Material.getMaterial(itemId.toUpperCase()) == null) {
						p.sendMessage("invalid item: " + itemId);
					} else {
						ItemStack item1 = new ItemStack(Material.getMaterial(itemId.toUpperCase()));
						inv.setItem(22, item1);
						ItemStack item2 = new ItemStack(Material.BEDROCK);
						ItemMeta meta2 = item2.getItemMeta();
						meta2.setDisplayName(ChatColor.DARK_GRAY+ "" + ChatColor.BOLD + "Toggle Unbreakable");
						meta2.setLore(Arrays.asList("false","True means unbreakable","False means not unbreakable"));
						item2.setItemMeta(meta2);
						inv.setItem(24, item2);
						p.openInventory(inv);
					}
				} catch (IllegalArgumentException e) {
					String itemId = args[0];
					p.sendMessage("invalid item: " + itemId);
				} catch (NullPointerException exc) {
					
				}
				return false;
			}
			inv.setItem(22, p.getInventory().getItemInMainHand());
			ItemStack item2 = new ItemStack(Material.BEDROCK);
			ItemMeta meta2 = item2.getItemMeta();
			meta2.setDisplayName(ChatColor.DARK_GRAY+ "" + ChatColor.BOLD + "Toggle Unbreakable");
			meta2.setLore(Arrays.asList(Boolean.toString(p.getInventory().getItemInMainHand().getItemMeta().isUnbreakable()),"True means unbreakable","False means not unbreakable"));
			item2.setItemMeta(meta2);
			inv.setItem(24, item2);
			p.openInventory(inv);
		}
		return false;
	}
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("itemeditor") || label.equalsIgnoreCase("ie") && args.length == 1) {
			if (sender instanceof Player) {
				@SuppressWarnings("unused")
				Player p = (Player) sender;
				List<Material> list = Arrays.asList(Material.values());
				List<String> complete = new ArrayList<String>();
				for (Material m : list) {
					complete.add(m.name().toLowerCase());
				}
				return complete;
			}
		}
		return null;
	}
}
