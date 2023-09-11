package game.map;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import game.WorldManager;
import game.grounds.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LakeOfRot is child class of GameMap where this class contains the string representation of the map
 * instantiate a gamemap class
 * Created by:
 * @author Lim Jing Kai
 * Modified by:
 *
 */
public class LakeOfRot extends GameMap  {

    //public static FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),new Graveyard(),new GustOfWind(),new PuddleOfWater(),new SiteOfLostGrace(),new GoldenFogDoor(),new Barrack(),new Cage(), new Cliff());
    /**
     * String representation of the map
     */
    public static List<String> lakeOfRotMap = Arrays.asList


            (
                    ".........................",
                    "....wwwwwww..............",
                    "......wwwww..............",
                    "......wwwwwwwww..........",
                    ".........................",
                    ".........................",
                    ".........................");
    /**
     * Instantiate a new GameMap Class using the string represention of the map
     */
    public static GameMap lakeOfRotGamemap=new GameMap(WorldManager.getGroundFactory(),lakeOfRotMap);

    public LakeOfRot(GroundFactory groundFactory, String mapFile) throws IOException {
        super(groundFactory, mapFile);
    }
    public LakeOfRot(){
        super(WorldManager.getGroundFactory(), lakeOfRotMap);


    }


    public static GameMap getGamemap() {
        return lakeOfRotGamemap;
    }

    public static List<String> getMap() {
        return lakeOfRotMap;
    }
}
