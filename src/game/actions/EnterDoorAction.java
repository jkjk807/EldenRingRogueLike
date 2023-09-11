package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.Application;
import game.WorldManager;
import game.grounds.*;

import java.util.Arrays;
import java.util.List;

public class EnterDoorAction extends Action {
    private Actor actor;
    private GameMap map;
    /**
     *  Location back to the original door
     */
    private Location location;
    public EnterDoorAction(Actor actor,GameMap map,Location location) {
        this.actor=actor;
        this.map=map;
        this.location=location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        System.out.println("enter door");
//        System.out.println("here it is"+WorldManager.getInstance().getGamemap().toString());
        this.map.at(1,1).addActor(actor);
        return "";
    }

    @Override
    public String menuDescription(Actor actor) {
        String name=map.getClass().descriptorString();
        String finalName=name.substring(name.lastIndexOf('/')+1).replace(";","");
        return actor  + " Enter the door"+" to "+finalName;
    }
}
