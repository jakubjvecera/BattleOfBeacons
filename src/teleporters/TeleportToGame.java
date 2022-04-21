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
    private final Plugin plugin;
    private static final String TEAM_LOCATION_CONFIG_KEY = "TeamBattleLocation_";

    public TeleportToGame(Teams teams, Plugin plugin) {
        this.teams = teams;
        this.plugin = plugin;
    }

    public void teleport() {
        List<Location> mista = teleportTargets();
        teams.createTeams(List.copyOf(plugin.getServer().getOnlinePlayers()), mista);
        for (int i = 0; i < teams.numberOfTeams(); i++) {
            Team team = teams.getTeam(i);
            for (Player player : team.getPlayers()) {
                player.teleport(team.getSpawnPoint());
                player.setBedSpawnLocation(team.getSpawnPoint());
            }
        }
    }

    private List<Location> teleportTargets() {
        List<Location> locations = new ArrayList<>();
        var i = 1;
        Location teamLocation;
        while ((teamLocation = plugin.getConfig().getLocation(getConfigKey(i++))) != null) {
            locations.add(teamLocation);
        }
        if (locations.size() == 0) {
            plugin.getLogger().log(Level.CONFIG, "Nenactena spawnovaci mista z configu pro team battle.");
        } else {
            plugin.getLogger().log(Level.CONFIG, "Pocet spawnovacich mist pro team battle:  " + locations.size());
        }
        return locations;
    }

    private String getConfigKey(int teamNumber) {
        return TEAM_LOCATION_CONFIG_KEY + teamNumber;
    }

}