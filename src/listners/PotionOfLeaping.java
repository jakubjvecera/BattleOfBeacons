package listners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionOfLeaping implements Listener {

    @EventHandler
    public void doPotionOfLeaping(PlayerItemConsumeEvent playerItemConsumeEvent) {
        Player player = playerItemConsumeEvent.getPlayer();
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200, 10, true, true, true));

    }
}