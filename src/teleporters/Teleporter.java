package teleporters;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.List;

public abstract class Teleporter {
    protected final Plugin plugin;

    public Teleporter(Plugin plugin) {

        this.plugin = plugin;
    }

    public abstract String nameOfTeleporter();
    abstract List<Location> destinationOfTeleport();

}