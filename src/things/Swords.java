package things;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Swords {
    public ItemStack doSwordLvl1() {
        var swordLvl1 = new ItemStack(Material.IRON_SWORD, 1);
        swordLvl1.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        return swordLvl1;
    }

    public ItemStack doSwordLvl2() {
        var swordLvl2 = new ItemStack(Material.IRON_SWORD, 1);
        swordLvl2.addEnchantment(Enchantment.DAMAGE_ALL, 3);
        swordLvl2.addEnchantment(Enchantment.KNOCKBACK, 1);
        return swordLvl2;
    }

    public ItemStack doSwordLvl3() {
        var swordLvl3 = new ItemStack(Material.IRON_SWORD, 1);
        swordLvl3.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        swordLvl3.addEnchantment(Enchantment.KNOCKBACK, 2);
        swordLvl3.addEnchantment(Enchantment.FIRE_ASPECT, 2);
        return swordLvl3;
    }
}