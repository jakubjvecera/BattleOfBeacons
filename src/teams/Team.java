package teams;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public final class Team {
    private final Set<Player> players = new HashSet<>();
    private final Location spawnPoint;


    public Team(Location spawnPoint) {
        this.spawnPoint = spawnPoint;
    }

    public void add(Player player) {
        players.add(player);
    }

    public boolean inTeam(Player player) {
        return players.contains(player);
    }

    public Set<Player> getPlayers() {
        return new HashSet<>(players);
    }

    public Location getSpawnPoint() {
        return spawnPoint;
    }
}
