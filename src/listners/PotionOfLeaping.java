package listners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import things.SpecialsItemsNames;

public class PotionOfLeaping implements Listener {

    @EventHandler
    public void doPotionOfLeaping(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        var itemMeta = event.getItem().getItemMeta();
        if(itemMeta == null) return;
        if (SpecialsItemsNames.POTION_NAME_LEAPING.equals(itemMeta.getDisplayName())) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200, 10, true, true, true));

        }


    }
}