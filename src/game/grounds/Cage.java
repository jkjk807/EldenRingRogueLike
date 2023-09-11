package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Dog;
import game.actors.enemies.GiantDog;
import game.actors.enemies.LoneWolf;
import game.utils.RandomNumberGenerator;

public class Cage extends Ground {
    /**
     * Constructor.
     *
     */
    public Cage() {
        super('<');
    }
    private int probabilityGodriclSoldiers=45;
    @Override
    public void tick(Location location){

        int randomValue = RandomNumberGenerator.getRandomInt(100);
        if (randomValue < probabilityGodriclSoldiers && location.getActor() == null) {
            location.addActor(new Dog());
        }


    }
}
