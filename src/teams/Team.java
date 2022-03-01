package teams;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public final class Team {
    private Set<Player> players = new HashSet<>();

    public void addP(Player player) {
        players.add(player);
    }

    public boolean inTeamP(Player player) {
        return players.contains(player);
    }

    public Set<Player> getPs() {
        return new HashSet<>(players);
    }
}
