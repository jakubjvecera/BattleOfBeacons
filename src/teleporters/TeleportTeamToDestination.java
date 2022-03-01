package teleporters;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class TeleportTeamToDestination extends Teleporter {

    private static final String TEAM_LOCATION_CONFIG_KEY = "TeamBattleLocation_";

    public TeleportTeamToDestination(Plugin plugin) {
        super(plugin);
    }

    @Override
    public String nameOfTeleporter() {
        return "TeamBattle";
    }

    @Override
    List<Location> destinationOfTeleport() {
        List<Location> places = new ArrayList<>();
        var i = 1;
        Location teamLocation;
        while ((teamLocation = plugin.getConfig().getLocation(getConfigKey(i++))) != null) {
            places.add(teamLocation);
        }
        return places;
    }

    private String getConfigKey(int teamNumber) {
        return TEAM_LOCATION_CONFIG_KEY + teamNumber;
    }
}
