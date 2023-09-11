package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.grounds.RodWater;
import game.items.FlaskOfCrimsonTears;
import game.reset.ResetManager;

import game.weapons.Club;
import game.reset.Resettable;
import game.utils.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by: Lim Jing Kai
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();
	private List<Location> siteOfLostGraceLocation = new ArrayList<>();
	;
	private Location spawnLocation;
	private Location currentLocation;
	private GameMap map;
	private int flaskOfCrimsonTearsConsumables;

	private int counter = 0;
	private int rotCounter=0;


	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addWeaponToInventory(new Club());
		this.addItemToInventory(new FlaskOfCrimsonTears(this));
		ResetManager resetManager = ResetManager.getInstance();
		resetManager.registerResettable(this);

	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		this.map = map;
		//If the actor has rotting capability, it will rot for 3 turns
		if(this.hasCapability(Status.ROTTING)){
			this.hurt(10);
			rotCounter+=1;
			if(rotCounter==3){
				this.removeCapability(Status.ROTTING);
				rotCounter=0;
			}


		}

		if (counter == 1) {
			spawnLocation = map.locationOf(this);
		}
		this.currentLocation = map.locationOf(this);

		if(!(this.currentLocation.getGround() instanceof RodWater)){
			this.removeCapability(Status.ROTTING);

		}

		// Handle multi-turn Actions
		for(Item item:this.getItemInventory()){
			if(item instanceof FlaskOfCrimsonTears){
				this.flaskOfCrimsonTearsConsumables=((FlaskOfCrimsonTears)item).getConsumable();
			}
		}

		FlaskOfCrimsonTears flask = null;
		display.println("Health: " + printHp());
		display.println("FlaskOfCrimsonTears left: "+ String.valueOf(this.flaskOfCrimsonTearsConsumables));


		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		counter += 1;

        // return/print the console menu
        return menu.showMenu(this, actions, display);


	}

	/**
	 * Return the maximum hitpoint of the player.
	 *
	 * @return max HP of player
	 */
	public int getMaxPoints() {
		return this.maxHitPoints;
	}

	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(11, "punch", 95);
	}


	/**
	 * Add the location of Site of lost grace visited.
	 *
	 */
	public void registerSiteOfLostGrace(Location location) {
		this.siteOfLostGraceLocation.add(location);
	}

	/**
	 * Return the location of the first site of lost grace visited
	 *
	 * @return if there are visited site of lost grace then return the first one visited else return null
	 */
	public Location getFirstStep() {
		if (this.siteOfLostGraceLocation.isEmpty()) {
			return null;
		} else {
			return this.siteOfLostGraceLocation.get(0);
		}
	}

	/**
	 * Getter for player current map
	 *
	 */
	public GameMap getMap() {
		return this.map;
	}

	@Override
	public void reset() {
		//If Player is resting then remove RESTING capability
		if (this.hasCapability(Status.RESTING)) {
			this.removeCapability(Status.RESTING);
			//If the player is dead then return it to the location of the last site of lost grace visited else return it to the spawn location
		} else {
			if (this.getFirstStep() == null) {
				map.moveActor(this, spawnLocation);

			} else {
				map.moveActor(this, this.getFirstStep());
			}
		}
		//reset player max hp and reset flask of crimson tears
		this.resetMaxHp(this.getMaxPoints());
		for (Item item : this.getItemInventory()) {
			if (item instanceof FlaskOfCrimsonTears) {
				((FlaskOfCrimsonTears) item).refill();
			}
		}

	}
}

