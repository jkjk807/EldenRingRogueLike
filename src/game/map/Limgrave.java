package game.map;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import edu.monash.fit2099.engine.positions.Location;
import game.WorldManager;
import game.grounds.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Limgrave is child class of GameMap where this class contains the string representation of the map
 * instantiate a gamemap class
 * Created by:
 * @author Lim Jing Kai
 * Modified by:
 *
 */
public class Limgrave extends GameMap  {
    private String name="Limgrave";
    /**
     * x coordinate of the door
     */
    private int x=35;
    /**
     * 7 coordinate of the doot
     */
    private int y=10;

    //public static FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),new Graveyard(),new GustOfWind(),new PuddleOfWater(),new SiteOfLostGrace(),new GoldenFogDoor(),new Barrack(),new Cage(), new Cliff());
    /**
     * String representation of the map
     */
    public static List<String> limgraveMap = Arrays.asList


            (
                    "______................................................~~~~~~~~~~~~~~~~~~~~~",
                    "______................#####....######..................~~~~~~~~~~~~~~~~~~~~",
                    "..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~",
                    "..................................__#....................~~~~~~~~~~~~~~~~~~",
                    "......................._____........#.....................~~~~~~~~~~~~~~~~~",
                    "......................#............_#......................~~~~~~~~~~~~~~~~",
                    "......................#...........###......................................",
                    "...........................................................................",
                    "...........................................................................",
                    "~~~~~~~~~~~.......................###___###................................",
                    "~~~~~~~~~~~~......................________#....nnnn........................",
                    "..................................#________................................",
                    "..................................#___U___#................................",
                    "..................................###___###................................",
                    "....................................#___#..................................",
                    ".......................................................&&&.................",
                    ".......................................................&&&.................",
                    ".......................................................&&&.................",
                    "..####__##....................................................######..##...",
                    "..#.....__........&&&.........................................#....____....",
                    "..#___............&&&...........................................__.....#...",
                    "..####__###.......&&&........................................._.....__.#...",
                    "..............................................................###..__###...",
                    "...........................................................................");

    /**
     * Instantiate a new GameMap Class using the string represention of the map
     */
    public static GameMap limgraveGamemap=new GameMap(WorldManager.getGroundFactory(),limgraveMap);

    public Limgrave(GroundFactory groundFactory, String mapFile) throws IOException {
        super(groundFactory, mapFile);
    }

    /**
     * Constructor
     */
    public Limgrave(){
        super(WorldManager.getGroundFactory(), limgraveMap);




    }

    public String getName() {
        return name;
    }

    public static GameMap getGamemap() {
        return limgraveGamemap;
    }

}
