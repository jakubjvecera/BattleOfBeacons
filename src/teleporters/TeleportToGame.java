package teleporters;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import teams.Team;
import teams.Teams;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public final class TeleportToGame {
    private final Teams teams;

    public TeleportToGame(Teams teams) {
        this.teams = teams;
    }

    public void teleport() {
        for (int i = 0; i < teams.numberOfTeams(); i++) {
            Team team = teams.getTeam(i);
            for (Player player : team.getPlayers()) {
                player.teleport(team.getSpawnPoint().clone().add(0, 1, 0));
                player.setBedSpawnLocation(team.getSpawnPoint(), true);
            }
        }
    }
}