# Use Case Model

*This is the template for your use case model. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: Team50

## 1 Use Case Diagram

![Image]( usecasediagram_team50.png)


*This section should contain a use case diagram with all the actors and use cases for the system, suitably connected.*

## 2 Use Case Descriptions

*For each use case in the use case diagram, this section should contain a description, with the following elements:*
***Use case 1 : Manage Tournament dates***
***Use case description*:** This use case describes how the manager manages the tournaments , by date schedule. Tournaments are categorized as ongoing and completed.
***Actors*** : Manager
***Preconditions:*** Manager announces the start date of Tournament
***Post conditions:*** When the tournament ends , that tournament is included in the list of completed tournaments
*Scenarios*
***Normal course:*** The tournament is started as per a planned schedule.
***Alternate course:*** The tournament dates may have to be altered
***Exceptional course*:** The tournament may be cancelled.
***Stakeholders:***   Players
***Trigger condition*:**  start tournament

***Use case 2 : Organize Match dates***
***Use case description*:** This use case describes how the manager organizes the matches , by date schedule. Matches are categorized as ongoing , ready to be played and completed.
***Actors*** : Manager
***Preconditions:*** Manager announces the start date of match
***Post conditions:*** When the match ends , that match is included in the list of completed matches. 
*Scenarios*
***Normal course:*** The match is started as per a planned schedule.
***Alternate course:*** The match dates may have to be altered
***Exceptional course*:** The match may be cancelled.
***Stakeholders:***   Players
***Trigger condition*:**  start tournament 

***Use case 3: Add Players***
***Use case description*:** This use case describes how the manager adds players to Tournaments after a player confirms.
***Actors*** : Manager ,Players
***Preconditions:*** Manager announces the start date of Tournament, 
Player has registered for tournaments.
 Player gives confirmation about his /her availability for the tournament matches.
***Post conditions:*** New player details are added .
*Scenarios*
***Normal course:*** The Player details are added to a tournament.
***Alternate course:*** New player details are recorded or existing details are modified.
***Exceptional course*:** If no player details are available , the manager will have to make new arrangements.
***Stakeholders:***   manager ,Players
***Trigger condition*:** Player details need to be present to add them to a tournament.

**Use case 4: Delete Player details**
***Use case description*:** This use case describes how the manager  deletes the player details if the player withdraws from a tournament .
***Actors*** : Manager ,Players
***Preconditions:*** Player details are previously added  .
***Post conditions:*** After confirmation for deletion, the particular player details are deleted.
****Scenarios**
***Normal course:*** The Player details are deleted from a tournament.
***Alternate course:*** 
***Exceptional course*:** 
***Stakeholders:***   manager ,Players
***Trigger condition*:** Player details need to be present to delete them from a tournament.
 
 **Use case 5 : View  Player prizes**
***Use case description*:** This use case describes how the manager , players can view the information about the player and the prizes won by them. 
***Actors*** : Manager ,Players
**Preconditions:**Enter the player name whose prize details  are to be displayed. 
***Post conditions:*** Player prize details for the particular  player name  are viewed .
****Scenarios**
***Normal course:*** The Player prize details are displayed  for a particular player.
***Alternate course:*** The player prize details are displayed for a particular player for a specific tournament .
***Exceptional course*:** 
***Stakeholders:***   manager ,Players
***Trigger condition*:** Player name should be entered correctly.

**Use case 6: Issue Refund**
***Use case description*:** This use case describes how the manager issues a refund of money for a cancelled tournament.
***Actors*** : Manager 
***Preconditions:*** enter tournament name and year and check if tournament status is cancelled. 
***Post conditions:*** refund details are sent.
****Scenarios**
***Normal course:*** The refund money amount is calculated and refunded 
***Alternate course:*** 
***Exceptional course*:** 
***Stakeholders:***   manager 
***Trigger condition*:** Tournament  name should be entered correctly. Tournament status is cancelled.

Use case 7: View Match list
***Use case description*:** This use case describes how the manager and the players can view the match list for a particular tournament.
***Actors*** : Manager ,Players
***Preconditions:*** enter tournament name and year 
***Post conditions:*** Match list details are displayed.
****Scenarios**
***Normal course:*** The match list details for a particular tournament are displayed.
***Alternate course:*** The match list details for a  particular player is displayed by entering the player name and tournament name, year.
***Exceptional course*:** 
***Stakeholders:***   manager ,players
***Trigger condition*:** Tournament  name, year should be entered correctly. 

Use case 8: Display current prizes
***Use case description*:** This use case describes how the manager  can 
view the current prizes information for a  particular player 
***Actors*** : Manager ,Players
***Preconditions:*** enter current / ongoing  tournament name , player name 
***Post conditions:*** Current prizes information for a  particular player are displayed.
****Scenarios**
***Normal course:*** The prizes information for the current tournament for a particular player is displayed. 
***Alternate course:*** 
***Exceptional course*:** 
***Stakeholders:*** players
***Trigger condition*:** Tournament name , player name should be entered.


Use case 9: View players sorted by total
***Use case description*:** This use case describes how the manager  can 
view the Players names with the total of prizes won by them. They are sorted in ascending  or  descending order of the total.
***Actors*** : Manager 
***Preconditions:*** enter a tournament name
**Post conditions** :Total prizes information for all the players are displayed in ascending or descending order.
**Scenarios**
***Normal course:*** The prizes information for the current tournament for all the  players is displayed. 
***Alternate course:*** 
***Exceptional course*:** 
***Stakeholders:***
***Trigger condition*:** Tournament name  should be entered. sorting order should be specified.
