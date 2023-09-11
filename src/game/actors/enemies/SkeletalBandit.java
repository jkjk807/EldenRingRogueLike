package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;
import game.behaviours.WanderBehaviour;
import game.weapons.Scimitar;
/**
 * Class representing the SkeletalBandit. It carries a weapon Scimitar.
 *
 * Created by:
 * @author Aaron Leong Weng Hon
 * Modified by:
 */
public class SkeletalBandit extends Enemy {
    int counter=0;
    /**
     * Constructor.
     *
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184);
        this.addWeaponToInventory(new Scimitar());
        addBehavior(999, new WanderBehaviour());
        this.addCapability(Status.RESPAWNABLE);

    }

    /**
     * Return the Skeletal Bandit maximum HP.
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
            SkeletalBandit SB=this;
            Location location=map.locationOf(this);
            map.removeActor(this);
            //Add a piles of bone to the map after SB died
            map.addActor(new PilesOfBones(SB),location);
            return new DoNothingAction();
        }
        return finalAction;
    }
}
