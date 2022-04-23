package main;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import teams.Teams;
import teleporters.TeleportToGame;

public class StartGame implements CommandExecutor {
    private final TeleportToGame teleportToGame;
    private final Teams teams;

    public StartGame(TeleportToGame teleportToGame, Teams teams) {
        this.teleportToGame = teleportToGame;
        this.teams = teams;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        teams.createTeams();
        //create beacon for every team
        for (var team : teams.getTeams()) {
            var spawnLocation = team.getSpawnPoint();
            spawnLocation.getBlock().setType(Material.BEACON);
        }
        teleportToGame.teleport();
        return true;
    }
}
