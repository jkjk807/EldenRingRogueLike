
# Elden Ring
This is a text-based “rogue-like” game. Rogue-like games are named after the first such program: a fantasy game named Rogue. They were very popular in the days before home computers were capable of elaborate graphics and still have a small but dedicated following. 

In this game, you will play as Tarnished (@) to explore The Lands Between, where the event of Elden Ring takes place! 


## Elden Ring Design Rationale


Requirement 1:
All five types of ground extended the abstract Ground class, all three types of enemy extended the Actor class. Since they share some common attributes and methods, it is logical to abstract these identities to avoid repetitions (DRY).
Heavy Skeletal Swordsman has a dependency on Piles of Bones. In this way, we removed multiple dependencies for the Heavy Skeletal Swordsman class on multiple classes. This way, only the Heavy Skeletal Swordsman class is able to create Piles of Bones. The Heavy Skeletal has an association with Grossmesser, it uses Grossmesser as its attribute and the Grossmesser inherits the abstract class WeaponItem. This way, the weapon can be more extensible since the weapon shares a similar attribute and also avoids code repetitions.
The abstract Ground class also has a dependency on the abstract Enemy. Since these enemies can only be created from their respective ground classes. Our approach also made the game more extensible, a new enemy could be easily added to the system by directly inheriting the abstract class Enemy.
The abstract class Enemy also has an association with Behavior and AttackAction class. This way an enemy could have 1 or many Behavior or AttackAction. The SingleAttack and SlamAttack inherit the abstract class Action to make it more maintainable since they share a similar attribute, more attack action could be added more easily, and this is the same for the behaviour classes. The AttackAction also has association with abstract class Actor and abstract class WeaponItem. This is due to each attack action if there is a presence of weapon will require a weapon item to target the actors.
In this implementation we followed the DRY principle by letting similar enemy extend to the enemy class which the Enemy class will have all the attribute an enemy will have. The pros of this implementation is that it is very easy to extend a new enemy class. The cons is that if there is a completely different enemy then we cannot extend from this class. The future extension of enemy can just extend the enemy class can call the super method.


Requirement 2: 
Class Killed is associated to Enemy. Killed is an attribute of an Enemy; an Enemy can either be Killed by another Enemy or the Player. Since it doesn’t matter if an Enemy Killed by another Enemy (the Killed enemy simply despawns), and if the Enemy is Killed by a Player, the Player should receive some number of Runes, it makes more sense to implement a class for when an Enemy is Killed (by an Enemy/Player), rather than a class such as “Died” for whenever an Enemy dies. 
Class Runes is associated to the Player. Runes has been implemented as an item with am integer value playerRunes, which is modified via RuneManager. Runes could have been designed as independent objects, but that would result in a lot of objects being generated every time an Enemy is Killed, and it would also result in the trading system to be extremely slow. 
Class RuneManager contains methods that allow the decrease and increase of playerRunes, which would occur during trading and killing enemies.
Trade class has been removed, and Sellable and Purchaseable classes have been created as per feedback from Assignment 1. Sellable and Purchaseable are interface classes for the Sell and Purchase classes.
Uchigatana and Great Knife are removed and not implemented as they are not required. Grossmesser and Club are associated to the Player, and extends from the abstract class WeaponItem. Both classes share similar attributes and methods, so extending them from the abstract class WeaponItem allows the reuse of otherwise repetitive code (DRY)

Requirement 3:
The Player class inherits the abstract class Actor since they have similar attributes. The Player class has an association with FlaskOfCrimsonTears since it is an attribute for Player and it cannot be dropped. The FlaskOFCrimsonTears also inherit the abstract Item class because it has similar attributes with Item class (DRY). The Player also has an association with Runes class as it is one of the Player attributes. The Player has a dependency on Consumable class which this class will be responsible to keep track of the status of FlaskOfCrimsonTears and perform the consume action. The pros about this implementation is that the implementation in code is relatively straight forward but it will be hard to extend more consumables in the future. But since this game has only one consumable, this way of implementation is used in the design.
The Player class implements the interface Resettable. In this way interface Resettable contains all the functions required for a game reset. The Player will be able to be reset in the game and any action which will be required to reset the game can also use this interface. So this creates a specialisation for this interface and allows extension to be made easier. Then the ResetManager has an association with interface Resettable, it will manage the Reset, it also has a dependency with EnemyDespawn so it can use this class to despawn the enemy.
The Action class is implemented as an abstract class to group the actions with similar attributes to reduce code repetition (DRY). The DeathAction has a dependency to DropRunes class and Resettable class, so that each time DeathAction is called it will use Resettable and the DropRunes class. The Rest class will also have a dependency with the Resettable class so that it can use Resettable class upon being called. This implementation will allow every action performed by Actors to refer to this abstract Action class. So, this makes a single responsibility for the Action class which follows the SOLID principle.
The reset function can be easily extended in the future in this way: The class that wants to to reset just implement the resettable interface and implement the reset function inside the interface. Inside the reset function just code out what attribute the class need to be reset. So eveytime the game reset, each classes that implements resettable will get reset. This way the reset function is very easily extended.




Requirement 5:

The East and West classes extend from the abstract class Ground. Since every Ground object will either be on the East or West side of the game map, this design is better than having East and West be attributes within every Ground class (DRY).

All the new Enemies, namely Skeletal Bandit, Giant Dog, and Giant Crayfish, follow the same design as their counterparts and extend from the abstract class Ground, and this shows that this approach does indeed make the game more extensible.

Each of the enemies with intrinsic slam attacks (the Giant Crab, Giant Dog, and Giant Crayfish) have their own slam attacks as weapons. This is because their slam attacks have different values.

