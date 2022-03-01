package teleporters;

import lobby.Lobby;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import teams.Team;
import teams.Teams;

import java.util.List;

public final class TeleportToGame {
    private final Lobby lobby;
    private final Teams teams;
    private boolean counting = false;

    public TeleportToGame(Lobby lobby, Teams teams) {
        this.lobby = lobby;
        this.teams = teams;
    }

    public boolean isCounting() {
        return counting;
    }

    private void count(List<Player> players) {
        counting = true;
        var countFor = 5;
        for (int i = countFor; i > 0; i--) {
            for (Player player : players) {
                player.sendTitle("Game starting in ", i + "", 0, 500, 0);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
            }
        }
        counting = false;
    }

    public void teleport(Teleporter teleporter) {
        List<Player> lobbyPls = lobby.playersInLobby();
        List<Location> places = teleporter.destinationOfTeleport();
        teams.addBattleTeams(lobbyPls, places.size());
        for (int i = 0; i < teams.numberOfTeams(); i++) {
            Location location = places.get(i);
            Team team = teams.getTeam(i);
            for (Player player : team.getPs()) {
                player.teleport(location);
            }
        }
        count(lobbyPls);
    }
}