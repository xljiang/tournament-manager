Design Information
===================


This is the design information for CS6300 Assignment 5. The **design.pdf** file is the class UML diagram for the design, and here are the detail descriptions.

----------


Requirements and Design Descriptions
-------------

1. The tournament is organized as a single elimination tournament with third place playoff.
> Not considered because it does not affect the design directly.

2. The application has two modes: tournament manager and tournament player. You can assume that the mode is selected when the application starts, with no authentication involved.
> To realize this requirement,  the class **Manager** and class **Player** were added to the design, representing *tournament manager* mode and *tournament player* mode, respectively. 
> 
> Also, a **Tournament** class and a **OngoingTournament** subclass were added.

3. The tournament manager uses the system to (1) add players, (2) run tournaments, and (3) display prizes and profits.
> (1): see realization of requirement 7.
> (2) & (3): see realization of requirement 9.

4.  The tournament players use the system to (1) view the match list and (2) view the total player prizes.
> Please see the realization of requirement 10 & 11.

5.  The app has an underlying database to save persistent information across runs (e.g., players in the system, status of ongoing tournaments).
> A database was presented in the UML diagram. However, this is just a represent, I didn't actually design database in this assignment.

6.  A player in the system is characterized by the following information:
(a) *Name*
(b) Unique alphanumeric *username*
(c) Numeric *phone number*
(d) A *deck choice*, from a list of deck options
> Attributes `name`, `username`, `phoneNumber` and `deckChoice` were added to the **Player** class. Please refer to the UML diagram for the types of these attributes. Especially, I defined a **DeckOption** class represent an option that `deckChoice` could be.

7.  The tournament manager can add a player to and remove a player from the system.
> Added `addPlayer()` and `deletePlayer()` operations to the **Manager** class. For convenience, the parameters for these two method can be a **Player** or a *Player's username*. Also added association between **Manager** and **Player** class.

8.  There can only be one ongoing tournament at any given time.
> In the association between the **Manager** class and the **OngoingTournament** class, set the multiplicities of the **OngoingTournament** to 0..1 (0 or 1).

9.  To *start a tournament*:
(a) The tournament manager will enter the house cut.
(b) The tournament manager will enter the entry price.
(c) The tournament manager will enter all player usernames. For simplicity, let’s assume that there will be either 8 or 16 players in a tournament.
(d) When the tournament manager has entered the above information, the system will display, in addition to the player names, the potential prizes and profit, as calculated in the TourneyCalc app that you developed for Assignment 4. The tournament manager will then be able to double check the information and start the tournament.
> In my design, the **Manager** start an **OngoingTournament** to fullfill this requirement. The corresponding operation `startTournament(usernames:List<String>, houseCut:Double, entryPrice:Money)` was added in the **Manager** class. This operation will return an **OngoingTournament** class, and the input is shown intuitively in the method itself. I didn't specify how many players in my design at this level.
> 
> Added `displayCurrentPrizes()` and `displayCurrentProfit()` operations to display the current ongoing tournament's prizes and profit, respectively.

10.  When there is no ongoing tournament, the player mode will show totals for every player in the system as a list sorted by total.
> Added an operation `viewPlayerSortedByList()` to the **Player** class. This operation need to inquire database, so I didn't add other detail of this method such as parameters and return type.

11.  When a tournament is ongoing, the player mode will show a match list. The match list displays a list of players paired with other players representing ongoing matches, matches ready to be played, and results from completed matches.
> Added an operation `viewMatchList()` to the **Player** class. This operation need to *use* the **OngoingTournament** class.

12.  When a tournament is ongoing, the manager mode will also show a match list. In this case, however, the tournament manager will be able to:
(a) Start a match ready to be played by selecting it from the list. The system will  then mark the game between the specified players as started.
(b) End an ongoing match and specify a result for it.
(c) End the tournament. If the tournament is ended early, money is refunded.
> Also added an operation `viewMatchList()` to the **Manager** class. This operation, together with `displayCurrentPrizes()`and `displayCurrentProfit()` methods, need to *use* the **OngoingTournament** class. The `viewMatchList()` method is essentially the same as the method in the **Player** class, these may further be combined , I didn't design here.
> 
> **Match** class was designed to have following attributes: a `matchStatus`, two players `player1`, `player2`, and match result `result`. The relationship between **Tournament** and **Match** is 1 to many aggregation.
> 
> The **Manager** also have operations `startMatch()` and `endMatch()` to fulfill this requirement. The `endMatch()` operation will return the **MatchResult**.
> 
> `issueRefund(Tournament):Money` operation is defined in the **Manager** class to issue a refund to the terminated tournament. `isCompleted()` operation in the **Tournament** class is to check if the tournament is finished.

13.  After a tournament is completed, prizes for the winning player, the second place player, and the third place player (who wins the third place playoff) will be recorded in the underlying database .  
> Prizes were designed to be calculated by the **TourneyCalc** class. An operation `recordPrizesToDB()` was added to the **Tournament** class to fulfill this requirement.

14.  After a tournament is completed, the house profit will also be recorded in the underlying database.
> Added operation `recordHouseProfitToDB(endTime:Date, houseProfit:Money)` to fulfill this requirement. The `endTime` need to be recored because in requirement 16, we need to view past house profits chronologically.

15.  When there is no ongoing tournament, the tournament manager can:
(a) View totals for every player in the system as a list sorted by total. From there, the manager can also view a list of the player’s individual prizes by selecting the player from the list.
(b) View the list of past house profits in chronological order and the total.
> Added an operation `viewPlayerSortedByList()` to the **Manager** class. This operation is same as that described in requirement 10. May combine them later. Also added an operation `viewPlayerPrizes(Player)` to view a list of the player's individual prizes.
> 
> Added operation `viewPastHouseProfits()`to the **Manager** class. This operation also need to inquire database. The database should already have profit history with tournament date as designed in requirement 14.

16.  The User Interface (UI) must be intuitive and responsive.
> Not considered at this stage of design.



----------


Additional Design Information
-------------------

###More About Classes
1. Tournament
> **Tournament** class has the following attributes: `tourneyId`, `startTime:Date`, `endTime:Date`, `players:List<Player>`, `matches:List<Match>`, `houseProfit:Money`, `prizes:List<Prize>`, and `totalPrizesAmount:Money`.
> 
> The subclass **OngoingTournament** has two more attributes: `houseCut:Double` and `entryPrice:Money`. Since these two attributes is not useful after a tournament is ended, so I design such ongoing tournament as a subclass rather than a ongoing status in the **Tournament** class.

2.  Player Class
> Except described in requirement 6, **Player** class also has the following attributes: `total:Money`(the total money this player has), `match:Match` (which match this player is playing); and an operation`isInMatch():Boolean`, which will return true if the player is playing in a match or false if not.

3.  Prize Class
> This class uses enumeration **PrizeType** to present different price types (firstPrize, second, and third), and has a `prizeValue` for each prize. Each tournament has 3 prizes.

4.  Match Class
> **Match** class was designed to have following attributes: a `matchStatus`, two players `player1`, `player2`, and match result `result`. This class use enumeration **MatchStatus** to represent different status of the match (ongoing, ready to be played and completed). 
> 
> The result is wrapped in a **MatchResult** class, which simply define the winner and the looser.

###More About Relations
> All clearly shown in the diagram.

###More About View
> View in this design is deeply hidden in some classes's operations. In the future, may use MVC design pattern, and view models will be specified.

###More About Database
> Since it's not required, here I only show a diagram of database, with **Manager** class point to it (use it) with dash line. The database may also be read/wrote by **Player** class, **Tournament** class, etc.