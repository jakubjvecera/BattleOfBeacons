package lobby;

import org.bukkit.plugin.Plugin;

public class LobbyCreator {
    private static String lobbyLocationStartCorner = "StartCorner";
    private static String lobbyLocatiomEndCorner = "EndCorner";
    private final Plugin plugin;

    public LobbyCreator(Plugin plugin) {
        this.plugin = plugin;
    }
    public Lobby createLobby() {
        var  startCorner = plugin.getConfig().getLocation(lobbyLocationStartCorner);
        var  endCorner = plugin.getConfig().getLocation(lobbyLocatiomEndCorner);
        if (startCorner == null || endCorner == null ) {
            throw new RuntimeException("Lobby isn't defined");
        }
        return new Lobby(startCorner, endCorner);
    }

}