package me.Raik167.Plugin;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {
	public static ItemStack createItem(Material itemmat, int amount, List<String> lore, String... name) {
		ItemStack item = new ItemStack(itemmat,amount);
		ItemMeta im = item.getItemMeta();
		im.setLore(lore);
		if (name.length >= 0) {
			im.setDisplayName(name[0]);
		}
		item.setItemMeta(im);
		return item;
	}
}
