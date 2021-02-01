package me.Raik167.Plugin;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Raik167.Plugin.Commands.ItemEditor;
import me.Raik167.Plugin.Events.InvClickEvent_v1_14_R1;
import me.Raik167.Plugin.Events.InvClickEvent_v1_15_R1;
import me.Raik167.Plugin.Events.InvClickEvent_v1_16_R1;

public class Main extends JavaPlugin {
	public static String version = "N/A";
	public static Enchantment Glow;
	@Override
	public void onEnable() {
		//Custom Enchants
		Field f;
		try {
			f = Enchantment.class.getDeclaredField("acceptingNew");
			f.setAccessible(true);
			f.set(null,true);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Glow = new Glow(this);
		try {
			Enchantment.registerEnchantment(Glow);
		} catch (IllegalArgumentException e) {}
		//Commands
		this.getCommand("itemeditor").setExecutor(new ItemEditor());
		//Events
		PluginManager pm = Bukkit.getServer().getPluginManager();
		version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		Bukkit.getLogger().info("Server Version: " + version);
		if (version.contentEquals("N/A")) {
			Bukkit.getLogger().warning("Could not detect server version! this plugin will NOT work!");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		} else {
			if (version.startsWith("v1_14")) {
				pm.registerEvents(new InvClickEvent_v1_14_R1(), this);
			} else if (version.startsWith("v1_15")) {
				pm.registerEvents(new InvClickEvent_v1_15_R1(), this);
			} else if (version.startsWith("v1_16")) {
				pm.registerEvents(new InvClickEvent_v1_16_R1(), this);
			}
		}
	}
}