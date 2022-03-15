package listners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionOfStrength implements Listener {

    @EventHandler
    public void doPotionOfStrength(PlayerItemConsumeEvent playerItemConsumeEvent) {
        Player player = playerItemConsumeEvent.getPlayer();
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 2, true, true, true));

    }
}
