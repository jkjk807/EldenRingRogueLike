package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

import game.behaviours.WanderBehaviour;



/**
 * Class representing the LoneWolf
 *
 * Created by:
 * @author Lim Jing Kai
 * Modified by: Aaron Leong Weng Hon
 *
 */
public class LoneWolf extends Enemy {


    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        addBehavior(999,new WanderBehaviour());
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
        finalAction = super.playTurn(actions, lastAction, map,  display);
//        if(!this.isConscious()){
//            Location location=map.locationOf(this);
//            map.removeActor(this);
//            if killedByPlayer() == True{
//                runesEarned = Killed.getRuneReward(55, 1470);
//            }
//            return new DoNothingAction();
//        }
        return finalAction;


    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}
