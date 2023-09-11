package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class IntrinsicSlamAttack extends WeaponItem {
    public IntrinsicSlamAttack() {
        super("Slam Attack", '*', 208, "Boom", 90);
        //set portable= false so that this become its intrinsic weapon
        super.portable=false;
        this.addCapability(Status.AREA_ATTACK);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}


}
