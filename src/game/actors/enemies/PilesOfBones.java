package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Class representing the PilesOfBones
 *
 * Created by:
 * @author Lim Jing Kai
 * Modified by:
 *
 */
public class PilesOfBones extends Enemy {
    int counter=0;
    HeavySkeletalSwordsman HSS;
    SkeletalBandit SB;
    Actor actor;
    public PilesOfBones(HeavySkeletalSwordsman actor) {
        super("Piles of Bones", 'X', 1);
        HSS=actor;
        this.actor=actor;
    }
    public PilesOfBones(SkeletalBandit actor) {
        super("Piles of Bones", 'X', 1);
        SB=actor;
        this.actor=actor;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        counter+=1;
        System.out.println(counter);
        //if not hit after 3 turns, HSS will respawn
        ActionList dropActions = new ActionList();
        if (counter>=3){
            map.removeActor(this);

            map.addActor(actor, HSS.currentLocation);
            //reset HSS status
            actor.heal(10000);
        }
        return new DoNothingAction();
    }


}
