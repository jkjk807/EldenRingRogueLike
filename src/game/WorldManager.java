package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.*;
import game.actors.Player;
import game.grounds.*;
import game.map.Limgrave;
import game.map.StormveilCastle;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * An World Manager used to instantiate all the Game map in the world and also manage it
 * Created by:
 * @author Lim Jing Kai
 * Modified by:
 *
 */
public class WorldManager extends World {
    public static FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),new Graveyard(),new GustOfWind(),new PuddleOfWater(),new SiteOfLostGrace(),new Barrack(),new Cage(), new Cliff(),new RodWater());

    private static WorldManager instance;

    /**
     *  A hash map contains all the GameMap that will be used in the map
     */
    public static Map<String, GameMap> map = new HashMap<String, GameMap>();



    /**
     * Constructor.
     *
     * @param display the Display that will display this World.
     * @param mapTypes the GameMap that will be used in the map
     */
    public WorldManager(Display display,GameMap... mapTypes) {
        super(display);
        //add the game map to the world
        for (GameMap map : mapTypes) {
            try {
                this.addGameMap(map);
                String name=map.getClass().descriptorString();
                String finalName=name.substring(name.lastIndexOf('/')+1).replace(";","");
                this.map.put(finalName,map);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Player player = new Player("Tarnished", '@', 300);

        this.addPlayer(player, this.map.get("Limgrave").at(0, 0));

        //This is the place where the door is added the new door is instantiated and the destination door is passed in
        this.map.get("StormveilCastle").at(1,1).setGround(new GoldenFogDoor(WorldManager.getMap().get("Limgrave")));
        this.map.get("StormveilCastle").at(1,0).setGround(new GoldenFogDoor(WorldManager.getMap().get("BossRoom")));
        this.map.get("Limgrave").at(1,1).setGround(new GoldenFogDoor(WorldManager.getMap().get("RoundtableHold")));
        this.map.get("Limgrave").at(1,2).setGround(new GoldenFogDoor(WorldManager.getMap().get("LakeOfRot")));
        this.map.get("Limgrave").at(1,0).setGround(new GoldenFogDoor(WorldManager.getMap().get("StormveilCastle")));
        this.map.get("RoundtableHold").at(1,1).setGround(new GoldenFogDoor(WorldManager.getMap().get("Limgrave")));
        this.map.get("LakeOfRot").at(1,1).setGround(new GoldenFogDoor(WorldManager.getMap().get("Limgrave")));



    }

    public static FancyGroundFactory getGroundFactory() {
        return groundFactory;
    }

    /**
     *
     * @return a hashmap of the map used in the world
     */
    public static Map<String, GameMap> getMap() {
        return map;
    }

    public static WorldManager getInstance(){
        if (instance == null) {
            instance = new WorldManager(new Display());
        }
        return instance;
    }
}
