package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;
import game.actors.Player;
import game.reset.ResetAction;

public class RestAction extends Action {
    Actor actor;
    Location location;
    public RestAction(Actor target, Location location) {
        this.actor = target;
        this.location=location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result="";
        //add site of lost grace location here
        ((Player)actor).registerSiteOfLostGrace(this.location);
        actor.addCapability(Status.RESTING);
        result+=new ResetAction().execute(actor,map);

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor  + " rest at the Site of Lost Grace";
    }
}

