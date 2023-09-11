package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.GiantDog;
import game.actors.enemies.LoneWolf;
import game.utils.RandomNumberGenerator;

public class GustOfWind extends Ground {
    /**
     * A class that represents the GustOfWind in the map.
     * Created by:
     * @author Lim Jing Kai
     * Modified by:
     *
     */
    int probabilityLoneWolf = 33;
    int giantDog = 4;
    public GustOfWind() {
        super('&');
    }

    @Override
    public void tick(Location location){
        int half = location.map().getXRange().max() / 2;
        int randomValue = RandomNumberGenerator.getRandomInt(100);


        if (location.x() < half && location.getActor() == null) {
            if (randomValue < probabilityLoneWolf && location.getActor() == null) {
                location.addActor(new LoneWolf());
            }
        }
        else{
            if (randomValue < giantDog && location.getActor() == null) {
                location.addActor(new GiantDog());
            }
        }
    }
}
