package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.GiantCrayfish;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class RodWater extends Ground {

    /**
     * A class that represents the PuddleOfWater in the map.
     * Created by:
     *
     * @author Lim Jing Kai
     * Modified by:
     */

    public RodWater() {
        super('w');
    }

    @Override
    public void tick(Location location) {
        if (location.getActor()!=null){
            location.getActor().addCapability(Status.ROTTING);
        }

    }
}
