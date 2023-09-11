package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Dog;
import game.actors.enemies.GodrickSoldier;
import game.utils.RandomNumberGenerator;

public class Barrack extends Ground {
    /**
     * Constructor.
     *
     */
    public Barrack() {
        super('B');
    }

    private int probabilityDog=37;
    @Override
    public void tick(Location location){

        int randomValue = RandomNumberGenerator.getRandomInt(100);
        if (randomValue < probabilityDog && location.getActor() == null) {
            location.addActor(new GodrickSoldier());
        }


    }
}
