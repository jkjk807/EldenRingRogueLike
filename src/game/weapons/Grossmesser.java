package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;
/**
 * A simple weapon that can be used to attack the enemy. it has special ability of area attaxck
 * It deals 115 damage with 85% hit rate
 * Created by:
 * @author Lim Jing Kai
 * Modified by:
 *
 */
public class Grossmesser extends WeaponItem {
    /**
     * Constructor
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "psss", 85);
        this.addCapability(Status.AREA_ATTACK);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

}

