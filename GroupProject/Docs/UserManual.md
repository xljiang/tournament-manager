# User Manual

version 1.0

**Author**: Team 50

## 1 Introduction

Thank you for downloading the Woodruff Lounge Tournament Manager! This Android application allows you to manage players, create and run tournaments, and keep track of prize money. 

### 1.1 System Requirements

Woodruff Lounge	is a mobile application that runs on Android 4.4 (Kit Kit) or later. Please make sure you are running at least the minimum required version of the operating system. 

## 2 How to Use Woodruff Lounge Tournament Manager

The Woodruff Lounge Tournament Manager has two mode, the **Manager Mode** and the **Player Mode**. The **Manager Mode** allows a user to start and manager a tournament.  The **Player Mode** allows a user to see the list of player, as well as the list of matches for an ongoing tournament.  

### 2.1 Starting the application

On startup, a user is presented with a splash screen. Please touch or tap the button in the middle of the screen to choose the mode.  

![] (https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Docs/Screenshots/splash.jpg)

### 2.1 Manager Mode

Manager Mode allows tournament manager to view and edit the list of matches, the list of players, view the profit history for all tournaments, and to start a tournament if one is not in progress.

![] (https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Docs/Screenshots/manager_mode.jpg)

#### 2.1.1 Match List

Match list shows tournament manager the list of matches for the ongoing tournament and allows to start a match.

![] (https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Docs/Screenshots/match_list.jpg)

> **Note:** When there is no ongoing tournament, no matches are shown, as none are played or pending.

![] (https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Docs/Screenshots/match_list_no_tourney.jpg)


#### 2.1.2 Player List

Player list allows manager to see a list of all players in the system, as well as to update a player's profile.

![] (https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Docs/Screenshots/player_list.jpg)

#### 2.1.3 Profit History

Profit History screen allows tournament manager to view a history of house profits for all completed tournaments.

![] (https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Docs/Screenshots/profit_history.jpg)

#### 2.1.4 Start Tournament

Start Tournament screen allows tournament manager to start a tournament if one is not already in progress.

In order to start a tournament, tournament manager must enter the house cut (as a percentage) and the entry fee (per player), as well as the number of player (**8 or 16**). The application will then populate the list of players for the tournament from the list of available players and calculate  the house profit, as well as 1st, 2nd, and 3rd prizes.

The house profit is calculated using the following formula:

House profit = Number of players * Entry fee * House cut.

For example, if there are 8 players in a tournament, the entry fee is $100, and the house cut is 20%, then:

```
House profit = 8 * $100 * 0.2 = $160
```

First place prize is calculated as 50% of the pot after the house cut.  Using the above example,

```
1st place = 8 * $100 * 0.8 * 0.5 = $320.
```

Second place prize is calculated as 30% of the pot after the house cut. Using the same example,

```
2nd place = 8 * $100 * 0.8 * 0.3 = $192.
```

Third place prize is calculated as the remaining pot, or 20% of the pot after the house cut.  Using the same example,

```
3rd place = 8 * $100 * 0.8 * 0.2 = $128.
```
 
![] (https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Docs/Screenshots/start_tournament.jpg)

### 2.2 Player Mode

Player mode as two options, Match List and Player List.

![] (https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Docs/Screenshots/player_mode.jpg)

#### 2.2.1 Match List 

Through the Player Mode, Match List option allows the player to see (but not edit), the list of all matches for the current tournament, as well as their status.


![] (https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Docs/Screenshots/match_list_player.jpg)

#### 2.2.2 Player List

Through the Player Mode, Player List option allows the player to see (though not edit) the list of all players in the system.

![] (https://github.gatech.edu/gt-omscs-se-2017spring/6300Spring17Team50/blob/master/GroupProject/Docs/Screenshots/player_list_player.jpg)

### 3 How to get support

We hope you enjoy the application. Should you experience any problems, please submit an issue in the team github repository.
