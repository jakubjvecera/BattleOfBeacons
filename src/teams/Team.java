package teams;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public final class Team {
    private final Set<Player> hraci = new HashSet<>();
    private final TeamName teamName;

    public Team(TeamName teamName) {
        this.teamName = teamName;
    }

    public void pridej(Player player) {
        hraci.add(player);
    }

    public boolean patriDoTymu(Player player) {
        return hraci.contains(player);
    }

    public Set<Player> vratHrace() {
        return new HashSet<>(hraci);
    }

    public void zprava(String text, String subtext) {
        hraci.forEach(hrac -> {
            hrac.sendTitle(text, subtext, 0, convertSecToTicks(20), 0);
        });
    }

    public TeamName getJmenoTymu() {
        return teamName;
    }

    private static int convertSecToTicks(int sec) {
        return sec * 20;
    }
}
