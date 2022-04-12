package teams;

import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teams {
    private List<Team> teams = new ArrayList<>();

    public List<Team> getTeams() {
        return new ArrayList<>(teams);
    }

    public int numberOfTeams() {
        return teams.size();
    }

    public Team getTeam(int i) {
        return teams.get(i  ,éééééééééééé);
    }

    public void addBattleTeams(List<Player> hraci, int numberTeams) {
        teams.clear();
        for (int i = 0; i < numberTeams; i++) {
            teams.add(new Team());
        }
        hraci = mixP(hraci);
        int i = 0;
        for (Player player : hraci) {
            teams.get(i++).addP(player);
            if (i >= numberTeams) i = 0;
        }
    }

    private List<Player> mixP(List<Player> players) {
        Random rand = new Random(System.nanoTime());
        for (int i = 0; i < 100; i++) {
            int firstIndex = rand.nextInt(players.size());
            int secondIndex = rand.nextInt(players.size());
            Player player = players.get(firstIndex);
            players.set(firstIndex, players.get(secondIndex));
            players.set(secondIndex, player);
        }
        return players;
    }
}