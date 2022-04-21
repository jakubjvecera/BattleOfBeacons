package main;

import listners.ConnectToServer;
import listners.PotionOfLeaping;
import listners.PotionOfStrength;
import lobby.Lobby;
import lobby.LobbyCreator;
import org.bukkit.plugin.java.JavaPlugin;
import workingEntity.Trader;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        var world = getServer().getWorlds().get(0);
        Lobby lobby = new LobbyCreator(this).createLobby();

//        Listeners
        getServer().getPluginManager().registerEvents(new PotionOfLeaping(), this);
        getServer().getPluginManager().registerEvents(new PotionOfStrength(), this);
        getServer().getPluginManager().registerEvents(new ConnectToServer(lobby), this);

//        Commands
        getCommand("traderspawn").setExecutor(new Trader());
    }
}
