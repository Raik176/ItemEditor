package me.Raik167.Plugin;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Glow extends Enchantment {
  private final NamespacedKey key;
      public Glow(Plugin main) {
          super(new NamespacedKey(main,"glowing"));
              this.key = new NamespacedKey(main,"glowing");
      }

      @Override
      public boolean canEnchantItem(ItemStack arg0) {
          return true;
      }

      @Override
      public boolean conflictsWith(Enchantment arg0) {
          return false;
      }

      @Override
      public EnchantmentTarget getItemTarget() {
          return null;
      }

      @Override
      public int getMaxLevel() {
          return 0;
      }

      @Override
      public String getName() {
          return "Glowing";
      }

      @Override
      public int getStartLevel() {
          return 0;
      }

    @Override
    public boolean isCursed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTreasure() {
        // TODO Auto-generated method stub
        return false;
    }
        @Override
    public NamespacedKey getKey() {
        return this.key;
    }
    }