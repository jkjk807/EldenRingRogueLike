package game.map;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import edu.monash.fit2099.engine.positions.Location;
import game.WorldManager;
import game.grounds.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * StormveilCastle is child class of GameMap where this class contains the string representation of the map
 * instantiate a gamemap class
 * Created by:
 * @author Lim Jing Kai
 * Modified by:
 *
 */
public class StormveilCastle extends GameMap {
    /**
     * String representation of the map
     */
    public static List<String> stormveilCastleMap = Arrays.asList


            (
                    "...........................................................................",
                    "._................<...............<........................................",
                    "...........................................................................",
                    "##############################################...##########################",
                    "............................#................#.......B..............B......",
                    ".....B...............B......#................#.............................",
                    "...............................<.........<.................................",
                    ".....B...............B......#................#.......B..............B......",
                    "............................#................#.............................",
                    "#####################..#############...############.####..#########...#####",
                    "...............#++++++++++++#................#++++++++++++#................",
                    "...............#++++++++++++...<.........<...#++++++++++++#................",
                    "...............#++++++++++++..................++++++++++++#................",
                    "...............#++++++++++++#................#++++++++++++#................",
                    "#####...##########.....#############...#############..#############...#####",
                    ".._______........................B......B........................B.....B...",
                    "_____..._..____....&&........<..............<..............................",
                    ".........____......&&......................................................",
                    "...._______..................<..............<....................<.....<...",
                    "#####....##...###..#####...##########___###############......##.....####...",
                    "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
                    "+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
                    "+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
                    "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");
    /**
     * Instantiate a new GameMap Class using the string represention of the map
     */
    public static GameMap stormveilCastleGamemap=new GameMap(WorldManager.getGroundFactory(),stormveilCastleMap);

    public StormveilCastle(GroundFactory groundFactory, String mapFile) throws IOException {
        super(groundFactory, mapFile);

    }
    public StormveilCastle(){
        super(WorldManager.getGroundFactory(), stormveilCastleMap);
    }


    public static GameMap getGamemap() {
        return stormveilCastleGamemap;
    }

}
