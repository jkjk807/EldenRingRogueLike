package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class IntrinsicCrayFishSlamAttack extends WeaponItem {
    public IntrinsicCrayFishSlamAttack() {
        super("Crayfish Slam Attack", '*', 527, "Snip", 100);
        //set portable= false so that this become its intrinsic weapon
        super.portable=false;
        this.addCapability(Status.AREA_ATTACK);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}


}
