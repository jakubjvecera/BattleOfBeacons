package teleporters;

import org.bukkit.entity.Player;
import teams.Team;
import teams.Teams;

public final class TeleportToGame {
    private final Teams teams;

    public TeleportToGame(Teams teams) {
        this.teams = teams;
    }

    public void teleport() {
        for (int i = 0; i < teams.numberOfTeams(); i++) {
            Team team = teams.getTeam(i);
            var teamSpawnLocation = team.getSpawnPoint().clone().add(0, 1, 0);
            for (Player player : team.getPlayers()) {
                player.teleport(teamSpawnLocation);
                player.setBedSpawnLocation(teamSpawnLocation, true);
            }
        }
    }

}