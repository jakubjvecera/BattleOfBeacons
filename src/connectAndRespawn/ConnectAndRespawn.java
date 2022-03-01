package connectAndRespawn;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class ConnectAndRespawn implements Listener {

    @EventHandler
    public static void connect(PlayerJoinEvent playerJoinEvent) {
        playerJoinEvent.getPlayer().teleport(new Location(playerJoinEvent.getPlayer().getWorld(), 0, 118, 0));
    }

    @EventHandler
    public static void respawn(PlayerRespawnEvent event) {
        event.setRespawnLocation(new Location(event.getPlayer().getWorld(), 0, 88, 82));
        event.setRespawnLocation(new Location(event.getPlayer().getWorld(), -83, 88, 0));
        event.setRespawnLocation(new Location(event.getPlayer().getWorld(), -1, 88, -83));
        event.setRespawnLocation(new Location(event.getPlayer().getWorld(), 82, 88, -1));


    }
}