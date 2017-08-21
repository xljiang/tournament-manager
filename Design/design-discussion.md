Design Discussion
===================
> **Note:**
> Individual designs are listed alphabetically by author's gtID.

### Design 1

![](https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Design-Team/design1.jpg)

Author: Katja Krivoruchko

This design contains all the necessary classes to create the Tourney Manager app, including Tournament Manager, Tournament, House, Player, PlayerList, Match, and Matchlist. It shows relationships between classes, multiplicity for many of the relationships, as well as utility classes.

The pros of the design are:

1. All the required classes for the given set of Requirements are defined with attributes and names.
2. The dependency, aggregation and association relationships are well  represented between the classes 
3. Creative design of the Round utility.

The cons of the design are:

1. Database integration is not outlined.
2. TourneyCalc class from assignment 4 is not part of the diagram.
3. Functionality that is used by both Manager and Player could be part of one common class.
4. Need two more methods in Tournament class: record prize, house profit to database

### Design 2

![](https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Design-Team/design2.jpg)

Author: Sabih Fawad

This intuitive design addresses all the requirements of the application, and contains all the classes listed in Design 2, as well as the Database class for writing the results to a database.

The pros of the design are:

1. All the required classes for the given set of Requirements are defined with attributes and names, and multiplicity is clearly outlined.
2. Database class clearly shows how the tournament and player data is persisted between tournaments.

The cons of the design are:

1. All the relationships are set as association relationship; Match and MatchList could be aggregation relationships. 
2. Some of the classes (Tournament_Player,  Tournament _Manager) do not have any attributes, only methods.
3. Some functions in the Tournament class should be in Tournament_Manager class, such as add/remove player, start/end tournament.
4. Tournament _Player, Players , Tournament _Players are classes with some redundant attributes and methods. These can be moved to a superclass.

### Design 3

![](https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Design-Team/design3.jpg)

Author: Vidya Kizhakke Veetil

This comprehensive design also meets all the Requirements of the assignment. 

The pros of the design are:

1. Clean layout and easy to follow.
2. Good use of labels/functions that are performing the operations.
3. Good use of utility classes, although they could have been connected to show their accurate relation.

The cons of the design are:

1.  Missing database integration.
2.  Missing link between Match and Manager.
3.  Deck could have been a separate class.
4.  Relationship between tournament and players should be M:N (many players can participate in a tournament and a player can participate in many tournaments). 


### Design 4

![](https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Design-Team/design4.jpg)

Author: Xiaolu Jiang

This comprehensive design is the one the team selected as the base of our team design.

The pros of the design are:

1. Clear, easy-to-read comprehensive design includes all classes, relationships, and multiplicity.
2. Good use of utility classes.
3. Good segregation of methods between classes.

The cons of the design are:

1. Database integration requires relationship between Tournament class and the database.
2. Need relationship class between TourneyCal and Manager class.
3. Record first, second, and third prize winner names in Tournament class.  

###Team Design

![](https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Design-Team/team.jpg)

Team design stems from Design 4, with several changes outlined below. Design 4 was the most comprehensive and clear; thus it was selected as base of the team design.

The main commonalities between the team design and individual ones are the presence of Tournament, Player, Manager, and Match classes.

The main differences revolve around 1) persistence of the tournament info (in a database class in two of the four designs and not addressed in the other two designs) and 2) relationship types (association or more specific types like aggregation). Additionally, some individual design included more or fewer classes; however, each of the designs covered all the Requirements. 

These design decisions were made in order to 1) explicitly meet the requirement of persisting tournament data between application runs and 2) make the design cleaner.

Here is the outline of major changes:

1. Merged the OngoingTournament class into the Tournament class, and change relations accordingly.
2. Added MatchRound enumeration suggested in Design 1, added `matchRound` attribute to the Match class.
3. Learning from Design 1, 2 and 3, for the Tournament class, the new team design will support maintaining first, second, and third place player. So the attribute `prizes:List<Prize>` in the original Design 4 was modified to `prizes:Map<String, Prize>`, where String represent the username of the Player.
4. cleaned up and modified several relations between classes according to team discussion.

###Summary

The team members are all located in the United States and Canada but in different time zones (Eastern, Central, and Pacific).  This, along with a short timeframe for the assignment, presented some difficulty in regards to scheduling a time for conference calls. 

We were able to connect via conference calls and further communicate via email and WhatsApp chat. The proliferation of online collaboration tools, as well as team members' experience using different tools, made working remotely possible and enjoyable. 

Exploring others' designs made the original requirements clearer. Seeing different implementation allowed us to choose the best of each.
