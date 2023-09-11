package game.actors.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.WanderBehaviour;
import game.weapons.IntrinsicDogSlamAttack;

public class Dog extends Enemy {
    /**
     * Constructor.
     *
     */
    public Dog() {
        super("Dog", 'a', 104);
        addBehavior(999, new WanderBehaviour());
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
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }


}
