package things;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;

public class Specials {

    public ItemStack doWaterBucket() {
        var waterBucket = new ItemStack(Material.WATER_BUCKET, 1);
        return waterBucket;
    }

    public ItemStack doTridentLvl1() {
        var tridentLvl1 = new ItemStack(Material.TRIDENT, 1);
        tridentLvl1.addEnchantment(Enchantment.LOYALTY, 1);
        return tridentLvl1;
    }

    public ItemStack doTridentLvl2() {
        var tridentLvl2 = new ItemStack(Material.TRIDENT, 1);
        tridentLvl2.addEnchantment(Enchantment.LOYALTY, 8);
        return tridentLvl2;
    }

    public ItemStack doLavaBucket() {
        var lavaBucket = new ItemStack(Material.LAVA_BUCKET, 1);
        return lavaBucket;
    }

    public ItemStack doPotionOfLeaping() {
        var potionOfLeaping = new ItemStack(Material.POTION, 1);
        var itemMeta = potionOfLeaping.getItemMeta();
        itemMeta.setDisplayName(SpecialsItemsNames.POTION_NAME);
        potionOfLeaping.setItemMeta(itemMeta);
        return potionOfLeaping;
    }

    public ItemStack doPotionOfStrength() {
        var potionOfStrength = new ItemStack(Material.POTION, 1);
        var itemMeta = potionOfStrength.getItemMeta();
        itemMeta.setDisplayName(SpecialsItemsNames.POTION_NAME_STRENGTH);
        potionOfStrength.setItemMeta(itemMeta);
        return potionOfStrength;


    }
}