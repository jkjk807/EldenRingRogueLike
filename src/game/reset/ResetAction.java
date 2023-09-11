package game.reset;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * An action executed if an actor or anything is resetted
 * Created by:
 * @author Lim Jing Kai
 * Modified by:
 *
 */
public class ResetAction extends Action  {
    GameMap map;
    Actor actor;
    Location location;

    public ResetAction(Location location) {
        this.location = location;
    }

    public ResetAction() {
    }

    /**
     * Run the Reset function using th Reset Manager
     *
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run();
        return "";

    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }




}
