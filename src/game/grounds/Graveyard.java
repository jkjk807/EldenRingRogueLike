package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.SkeletalBandit;
import game.utils.RandomNumberGenerator;
import game.actors.enemies.HeavySkeletalSwordsman;

public class Graveyard extends Ground {
    /**
     * A class that represents the Graveyard in the map.
     * Created by:
     * @author Lim Jing Kai
     * Modified by:
     *
     */
    int probability = 27;
    public Graveyard() {
        super('n');
    }

    @Override
    public void tick(Location location){
        int half = location.map().getXRange().max() / 2;
        int randomValue = RandomNumberGenerator.getRandomInt(100);

        if (location.x() < half) {
            if (randomValue < probability && location.getActor()==null) {
                location.addActor(new HeavySkeletalSwordsman());
            }
        }
        else{
            if (randomValue < probability && location.getActor()==null) {
                location.addActor(new SkeletalBandit());
            }
        }

    }
}
