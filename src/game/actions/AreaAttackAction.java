package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;
/**
 * An Area Attack Action to attack another Actor.
 * Created by:
 * @author Lim Jing Kai
 * Modified by:
 *
 */
public class AreaAttackAction extends Action {



    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    public AreaAttackAction(Weapon weapon) {

        this.weapon = weapon;
    }
    /**
     * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
     * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
     *
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return the result of the attack, e.g. whether the target is killed, etc.
     * @see DeathAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result="";
        for(Exit exit:map.locationOf(actor).getExits()){
            if(exit.getDestination().containsAnActor()){
                Actor target=exit.getDestination().getActor();
                if (weapon == null) {
                    weapon = actor.getIntrinsicWeapon();
                }
                if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                    result+= actor + " misses " + target + ".\n";
                }
                int damage = weapon.damage();
                result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.\n";
                target.hurt(damage);
                if (!target.isConscious()) {
                    result += new DeathAction(actor).execute(target, map);
                }
            }
        }

        return result;
    }

    /**
     * Describes which target the actor is attacking with which weapon
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " performed spinning attack " + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}
