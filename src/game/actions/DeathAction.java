package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;
import game.reset.ResetAction;
import game.utils.FancyMessage;
import game.utils.Status;

/**
 * An action executed if an actor is killed.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 */
public class DeathAction extends Action {
    private Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }
    public DeathAction() {

    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map    The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        ActionList dropActions = new ActionList();
        if (target instanceof Player) {
            new ResetAction().execute(target, map);

            return (FancyMessage.YOU_DIED);
        } else {
            if (!target.hasCapability(Status.RESPAWNABLE)) {
                map.removeActor(target);
                for (Item item : target.getItemInventory())
                    dropActions.add(item.getDropAction(target));
                for (WeaponItem weapon : target.getWeaponInventory())
                    dropActions.add(weapon.getDropAction(target));
                for (Action drop : dropActions)
                    drop.execute(target, map);

            }
            return target + " is killed";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        if (actor instanceof Player) {
            return (FancyMessage.YOU_DIED);
        }
        return ("deaaefgdjrhbetfgvbjnertofjtgnvbejrtsfgvbd");
//        return actor + " is killed.";
    }
}
