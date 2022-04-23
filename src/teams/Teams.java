package teams;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class Teams {
    private final List<Team> teams = new ArrayList<>();
    private final Plugin plugin;
    private static final String TEAM_LOCATION_CONFIG_KEY = "TeamBattleLocation_";


    public Teams(Plugin plugin) {
        this.plugin = plugin;
    }

    public List<Team> getTeams() {
        if (teams.isEmpty()) throw new IllegalStateException("Teams are not yet initialized");
        return new ArrayList<>(teams);
    }

    public int numberOfTeams() {
        return teams.size();
    }

    public Team getTeam(int i) {
        if (teams.isEmpty()) throw new IllegalStateException("Teams are not yet initialized");
        return teams.get(i);
    }

    public void createTeams() {
        teams.clear();
        List<Location> spawnPoints = teamsSpawnPoints();
        List<Player> players = new ArrayList<>(plugin.getServer().getOnlinePlayers());
        int teamCount = spawnPoints.size();
        for (Location spawnPoint : spawnPoints) {
            teams.add(new Team(spawnPoint));
        }
        mix(players);
        int i = 0;
        for (Player player : players) {
            teams.get(i++).add(player);
            if (i >= teamCount) i = 0;
        }
        teams.removeIf(team -> team.getPlayers().isEmpty());
    }

    private void mix(List<Player> players) {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int idx1 = rand.nextInt(players.size());
            int idx2 = rand.nextInt(players.size());
            Player player = players.get(idx1);
            players.set(idx1, players.get(idx2));
            players.set(idx2, player);
        }
    }

    public void removeTeam(Team team) {
        if (teams.isEmpty()) throw new IllegalStateException("Teams are not yet initialized");
        teams.remove(team);
    }

    private List<Location> teamsSpawnPoints() {
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