package things;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Armor {
    public ItemStack doChestplateLvl1() {
        var chestplatelvl1 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        chestplatelvl1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        return chestplatelvl1;

    }

    public ItemStack doChestplateLvl2() {
        var chestplateLvl2 = new ItemStack(Material.IRON_CHESTPLATE, 1);
        chestplateLvl2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        return chestplateLvl2;
    }

    public ItemStack doChestplateLvl3() {
        var chestplatelvl3 = new ItemStack(Material.IRON_CHESTPLATE, 1);
        chestplatelvl3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chestplatelvl3.addEnchantment(Enchantment.THORNS, 2);
        return chestplatelvl3;
    }

    public ItemStack doChestplateLvl4() {
        var chestplatelvl4 = new ItemStack(Material.IRON_CHESTPLATE, 1);
        chestplatelvl4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        chestplatelvl4.addEnchantment(Enchantment.THORNS, 5);
        return chestplatelvl4;
    }
}