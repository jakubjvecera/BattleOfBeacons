package teams;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FriendlyFireOff implements Listener {

    private final Teams teams;

    public FriendlyFireOff(Teams teams) {
        this.teams = teams;
    }

    @EventHandler
    public void friendlyFire(EntityDamageByEntityEvent event) {
        Entity attacker = event.getDamager();
        if (!(attacker instanceof Player)) return;
        Entity hurt = event.getEntity();
        if (!(hurt instanceof Player)) return;
        for (Team team : teams.getTeams()) {
            if (team.inTeam((Player) attacker) && team.inTeam((Player) hurt)) {
                event.setCancelled(true);
                break;
            }
        }
    }
}
