package actions;

public interface Sellable {
/*
    *//**
     * Removes weapon from Actor's inventory and updates their rune according to the weapon's selling price
     * @param seller Actor selling the weapon
     *//*
    void sell(Actor seller);

    *//**
     * Returns weapon selling price
     * @return weapon selling price
     *//*
    int getSellingPrice();

    *//**
     * Check if there is a trader nearby.
     * @param currentLocation
     * @param actor
     *//*
    default boolean canSell(Location currentLocation, Actor actor) {
        boolean canSell = true;
        // Any actor with CANTRADE is a trader
        if(actor.hasCapability(Capability.CANTRADE)){
            // Attempt to get at least 1 trader to enable trader
            for (Exit exit: currentLocation.getExits()){
                Location exitLoc = exit.getDestination();
                if(exitLoc.containsAnActor() && exitLoc.getActor().hasCapability(Capability.CANTRADE)){
                    return canSell;
                }
            }
        }
        canSell = false;
        return canSell;
    }*/
}