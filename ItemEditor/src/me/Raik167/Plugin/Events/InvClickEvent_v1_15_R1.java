package me.Raik167.Plugin.Events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.conversations.Conversable;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationFactory;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Raik167.Plugin.ConvPrompt;
import me.Raik167.Plugin.ConvPrompt1;
import me.Raik167.Plugin.ConvPrompt2;
import me.Raik167.Plugin.ConvPrompt3;
import me.Raik167.Plugin.ItemCreator;
import me.Raik167.Plugin.Main;

public class InvClickEvent_v1_15_R1 implements Listener {
	private Main plugin = Main.getPlugin(Main.class);
	static Enchantment toEnchant;
	static ItemStack ItemToEnchant;
	static Inventory inv;
	static Inventory inv42;
	static Player p;
	static Conversation conv;
	static String name;
	static ItemStack item;
	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		p = (Player) e.getWhoClicked();
		if (e.getView().getTitle() == "Item Editor" || e.getView().getTitle() == "Enchant Item" || e.getView().getTitle() == "Add or Remove Enchant" || e.getView().getTitle() == "Remove Enchant" || e.getView().getTitle() == "Add or Remove Lore" || e.getView().getTitle() == "Remove Lore Line" || e.getView().getTitle() == "Show/Hide Flags") {
			if (e.getView().getTitle() == "Item Editor") {
				item = e.getView().getItem(22);
				inv = e.getInventory();
				ItemToEnchant = item;
			}
			e.setCancelled(true);
			try {
				if (e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.GRAY+ "" + ChatColor.BOLD + "Rename")) {
					ConversationFactory cf2 = new ConversationFactory(plugin);
					Conversation conv2 = cf2.withFirstPrompt(new ConvPrompt1()).withLocalEcho(true).buildConversation((Conversable) e.getWhoClicked());
					p.closeInventory();
					conv2.begin();
				}
			} catch (Exception e2) {}
			if (e.getView().getTitle() == "Show/Hide Flags") {
				if (e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Hide Enchants")) {
					Boolean b = Boolean.parseBoolean(e.getCurrentItem().getItemMeta().getLore().get(0).replaceAll("Shown", "false").replaceAll("Hidden", "true"));
					ItemMeta meta7 = ItemToEnchant.getItemMeta();
					ItemMeta meta8 = e.getCurrentItem().getItemMeta();
					if (b) {
						meta7.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
						meta8.setLore(Arrays.asList("Shown"));
					} else {
						meta7.addItemFlags(ItemFlag.HIDE_ENCHANTS);
						meta8.setLore(Arrays.asList("Hidden"));
					}
					ItemToEnchant.setItemMeta(meta7);
					e.getCurrentItem().setItemMeta(meta8);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Hide Attributes")) {
					Boolean b = Boolean.parseBoolean(e.getCurrentItem().getItemMeta().getLore().get(0).replaceAll("Shown", "false").replaceAll("Hidden", "true"));
					ItemMeta meta7 = ItemToEnchant.getItemMeta();
					ItemMeta meta8 = e.getCurrentItem().getItemMeta();
					if (b) {
						meta7.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
						meta8.setLore(Arrays.asList("Shown"));
					} else {
						meta7.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
						meta8.setLore(Arrays.asList("Hidden"));
					}
					ItemToEnchant.setItemMeta(meta7);
					e.getCurrentItem().setItemMeta(meta8);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Hide Unbreakable")) {
					Boolean b = Boolean.parseBoolean(e.getCurrentItem().getItemMeta().getLore().get(0).replaceAll("Shown", "false").replaceAll("Hidden", "true"));
					ItemMeta meta7 = ItemToEnchant.getItemMeta();
					ItemMeta meta8 = e.getCurrentItem().getItemMeta();
					if (b) {
						meta7.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
						meta8.setLore(Arrays.asList("Shown"));
					} else {
						meta7.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
						meta8.setLore(Arrays.asList("Hidden"));
					}
					ItemToEnchant.setItemMeta(meta7);
					e.getCurrentItem().setItemMeta(meta8);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.AQUA + "" + ChatColor.BOLD + "Hide breaks/destroys")) {
					Boolean b = Boolean.parseBoolean(e.getCurrentItem().getItemMeta().getLore().get(0).replaceAll("Shown", "false").replaceAll("Hidden", "true"));
					ItemMeta meta7 = ItemToEnchant.getItemMeta();
					ItemMeta meta8 = e.getCurrentItem().getItemMeta();
					if (b) {
						meta7.removeItemFlags(ItemFlag.HIDE_DESTROYS);
						meta8.setLore(Arrays.asList("Shown"));
					} else {
						meta7.addItemFlags(ItemFlag.HIDE_DESTROYS);
						meta8.setLore(Arrays.asList("Hidden"));
					}
					ItemToEnchant.setItemMeta(meta7);
					e.getCurrentItem().setItemMeta(meta8);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.BLUE + "" + ChatColor.BOLD + "Hide blocks placed on")) {
					Boolean b = Boolean.parseBoolean(e.getCurrentItem().getItemMeta().getLore().get(0).replaceAll("Shown", "false").replaceAll("Hidden", "true"));
					ItemMeta meta7 = ItemToEnchant.getItemMeta();
					ItemMeta meta8 = e.getCurrentItem().getItemMeta();
					if (b) {
						meta7.removeItemFlags(ItemFlag.HIDE_PLACED_ON);
						meta8.setLore(Arrays.asList("Shown"));
					} else {
						meta7.addItemFlags(ItemFlag.HIDE_PLACED_ON);
						meta8.setLore(Arrays.asList("Hidden"));
					}
					ItemToEnchant.setItemMeta(meta7);
					e.getCurrentItem().setItemMeta(meta8);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Hide Potion Effects")) {
					Boolean b = Boolean.parseBoolean(e.getCurrentItem().getItemMeta().getLore().get(0).replaceAll("Shown", "false").replaceAll("Hidden", "true"));
					ItemMeta meta7 = ItemToEnchant.getItemMeta();
					ItemMeta meta8 = e.getCurrentItem().getItemMeta();
					if (b) {
						meta7.removeItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
						meta8.setLore(Arrays.asList("Shown"));
					} else {
						meta7.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
						meta8.setLore(Arrays.asList("Hidden"));
					}
					ItemToEnchant.setItemMeta(meta7);
					e.getCurrentItem().setItemMeta(meta8);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Hide Color")) {
					Boolean b = Boolean.parseBoolean(e.getCurrentItem().getItemMeta().getLore().get(0).replaceAll("Shown", "false").replaceAll("Hidden", "true"));
					ItemMeta meta7 = ItemToEnchant.getItemMeta();
					ItemMeta meta8 = e.getCurrentItem().getItemMeta();
					if (b) {
						meta7.removeItemFlags(ItemFlag.HIDE_DYE);
						meta8.setLore(Arrays.asList("Shown"));
					} else {
						meta7.addItemFlags(ItemFlag.HIDE_DYE);
						meta8.setLore(Arrays.asList("Hidden"));
					}
					ItemToEnchant.setItemMeta(meta7);
					e.getCurrentItem().setItemMeta(meta8);
				}
				inv.setItem(22, ItemToEnchant);
				p.openInventory(inv);
			}
			if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.AQUA + "" + ChatColor.BOLD + "Lore")) {
				Inventory inv5 = Bukkit.createInventory(null, 27, "Add or Remove Lore");
				ItemStack item2 = new ItemStack(Material.ANVIL);
				ItemMeta meta2 = item2.getItemMeta();
				meta2.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Add Line");
				item2.setItemMeta(meta2);
				inv5.setItem(10, item2);
				ItemStack item3 = new ItemStack(Material.ANVIL);
				ItemMeta meta3 = item3.getItemMeta();
				meta3.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Remove Line");
				item3.setItemMeta(meta3);
				inv5.setItem(16, item3);
				e.getWhoClicked().openInventory(inv5);
			}
			if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Set Itemflags")) {
				Inventory inv7 = Bukkit.createInventory(null, 36, "Show/Hide Flags");
				ItemStack he = ItemCreator.createItem(Material.ENCHANTED_BOOK,1,Arrays.asList(Boolean.toString(ItemToEnchant.getItemMeta().getItemFlags().contains(ItemFlag.HIDE_ENCHANTS)).replaceAll("true", "Hidden").replaceAll("false", "Shown")),ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Hide Enchants");
				inv7.setItem(10, he);
				ItemStack ha = ItemCreator.createItem(Material.COMMAND_BLOCK,1,Arrays.asList(Boolean.toString(ItemToEnchant.getItemMeta().getItemFlags().contains(ItemFlag.HIDE_ATTRIBUTES)).replaceAll("true", "Hidden").replaceAll("false", "Shown")),ChatColor.DARK_RED + "" + ChatColor.BOLD + "Hide Attributes");
				inv7.setItem(20, ha);
				ItemStack hu = ItemCreator.createItem(Material.BEDROCK,1,Arrays.asList(Boolean.toString(ItemToEnchant.getItemMeta().getItemFlags().contains(ItemFlag.HIDE_UNBREAKABLE)).replaceAll("true", "Hidden").replaceAll("false", "Shown")),ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Hide Unbreakable");
				inv7.setItem(12, hu);
				ItemStack hd = ItemCreator.createItem(Material.DIAMOND_PICKAXE,1,Arrays.asList(Boolean.toString(ItemToEnchant.getItemMeta().getItemFlags().contains(ItemFlag.HIDE_DESTROYS)).replaceAll("true", "Hidden").replaceAll("false", "Shown")),ChatColor.AQUA + "" + ChatColor.BOLD + "Hide breaks/destroys");
				inv7.setItem(22, hd);
				ItemStack hpo = ItemCreator.createItem(Material.COBBLESTONE,1,Arrays.asList(Boolean.toString(ItemToEnchant.getItemMeta().getItemFlags().contains(ItemFlag.HIDE_PLACED_ON)).replaceAll("true", "Hidden").replaceAll("false", "Shown")),ChatColor.BLUE + "" + ChatColor.BOLD + "Hide blocks placed on");
				inv7.setItem(14, hpo);
				ItemStack hpe = ItemCreator.createItem(Material.POTION,1,Arrays.asList(Boolean.toString(ItemToEnchant.getItemMeta().getItemFlags().contains(ItemFlag.HIDE_POTION_EFFECTS)).replaceAll("true", "Hidden").replaceAll("false", "Shown")),ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Hide Potion Effects");
				inv7.setItem(24, hpe);
				ItemStack hc = ItemCreator.createItem(Material.CYAN_DYE,1,Arrays.asList(Boolean.toString(ItemToEnchant.getItemMeta().getItemFlags().contains(ItemFlag.HIDE_DYE)).replaceAll("true", "Hidden").replaceAll("false", "Shown")),ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Hide Color");
				inv7.setItem(16, hc);
				p.openInventory(inv7);
			}
			if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.GREEN + "" + ChatColor.BOLD + "Add Glow")) {
				
			}
			if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Remove Line")) {
				Inventory inv6 = Bukkit.createInventory(null, 54, "Remove Lore Line");
				for (String line : ItemToEnchant.getItemMeta().getLore()) {
					ItemStack item7 = new ItemStack(Material.BIRCH_SIGN);
					ItemMeta meta7 = item7.getItemMeta();
					meta7.setDisplayName(Integer.toString(ItemToEnchant.getItemMeta().getLore().indexOf(line)));
					meta7.setLore(Arrays.asList(line));
					item7.setItemMeta(meta7);
					inv6.addItem(item7);
				}
				p.openInventory(inv6);
			}
			if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Add Line")) {
				ConversationFactory cf3 = new ConversationFactory(plugin);
				Conversation conv3 = cf3.withFirstPrompt(new ConvPrompt2()).withLocalEcho(true).buildConversation((Conversable) e.getWhoClicked());
				p.closeInventory();
				conv3.begin();
			}
			if (e.getView().getTitle() == "Remove Lore Line") {
				List<String> lore = ItemToEnchant.getItemMeta().getLore();
				lore.remove(Integer.parseInt(e.getCurrentItem().getItemMeta().getDisplayName()));
				ItemMeta meta8 = ItemToEnchant.getItemMeta();
				meta8.setLore(lore);
				ItemToEnchant.setItemMeta(meta8);
				inv.setItem(22, ItemToEnchant);
				p.openInventory(inv);
				
			}
			if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.DARK_GRAY+ "" + ChatColor.BOLD + "Toggle Unbreakable")) {
				ItemMeta meta5 = ItemToEnchant.getItemMeta();
				meta5.setUnbreakable(!meta5.isUnbreakable());
				ItemToEnchant.setItemMeta(meta5);
				
				ItemStack item6 = e.getView().getItem(24);
				ItemMeta meta6 = item6.getItemMeta();
				List<String> lore = meta6.getLore();
				for (String val : lore) {
					Bukkit.getLogger().info(val);
				}
				lore.set(0, Boolean.toString(meta5.isUnbreakable()));
				for (String val : lore) {
					Bukkit.getLogger().info(val);
				}
				meta6.setLore(lore);
				item6.setItemMeta(meta6);
				e.getInventory().setItem(24, item6);
			}
			if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Enchant")) {
				ItemMeta meta = item.getItemMeta();
				name = meta.getDisplayName();
				Inventory inv2 = Bukkit.createInventory(null, 27, "Add or Remove Enchant");
				ItemStack item2 = new ItemStack(Material.ENCHANTED_BOOK);
				ItemMeta meta2 = item2.getItemMeta();
				meta2.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Add Enchant");
				item2.setItemMeta(meta2);
				inv2.setItem(10, item2);
				ItemStack item3 = new ItemStack(Material.ENCHANTED_BOOK);
				ItemMeta meta3 = item3.getItemMeta();
				meta3.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Remove Enchant");
				item3.setItemMeta(meta3);
				inv2.setItem(16, item3);
				e.getWhoClicked().openInventory(inv2);
			}
			if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Add Enchant")) {
				HashSet<Enchantment> enchs = new HashSet<Enchantment>();
				for (Enchantment ench : Enchantment.values()) {
						enchs.add(ench);
				}
				Inventory inv5 = Bukkit.createInventory(null, 54, "Enchant Item");
				if (e.getWhoClicked().hasPermission("enchants.bypass")) {
					for (Enchantment ench : enchs) {
						ItemStack item1 = new ItemStack(Material.ENCHANTED_BOOK);
						ItemMeta meta1 = item1.getItemMeta();
						meta1.addEnchant(ench, 1, true);
						item1.setItemMeta(meta1);
						inv5.addItem(item1);
					}
				} else {
					for (Enchantment ench : enchs) {
						if (ench.canEnchantItem(ItemToEnchant)) {
							ItemStack item1 = new ItemStack(Material.ENCHANTED_BOOK);
							ItemMeta meta1 = item1.getItemMeta();
							meta1.addEnchant(ench, 1, true);
							item1.setItemMeta(meta1);
							inv5.addItem(item1);
						}
					}
				}
				e.getWhoClicked().openInventory(inv5);
			}
			if(e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Change Amount")) {
				ConversationFactory cf = new ConversationFactory(plugin);
				conv = cf.withFirstPrompt(new ConvPrompt3()).withLocalEcho(true).buildConversation((Conversable) e.getWhoClicked());
				p.closeInventory();
				conv.begin();
			}
			if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().contentEquals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Remove Enchant")) {
				Map<Enchantment,Integer> ItemEnchants = ItemToEnchant.getItemMeta().getEnchants();
				Inventory inv4 = Bukkit.createInventory(null, 54, "Remove Enchant");
				for (Enchantment ench : ItemEnchants.keySet()) {
					ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
					ItemMeta bookmeta = book.getItemMeta();
					bookmeta.addEnchant(ench, ItemEnchants.get(ench), true);
					bookmeta.setDisplayName("Remove Enchant:");
					book.setItemMeta(bookmeta);
					inv4.addItem(book);
				}
				e.getWhoClicked().openInventory(inv4);
			}
			if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName().contentEquals("Remove Enchant:")) {
				Enchantment ench = e.getCurrentItem().getEnchantments().keySet().iterator().next();
				ItemToEnchant.removeEnchantment(ench);
				e.getWhoClicked().openInventory(inv);
				e.getView().setItem(22, ItemToEnchant);
			}
			if (e.getView().getTitle() == "Enchant Item") {
				ItemStack item2 = e.getCurrentItem();
				toEnchant = item2.getItemMeta().getEnchants().entrySet().iterator().next().getKey();
				ConversationFactory cf = new ConversationFactory(plugin);
				conv = cf.withFirstPrompt(new ConvPrompt()).withLocalEcho(true).buildConversation((Conversable) e.getWhoClicked());
				p.closeInventory();
				conv.begin();
			}
			if (e.getSlot() == 22 && e.getView().getTitle() == "Item Editor") {
				p.getInventory().setItemInMainHand(e.getView().getItem(22));
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1f, 1f);
				p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Edits applied" + "!");
			}
		}
	}
	public static void EnchantItem(int level) {
		ItemMeta meta = ItemToEnchant.getItemMeta();
		meta.addEnchant(toEnchant, level, true);
		ItemToEnchant.setItemMeta(meta);
		inv.setItem(22, ItemToEnchant);
		p.openInventory(inv);
		conv.abandon();
	}
	public static void ChangeItemName(String name) {
		ItemMeta meta = ItemToEnchant.getItemMeta();
		meta.setDisplayName(name);
		ItemToEnchant.setItemMeta(meta);
		inv.setItem(22,  ItemToEnchant);
		p.openInventory(inv);
	}
	public static void AddLoreToItem(String lore) {
		Bukkit.getLogger().info(lore);
		ItemMeta meta = ItemToEnchant.getItemMeta();
		List<String> lorel = meta.getLore();
		if (lorel == null) {
			lorel = new ArrayList<String>();
		}
		lorel.add(lore);
		meta.setLore(lorel);
		ItemToEnchant.setItemMeta(meta);
		inv.setItem(22,  ItemToEnchant);
		p.openInventory(inv);
	}
	public static void SetAmount(int amount) {
		ItemStack fixedItem = new ItemStack(ItemToEnchant.getType(), amount);
		fixedItem.setItemMeta(ItemToEnchant.getItemMeta());
		ItemToEnchant = fixedItem;
		inv.setItem(22,  ItemToEnchant);
		p.openInventory(inv);
	}
}
