1) The tournament is organized as a single elimination tournament with third place playoff.
- Added three variables in class "Tournament" to record the top 4 ranking players

2) The application has two modes: tournament manager and tournament player. You can assume that the mode is selected when the application starts, with no authentication involved.
- Nothing to be done since this is implementation

3) The tournament manager uses the system to (1) add players, (2) run tournaments, and (3) display prizes and profits.
- Created a class called "Tournament_Manager" with three operations for each of the above 3

4) The tournament players use the system to (1) view the match list and (2) view the total player prizes.
- Created a class called "Tournament_Player" with two operations for each of the above 2

5) The app has an underlying database to save persistent information across runs (e.g., players in the system, status of ongoing tournaments).
- created a class called "Database" which is an external database containing the current and past historical data of previous tournaments

6) A player in the system is characterized by the following information:
	Name
	Unique alphanumeric username
	Numeric phone number
	A deck choice, from a list of deck options
- Created a class "Players" with the above attributes

7) The tournament manager can add a player to and remove a player from the system.
- manager can pass the parameter to the class called "Tournament" which will either add or remove the player from the Database

8) There can only be one ongoing tournament at any given time.
- Implementation part

9) To start a tournament:
	The tournament manager will enter the house cut.
	The tournament manager will enter the entry price.
	The tournament manager will enter all player usernames. For simplicity, let’s assume that there will be either 8 or 16 players in a tournament.
	When the tournament manager has entered the above information, the system will display, in addition to the player names, the potential prizes and profit, as calculated in the TourneyCalc app that you developed for Assignment 4. 		The tournament manager will then be able to double check the information and start the tournament.
- Manager will call the operations from the "start_Tournament" passing the house cut, entry price and usernames to the class "Tournament". In return, class "Tournament" calls the private function called "display_TourneyCalc" which will display the required info to double check

10) When there is no ongoing tournament, the player mode will show totals for every player in the system as a list sorted by total.
- players will have access to show prizes but sorting by different items will be part of implementation

11) When a tournament is ongoing, the player mode will show a match list. The match list displays a list of players paired with other players representing ongoing matches, matches ready to be played, and results from completed matches.
- players can call the function "view_matchList()" which will in return call the "show_matchList()" inside class "Match_List" showing the match list with required attributes

12) When a tournament is ongoing, the manager mode will also show a match list. In this case, however, the tournament manager will be able to:
	a) Start a match ready to be played by selecting it from the list. The system will then mark the game between the specified players as started.
	b) End an ongoing match and specify a result for it.
	c) End the tournament. If the tournament is ended early, money is refunded.
- Managers can call additional operations inside the "Match_List" class for the required task. Implementation will require this to be only accessible by the managers only

13) After a tournament is completed, prizes for the winning player, the second place player, and the third place player (who wins the third place playoff) will be recorded in the underlying database .  
- Function "record_FinalResults" has been created which will require the parameters of 1st, 2nd, 3rd player to be passed and recorded in database

14) After a tournament is completed, the house profit will also be recorded in the underlying database.
- Function "record_HouseProfit" with house cut $ amount being passed as parameter

15) When there is no ongoing tournament, the tournament manager can:
	a) View totals for every player in the system as a list sorted by total. From there, the manager can also view a list of the player’s individual prizes by selecting the player from the list.
	b) View the list of past house profits in chronological order and the total.
- This will be part of the implementation and not part of design

16) The User Interface (UI) must be intuitive and responsive.
- This will be part of the implementation and not part of design
