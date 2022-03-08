package listners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PortionOfLeaping implements Listener {

    @EventHandler
    public void doPotionOfLeaping(PlayerItemConsumeEvent playerItemConsumeEvent) {
        Player player = playerItemConsumeEvent.getPlayer();
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99, 5, true, true, true));

    }
}
