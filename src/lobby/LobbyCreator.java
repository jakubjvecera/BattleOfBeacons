package lobby;

import org.bukkit.plugin.Plugin;

public final class LobbyCreator {
    private static final String LOBBY_LOCATION = "LobbyLocation";
    private final Plugin plugin;

    public LobbyCreator(Plugin plugin) {
        this.plugin = plugin;
    }

    public Lobby createLobby() {
        var  location = plugin.getConfig().getLocation(LOBBY_LOCATION);
        if (location == null ) {
            throw new RuntimeException("Lobby isn't defined");
        }
        return new Lobby(location);
    }
}