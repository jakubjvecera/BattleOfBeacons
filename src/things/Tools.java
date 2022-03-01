package things;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Tools {
    public ItemStack doAxeLvl1() {
        var axeLvl1 = new ItemStack(Material.STONE_AXE, 1);
        axeLvl1.addEnchantment(Enchantment.DIG_SPEED, 1);
        return axeLvl1;
    }
}
