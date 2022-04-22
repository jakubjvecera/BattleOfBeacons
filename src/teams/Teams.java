package teams;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teams {
    private final List<Team> teams = new ArrayList<>();

    public List<Team> getTeams() {
        return new ArrayList<>(teams);
    }

    public int numberOfTeams() {
        return teams.size();
    }

    public Team getTeam(int i) {
        return teams.get(i);
    }

    public void createTeams(List<Player> players, List<Location> spawnPoints) {
        teams.clear();
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
        teams.remove(team);
    }

}