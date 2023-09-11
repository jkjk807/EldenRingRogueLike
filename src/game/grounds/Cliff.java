package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DeathAction;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.GiantCrayfish;
import game.utils.FancyMessage;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class Cliff extends Ground {
    /**
     * Constructor.
     *
     */
    public Cliff() {
        super('+');
    }
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()){
            new Display().println(FancyMessage.YOU_DIED);
            new DeathAction().execute(location.getActor(), location.map());
        }

    }
}
