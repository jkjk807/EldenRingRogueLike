package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.GiantCrayfish;
import game.utils.RandomNumberGenerator;

public class PuddleOfWater extends Ground {
    /**
     * A class that represents the PuddleOfWater in the map.
     * Created by:
     *
     * @author Lim Jing Kai
     * Modified by:
     */
    int probabilityGiantCrab = 2;
    int probabilityGiantCrayFish = 1;


    public PuddleOfWater() {
        super('~');
    }

    @Override
    public void tick(Location location) {
        int half = location.map().getXRange().max() / 2;
        int randomValue = RandomNumberGenerator.getRandomInt(100);
        //spawn on west side of the map
        if (location.x() < half) {
            if (randomValue < probabilityGiantCrab && location.getActor() == null) {
                location.addActor(new GiantCrab());
            }
        }
        //spawn on east side of the map
        else {

            if (randomValue < probabilityGiantCrayFish && location.getActor() == null) {
                location.addActor(new GiantCrayfish());
            }
        }
    }
}
