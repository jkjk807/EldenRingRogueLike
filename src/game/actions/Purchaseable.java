package actions;

public interface Purchaseable {
/*
    *//**
     * Removes weapon from Actor's inventory and updates their rune according to the weapon's selling price
     * @param seller Actor buying the weapon
     *//*
    void purchase(Actor buyer);

    *//**
     * Returns weapon selling price
     * @return weapon selling price
     *//*
    int getPurchasePrice();

    *//**
     * Check if there is a trader nearby.
     * @param currentLocation
     * @param actor
     *//*
    default boolean canPurchase(Location currentLocation, Actor actor) {
        boolean canPurchase = true;
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