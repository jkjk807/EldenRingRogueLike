package game.reset;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {
    private List<Resettable> resettables;
    private static ResetManager instance;

    /**
     * Constructor
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }

    /**
     * Go through the resettable list and reset everything in the resettable
     *
     */
    public void run() {
        for (Resettable resettable : resettables) {
            resettable.reset();
        }
    }
    /**
     * Get the instance of the reset manager from other class
     *
     * @return instance of reset manager
     */
    public static ResetManager getInstance() {
        if (instance == null) {
            instance = new ResetManager();
        }
        return instance;
    }
    /**
     * Register a resettable class into the resettable
     *
     */
    public void registerResettable(Resettable resettable) {
        this.resettables.add(resettable);
    }
    /**
     * Remove a resettable from the resettable list
     *
     */
    public void removeResettable(Resettable resettable) {
        this.resettables.remove(resettable);
    }
}
