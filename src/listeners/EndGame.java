package listeners;

import lobby.Lobby;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import teams.Team;
import teams.Teams;

public class EndGame implements Listener {

    private final Teams teams;
    private final Lobby lobby;

    public EndGame(Teams teams, Lobby lobby) {
        this.teams = teams;
        this.lobby = lobby;
    }

    @EventHandler
    public void endGame(BlockBreakEvent event) {
        if (event.getBlock().getType() != Material.BEACON) return;
        var destroyedBlockLocation = event.getBlock().getLocation();
        for (var team : teams.getTeams()) {
            if (team.getSpawnPoint().equals(destroyedBlockLocation)) {
                event.setDropItems(false);
                //this team lost
                endTeam(team, "You lost");
                teams.removeTeam(team);
                if (teams.getTeams().size() == 1) {
                    var winnerTeam = teams.getTeam(0);
                    endTeam(winnerTeam, "You won");
                }
            }
        }
    }

    private void endTeam(Team team, String message) {
        for (var player : team.getPlayers()) {
            player.sendTitle(message, null, 0,10,0);
            player.teleport(lobby.getLocation());
        }
    }
}
