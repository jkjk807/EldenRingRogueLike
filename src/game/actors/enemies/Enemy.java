package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;
import game.actions.AreaAttackAction;
import game.actions.SingleAttackAction;
import game.actors.Player;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.reset.ResetManager;
import game.reset.Resettable;
import game.utils.RandomNumberGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Parent class representing the Player. It implements the Resettable interface.
 * It uses as a backbone to create enemy
 * Created by:
 *
 * @author Lim Jing Kai
 * Modified by:
 */
public abstract class Enemy extends Actor implements Resettable {
    private final Map<Integer, Behaviour> behaviours = new HashMap<>();
    int despawnProbability = 10;
    Location currentLocation;
    GameMap currentMap;

    /**
     * Constructor.
     *
     * @param name        Name to call the enemy in the UI
     * @param displayChar Character to represent the enemy in the UI
     * @param hitPoints   Enemy's starting number of hitpoints
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        ResetManager resetManager = ResetManager.getInstance();
        resetManager.registerResettable(this);

    }

    public int currentMaxHp() {
        return this.maxHitPoints;
    }

    /**
     * Add behaviour into hashmap.
     *
     * @param prio     Priority of the behaviour
     * @param behavior the behavior that wanted to be added
     */

    public void addBehavior(int prio, Behaviour behavior) {
        this.behaviours.put(prio, behavior);
    }


    /**
     * At each turn, select a valid action to perform.
     *
     * The enemy by default will have a follow behaviour and also an attack behavior if a player is nearby
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.currentMap = map;

        currentLocation = map.locationOf(this);
        Location here = map.locationOf(this);


        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();
                //Put a follow behavior if target is a player

                if (target instanceof Player) {
                    this.behaviours.put(2, new FollowBehaviour(target));
                }
                if (this.getClass() == target.getClass()) {
                    continue;
                }
                //Default behavior for enemmy is attack behaviour if theres a player nearby
                this.behaviours.put(1, new AttackBehaviour(target, exit.getName()));
            }
        }


        for (Behaviour behaviour : getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            //Enemy will be removed if not following a Player
            if (!(behaviour instanceof FollowBehaviour)) {
                int randomValue = RandomNumberGenerator.getRandomInt(100);
                if (randomValue < despawnProbability) {
                    map.removeActor(this);
                    return new DoNothingAction();
                }
            }
            //return the action from the behaviour
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {

        ActionList actions = new ActionList();


        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            if (!(otherActor.getWeaponInventory()).isEmpty() ) {
                WeaponItem weapon = otherActor.getWeaponInventory().get(0);
                if (weapon.hasCapability(Status.AREA_ATTACK)) {
                    //Weapon have a 50 per cent chance of using area attack
                    if(RandomNumberGenerator.getRandomInt(100)<50){
                        actions.add(new AreaAttackAction(weapon));}else{
                        actions.add(new SingleAttackAction(this, direction, weapon));
                    }

                }else{
                    actions.add(new SingleAttackAction(this, direction, weapon));
                }

            }
            else{
                actions.add(new SingleAttackAction(this, direction));
            }
        }

        return actions;
    }


    /**
     * Getter for CurrentMap
     */

    public GameMap getCurrentMap() {
        return currentMap;
    }

    /**
     * Getter for behaviours
     */
    public Map<Integer, Behaviour> getBehaviours() {
        return behaviours;
    }


    public void reset() {
        if (getCurrentMap() != null) {
            getCurrentMap().removeActor(this);
        }
    }
}

