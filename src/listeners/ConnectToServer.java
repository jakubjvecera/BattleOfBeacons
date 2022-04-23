package listeners;

import lobby.Lobby;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConnectToServer implements Listener {

    private final Lobby lobby;

    public ConnectToServer(Lobby lobby) {
        this.lobby = lobby;
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent playerJoinEvent) {
        var player  = playerJoinEvent.getPlayer();
        player.setGameMode(GameMode.SURVIVAL);
        player.teleport(lobby.getLocation());
    }
}
