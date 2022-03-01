package main;

import connectAndRespawn.ConnectAndRespawn;
import org.bukkit.plugin.java.JavaPlugin;
import workingEntity.Trader;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        var world = getServer().getWorlds().get(0);
        var serverConnect = new ConnectAndRespawn();

        //Listeners
        getServer().getPluginManager().registerEvents(serverConnect, this);
//        comands
        getCommand("traderspawn").setExecutor(new Trader());
    }
}