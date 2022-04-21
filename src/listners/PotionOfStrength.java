package listners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import things.SpecialsItemsNames;

public class PotionOfStrength implements Listener {

    @EventHandler
    public void doPotionOfStrength(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        var itemMeta = event.getItem().getItemMeta();
        if(itemMeta == null) return;
        if(SpecialsItemsNames.POTION_NAME_STRENGTH.equals(itemMeta.getDisplayName())){
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 2, true, true, true));
        }


    }
}
