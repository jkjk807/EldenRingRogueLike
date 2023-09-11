package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.weapons.IntrinsicCrayFishSlamAttack;


/**
 * Class representing the GiantCrayfish. Its intrinsic weapon is Area attack.
 * Created by:
 *
 * @author Aaron Leong Weng Hon
 */
public class GiantCrayfish extends Enemy {
    /**
     * Constructor.
     *
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
        addBehavior(999, new WanderBehaviour());
        addWeaponToInventory(new IntrinsicCrayFishSlamAttack());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Action finalAction;
        finalAction = super.playTurn(actions, lastAction, map, display);
        return finalAction;
    }


}
