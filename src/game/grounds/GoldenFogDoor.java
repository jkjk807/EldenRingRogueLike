package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.EnterDoorAction;
import game.actions.RestAction;
import game.utils.Status;

public class GoldenFogDoor extends Ground {
    GameMap map;
    Location location;
    /**
     * Constructor.
     *
     */
    public GoldenFogDoor(GameMap map) {
        super('D');
        this.map = map;

    }

    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        actions.add(new EnterDoorAction(actor,this.map,location));

        return actions;
    }
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }
}
