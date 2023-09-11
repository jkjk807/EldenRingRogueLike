package game.utils;

import edu.monash.fit2099.engine.positions.Location;

public class Utils {
    public static int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
