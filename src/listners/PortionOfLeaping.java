package listners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PortionOfLeaping implements Listener {

    @EventHandler
    public ItemStack doPotionOfLeaping(PlayerItemConsumeEvent playerItemConsumeEvent) {
        var potionOfLeaping = new ItemStack(Material.POTION, 1);
        var itemMeta = potionOfLeaping.getItemMeta();
        itemMeta.setDisplayName("Potion of leaping");
        potionOfLeaping.setItemMeta(itemMeta);
        playerItemConsumeEvent.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP,99,5,true,true,true));
        return potionOfLeaping;
    }
}
