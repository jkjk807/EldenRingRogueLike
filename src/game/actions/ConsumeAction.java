package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FlaskOfCrimsonTears;
import game.utils.Status;

public class ConsumeAction extends Action {
    Actor player;
    FlaskOfCrimsonTears flask;
    public ConsumeAction(Actor target, FlaskOfCrimsonTears flask) {
        this.player = target;
        this.flask=flask;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        int consumableLeft=this.flask.getConsumable();
        String message="";
        if(consumableLeft==2){
            this.flask.consumed(actor);
            message="Consumed Flask of Crimson Tears, Item left: "+this.flask.getConsumable();

        } else if (consumableLeft==1) {
            this.flask.consumed(actor);
            actor.removeCapability(Status.HEALTH_RESTORED);
            message="Consumed Flask of Crimson Tears, Item left: "+this.flask.getConsumable();

        }
        else if (consumableLeft==0) {
            this.flask.consumed(actor);
            actor.removeCapability(Status.HEALTH_RESTORED);
            message="Consumed Flask of Crimson Tears is used out";

        }
        return message;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor  + " consume the Flask of Crimson Tears";
    }
}

