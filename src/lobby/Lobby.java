package lobby;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public final class Lobby {
    private final Location corner1;
    private final Location corner2;

    public Lobby(Location corner1, Location corner2) {
        this.corner1 = corner1;
        this.corner2 = corner2;
    }

    private boolean between(double value, double min, double max) {
        return value > min && value < max;
    }

    public boolean isInLobby(Location location) {
        //        betweenX
        var minX = Math.min(corner1.getX(), corner2.getX());
        var maxX = Math.max(corner1.getX(), corner2.getX());
        if (!between(location.getX(), minX, maxX)) return false;

        //        betweenY
        var minY = Math.min(corner1.getY(), corner2.getY());
        var maxY = Math.max(corner1.getY(), corner2.getY());
        if (!between(location.getY(), minY, maxY)) return false;

        //        betweenZ
        var minZ = Math.min(corner1.getZ(), corner2.getZ());
        var maxZ = Math.max(corner1.getZ(), corner2.getZ());
        if (!between(location.getZ(), minZ, maxZ)) return false;

        //        ok
        return true;
    }

    public List<Player> playersInLobby() {
        World world = corner1.getWorld();
        return world.getPlayers().stream().filter(player -> isInLobby(player.getLocation())).collect(Collectors.toList());
    }
}

