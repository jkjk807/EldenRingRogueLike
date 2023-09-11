package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;
import game.actions.AreaAttackAction;
import game.actions.SingleAttackAction;
/**
 * Class representing the Attack Behaviour
 *
 * The Attack Behaviour is used my NPC to use the Attack and Area Attack action
 *
 * Created by:
 * @author Lim Jing Kai
 * Modified by:
 *
 */
public class AttackBehaviour implements Behaviour {
    Actor target;
    String direction;

    /**
     * Constructor.
     *
     * @param target    Target actor that is gonna be attacked
     * @param direction Direction of the target actor
     */
    public AttackBehaviour(Actor target, String direction) {
        this.target = target;
        this.direction = direction;

    }
    /**
     * Determine which type of Attack Action to be returned if possisble.
     * If no attack action is possible, returns null.
     *
     * @param actor the Actor enacting the behaviour
     * @param map   the map that actor is currently on
     * @return an Action, or null if no AttackAction is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            WeaponItem weapon;

            if (!(actor.getWeaponInventory().isEmpty())) {
                weapon = actor.getWeaponInventory().get(0);
                if (weapon.hasCapability(Status.AREA_ATTACK)) {
                    //Uses AreaAttack action if weapon if capable of doing area attack
                    return new AreaAttackAction(weapon);
                } else {
                    return new SingleAttackAction(target, direction, weapon);
                }
            } else {
                //Uses intrinsic weapon if there is no weapon
                return new SingleAttackAction(target, direction);
            }
        }


        return null;
    }

}
