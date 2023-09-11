package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.*;
import game.map.*;
import game.utils.FancyMessage;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Lim Jing Kai
 *
 */
public class Application {
	public static GameMap stormVeilCastleGamemap;

	public static void main(String[] args) {




		WorldManager worldManager = new WorldManager(new Display(), new Limgrave(), new StormveilCastle(),new BossRoom(),new RoundtableHold(),new LakeOfRot());

		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		worldManager.run();
	}
}
