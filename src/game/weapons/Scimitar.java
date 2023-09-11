package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Scimitar extends WeaponItem {
    /**
     * Constructor
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "ting", 88);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

}

