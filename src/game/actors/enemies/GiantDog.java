package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.weapons.IntrinsicDogSlamAttack;


/**
 * Class representing the GiantDog. Its intrinsic weapon is Area attack.
 * Created by:
 *
 * @author Lim Jing Kai
 */
public class GiantDog extends Enemy {
    /**
     * Constructor.
     *
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        addBehavior(999, new WanderBehaviour());
        addWeaponToInventory(new IntrinsicDogSlamAttack());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Action finalAction;
        finalAction = super.playTurn(actions, lastAction, map, display);
//        if(!this.isConscious()){
//            Location location=map.locationOf(this);
//            map.removeActor(this);
//            if killedByPlayer() == True{
//                runesEarned = Killed.getRuneReward(313, 1808);
//            }
//            return new DoNothingAction();
//        }
        return finalAction;
    }


}
