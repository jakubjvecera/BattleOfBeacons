package main;

import listeners.*;
import lobby.Lobby;
import lobby.LobbyCreator;
import org.bukkit.plugin.java.JavaPlugin;
import teams.Teams;
import teleporters.TeleportToGame;
import workingEntity.Trader;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Lobby lobby = new LobbyCreator(this).createLobby();
        Teams teams = new Teams(this);
        TeleportToGame teleportToGame = new TeleportToGame(teams);

//        Listeners
        getServer().getPluginManager().registerEvents(new PotionOfLeaping(), this);
        getServer().getPluginManager().registerEvents(new PotionOfStrength(), this);
        getServer().getPluginManager().registerEvents(new ConnectToServer(lobby), this);
        getServer().getPluginManager().registerEvents(new FriendlyFireOff(teams), this);
        getServer().getPluginManager().registerEvents(new EndGame(teams,lobby), this);

//        Commands
        getCommand("traderspawn").setExecutor(new Trader());
        getCommand("startgame").setExecutor(new StartGame(teleportToGame,teams));
    }
}
