1.	The tournament is organized as a single elimination tournament with third place playoff.
Added tournament class and match class, with match class having designation of round: octofinal (for 16 players only), quarterfinal, semifinal, final, thirdplace.
2.	The application has two modes: tournament manager and tournament player. You can assume that the mode is selected when the application starts, with no authentication involved.
Not considered because does not affect design directly.
3.	The tournament manager uses the system to (1) add players, (2) run tournaments, and (3) display prizes and profits.
Added addPlayer, startTournament, startMatch, and displayTournamentPrizesProfits methods to TournamentManager class.
4.	The tournament players use the system to (1) view the match list and (2) view the total player prizes.
Added viewMatchList (TournamentID), viewTotalPlayerPrizes methods to Player class.
5.	The app has an underlying database to save persistent information across runs (e.g., players in the system, status of ongoing tournaments).
Not considered because does not affect design directly.
6.	A player in the system is characterized by the following information:
a.	Name
b.	Unique alphanumeric username
c.	Numeric phone number
d.	A deck choice, from a list of deck options
Added player attributes name, username, phone, and deck.
7.	The tournament manager can add a player to and remove a player from the system.
Added addPlayer and removePlayer methods to TournamentManager class.
8.	There can only be one ongoing tournament at any given time.
Restricted number of tournaments to 0 or 1.
9.	To start a tournament:
a.	The tournament manager will enter the house cut.
b.	The tournament manager will enter the entry price.
c.	The tournament manager will enter all player usernames. For simplicity, let’s assume that there will be either 8 or 16 players in a tournament.
Added house cut, entry price, and number of players to the tournament
c.	When the tournament manager has entered the above information, the system will display, in addition to the player names, the potential prizes and profit, as calculated in the TourneyCalc app that you developed for Assignment 4. The tournament manager will then be able to double check the information and start the tournament.
Not considered because does not affect design directly.
10.	When there is no ongoing tournament, the player mode will show totals for every player in the system as a list sorted by total.
Added viewTotalbyPlayer method to Player class
11.	When a tournament is ongoing, the player mode will show a match list. The match list displays a list of players paired with other players representing ongoing matches, matches ready to be played, and results from completed matches.
Added viewMatchList method to Player class
12.	When a tournament is ongoing, the manager mode will also show a match list. In this case, however, the tournament manager will be able to:
a.	Start a match ready to be played by selecting it from the list. The system will then mark the game between the specified players as started.
Added Started: Boolean attribute to Match object; added viewMatchList method to TournamentManager class.
b.	End an ongoing match and specify a result for it.
Added endMatch method.
c.	End the tournament. If the tournament is ended early, money is refunded.
Added awardOrRefund method to TournamentManager class
13.	After a tournament is completed, prizes for the winning player, the second place player, and the third place player (who wins the third place playoff) will be recorded in the underlying database.
Part of the awardOrRefund method, writes to totalPrizes attribute of Player
14.	After a tournament is completed, the house profit will also be recorded in the underlying database.
Part of the awardOrRefund method, writes to totalProfit attribute of House class.
15.	When there is no ongoing tournament, the tournament manager can:
a.	View totals for every player in the system as a list sorted by total. From there, the manager can also view a list of the player’s individual prizes by selecting the player from the list.
Added viewTotalbyPlayer method to TournamentManager class
Added viewPlayerPrizes method to TournamentManager class
b.	View the list of past house profits in chronological order and the total.
Added viewProfits method to House class, that looks up profits for each tournament using tournamentID
16.	The User Interface (UI) must be intuitive and responsive.
Not considered because does not affect design directly.

