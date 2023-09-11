package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;
import game.behaviours.WanderBehaviour;
import game.weapons.Grossmesser;


/**
 * Class representing the HeavySkeletalSwordsman. It carry a weapon Grossmeser.
 *
 * Created by:
 * @author Lim Jing Kai
 * Modified by: Aaron Leong Weng Hon
 */
public class HeavySkeletalSwordsman extends Enemy {
    int despawnProbability=10;
    int counter=0;
    /**
     * Constructor.
     *
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.addWeaponToInventory(new Grossmesser());
        addBehavior(999, new WanderBehaviour());
        this.addCapability(Status.RESPAWNABLE);

    }

    /**
     * Return the Heavy Skeletal Swordsman maximum HP.
     *
     * @return  maximum HP
     */
    public int currentMaxHp(){
        return this.maxHitPoints;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Action finalAction;
        finalAction = super.playTurn(actions, lastAction, map,  display);
        counter+=1;

        if(!this.isConscious()){
            HeavySkeletalSwordsman HSS=this;
            Location location=map.locationOf(this);
            map.removeActor(this);
//            if killedByPlayer() == True{
//                runesEarned = Killed.getRuneReward(35,892);
//            }
            //Add a piles of bone to the map after HSS died
            map.addActor(new PilesOfBones(HSS),location);
            return new DoNothingAction();
        }
        return finalAction;
    }
}
