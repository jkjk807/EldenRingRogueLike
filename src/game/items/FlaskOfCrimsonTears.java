package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.utils.Status;

/**
 * The class representiong Flask of  crimson tears which give player ability to heal
 *
 * crearted by:
 * @author Lim Jing Kai
 */
public class FlaskOfCrimsonTears extends Item {
    /**
     * Number of used left in the Flask of Crimson Tears
     */
    int consumable;

    /**
     * Maximum number of used left in the Flask of Crimson Tears
     */
    int maxConsumable=2;

    /**
     * Number of hp Flask of Crimson Tears can heal
     */
    int healHp=250;
    /**
     * Actor using the flask of crimson tears
     */
    Actor actor;


    /**
     * Constructor.
     *
     * @param actor Actor using the flask of crimson tears
     */
    public FlaskOfCrimsonTears(Actor actor) {
        super("Flask Of Crimson Tears", 'c', false);
        this.addCapability(Status.HEALTH_RESTORED);
        this.addAction(new ConsumeAction(actor,this));
        this.actor=actor;
        this.consumable=maxConsumable;
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {

    }

    /**
     * Getter for consumable
     *
     */
    public int getConsumable() {
        return consumable;
    }

    /**
     * Decrease of the numbers of use left in the Flask of Crimson tears
     *
     */
    public void consumed(Actor actor){
        consumable-=1;
        actor.heal(healHp);

    }

    /**
     * Refill the Flask of Crimson Tears to the maximum number of used
     *
     */
    public void refill(){
        consumable=maxConsumable;

    }


}

