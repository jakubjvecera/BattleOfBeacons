package main;

import connectAndRespawn.ConnectAndRespawn;
import listners.PotionOfLeaping;
import listners.PotionOfStrength;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.plugin.java.JavaPlugin;
import workingEntity.Trader;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        var world = getServer().getWorlds().get(0);
        var serverConnect = new ConnectAndRespawn();
        this.saveDefaultConfig();
        Bukkit.setDefaultGameMode(GameMode.SURVIVAL);

//        Listeners
        getServer().getPluginManager().registerEvents(serverConnect, this);
        getServer().getPluginManager().registerEvents(new PotionOfLeaping(), this);
        getServer().getPluginManager().registerEvents(new PotionOfStrength(), this);
//        Commands
        getCommand("traderspawn").setExecutor(new Trader());
    }
}
