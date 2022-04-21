package lobby;

import org.bukkit.Location;

public final class Lobby {
    private final Location location;

    public Lobby(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}

