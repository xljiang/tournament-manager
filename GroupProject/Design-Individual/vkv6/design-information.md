
           Design Information Document
1.* The tournament is organized as a single elimination tournament with third place turnoff.*
*2.*The application has 2 modes:tournament manager and tournament player.*

I have used StarUML tool to draw the class diagrams.
To realize these requirements, I first identified the nouns from the sentences and designed them as classes.
Nouns: 
       Tournament
       Tournament manager
       Tournament player.
       Match
so i first created 4 classes Tournament,Manager,Player,Match

*3. The Tournament manager uses the system to
   (1)add players (2)run tournaments(3)display prizes and profits*

I first identified these as action verbs and hence decided to add them as operations in the manager class
 
(1)addNewplayer(p1:Player):void where p1 is the instance of the class Player . The return type of the operation is  set as void.
(2)runTournament(T:Tournament):void where T is an instance of the class tournament .The return type of the opeartion is set as void.
(3) findProfit(tournament_name:Tournament):number Takes a particular tournamentname as the parameter and returns a number .
(4)findPrize(name:Player,tournament_name:Tournament):number
takes a playername and a tournament name as parameters and return the prize got by the player as a number .

*4.The tournament players use the system to (1)View the match list(2) view the total player prizes.*

In the player class, i added the following operations as i identified them to be action verbs.
(1)find_matchlist(match_team:Match,match_date:match):list 
displays the list of players ,date of match from the match class.
(2) display_totalprize(name:Player):number
displays the total prize won by a particular player.

*5. The app has an underlying database to save persistent information across runs (e.g players in the system,status of ongoing tournament*

Player is already represented in the class diagram as a class.
I considered a enumeration called Tournament_status which comprises of 2 enumeration literals:ongoing and not ongoing
Not ongoing could comprise of completed tournament or tournment to be held in future
ongoing is a tournament currently doing on.
This type depends on the tournament date attribute and can be inferred based on the tournament date.

*6.A Player is characterized by the following information: Name,Unique Username, Numeric phone number,Deckchoice*

I have placed all these 4 as attributes of the Player class. 
Name : string , Username:string,Phonenumber:number
deckchoice:number

*7. The tournament manager can add a player or remove a player from the system.*

For this requirement 2 operations are added to the manager class.
addNewplayer(p1:Player):void
A new player instance is added to the player class
deletePlayer(Username:Player):P2
A Player with a unique Username is specified for deletion and the whole instance of that particular player is deleted from the system.

*8.There can be only one ongoing tournament at a given time.*

I have represented this as a multiplicity at the relationship to tournament class from the other classes.

*9.To start tournament, manager enters the housecut, entry price, all player usernames(8 or 16)
After entering the above information , system displays playernames, potential prizes and profits*

In the manager class , i added the attributes for housecut as string ,entryprice as string, Player usernames as a arraylist which will accept 8 player usernames.

Then i added operations in the manager class to display the player names taking playerusername as the input parameter. and returning the player name as string.
displayPlayername(playerusername: player):string

*10. when no ongoing tournament , the player will show totals for every player in the system as a list sorted by total.*

In the tournament class the tournament date is checked and the tstatus of the tournament if it is not ongoing then,
the 
operation in the player class will show the totals of every player . It will also sort the player list by total.

*
11. When tournament is ongoing, player will show a match list. this match list displays list of players representing ongoing matches, matches ready to be played, results of completed matches.
*

In the match class i have added a attribute as type_status which is of a enumeration type Match_status which takes the literals as completed, ongoing , readytoplay.
The find_matchlist(.....) opeartion from the player class will display the match list based on the type_status of the matches.

*12. When tournament is ongoing, manager also shows a match list.The manager will be able to (a) start the match ready to be played by selecting it from the list. then mark the game between the specified players as started.
(b)end an ongoing match and specify its result
(c)end the tournament.
*

I have added operations to the manager class as follows:
startMatch(tstatus:Tournament,match_num:Match):void
endMatch(tstatus:Tournament, match_num:match):string
endTournament(tournament_name:Tournament):void

*13: After tournament is completed, prizes are given for winning player,second place player, third place player . It will be recorded in the database.
*

I have added the following attributes to the tournament class :
firstplaceplayer:string
secondplaceplayer:string
thirdplaceplayer:string

Also i have added a operation to this class called allot_prizes(Username:Player):void to allot the 3 prizes to the players using their unique usernames.

*14. After tournament completes , the house profit will be recorded.
*
I have added a attribute houseprofit and  a operation store_houseprofit():void to the tournament class .

*15. When no ongoing tournament , the manager can view totals for every player , the manager can view a list of the player's individual prizes by selecting player from the list.
Also view the past house profits in chronological order and the total*


I have added the following operations to the manager class.
view_totals(......):number
viewindividualprizes(Username:Player):number
view_houseprofits():list


*16. The User Interface(UI) must be intuitive and responsive.*
Not considered because it does not affect the design directly



I have used the following relationship notations in my class diagram.
Dependency : manager -----> Player and manager-----> Tournament classes
Association : Player and match , Player and tournament
Generalization : Match is a subclass of tournament.








