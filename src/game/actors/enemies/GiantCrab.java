package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.WanderBehaviour;
import game.weapons.IntrinsicSlamAttack;



/**
 * Class representing the GiantCrab. Its intrinsic weapon is Area attack.
 * Created by:
 *
 * @author Lim Jing Kai
 * Modified by: Aaron Leong Weng Hon
 */
public class GiantCrab extends Enemy {
    /**
     * Constructor.
     *
     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407 );
        addBehavior(999, new WanderBehaviour());
        addWeaponToInventory(new IntrinsicSlamAttack());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Action finalAction;
        finalAction = super.playTurn(actions, lastAction, map, display);
//        if(!this.isConscious()){
//            Location location=map.locationOf(this);
//            map.removeActor(this);
//            if killedByPlayer() == True{
//                runesEarned = Killed.getRuneReward(318, 4961);
//            }
//            return new DoNothingAction();
//        }
        return finalAction;
    }


}
