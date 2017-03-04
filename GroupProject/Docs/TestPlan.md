# Test Plan

version 1.0

**Author**: Team 50

## 1 Testing Strategy

### 1.1 Overall strategy

Our overall testing strategy is composed of four level tests: unit test, integration test, system test and regression test. 

First of all, each developer will be responsible for creating unit tests for code that they develop. Unit tests will be automated as much as possible using JUnit. 

Secondly, once every module passed unit test, components will be integrated based on use cases. The QA manager will be responsible for integrated components and assign tests to developers. Briefly, the developers who produced code that is essential to a particular integration will collaborate in developing and running tests. 

Thirdly, after integration test for all uses cases have been passed, full system level testing will take place. Each team member will serve as alpha testers - each of us will spend time interacting with app, independently. 

Finally, we will use regression testing if changes are made. Automated unit tests will be repeated to ensure that no software regression has occurred. And the whole system should be fully tested before release.

### 1.2 Test Selection

Both white-box testing and black-box testing will be used. Test strategy will be selected based on if the tester knows the implementation of the function being tested or not. If known, we will use white-box testing; if not, we will use black-box testing.

In other words, at unit test level, we will use JUnit testing in a white-box testing strategy. At integration and system test level, we will use black-box testing strategy to ensure that the system works according to the requirements on a functional level.

### 1.3 Adequacy Criterion

Overall, we intend for our system level tests to satisfy all requirement specifications. All code and all functions involving calculations will be covered with JUnit testing. All use cases and user screens will have either unit testing associated with them or manual testing performed. We intend to cover above 90% corner cases.

### 1.4 Bug Tracking

Bugs and enhancement request will be tracked with github issue tracker. In general, bugs at the unit level will be fixed independently by the developer of that code. Bugs at the integration level and above, as well as enhancements, will be aware of by all team members. Besides the github issue tracker, team members will also communicate bugs through instant chatting or e-mail, especially for high priority bugs. The QA manager will assign developers to fix these bugs either independently or collaboratively.

### 1.5 Technology

We will use a mixture of JUnit and manual testing. JUnit will be used to create automated testing for all unit tests and some integration tests. Manual testing will be used for UI related integration tests and system level tests.

## 2 Test Cases

All of the integration level and system level tests are shown below. Individual developers are responsible for unit testing of their own codes, such tests are not listed.

- **Integration Tests**

| Test No.    | Purpose      | Steps            | Expected Result  | Actual Result  | Pass/Fail Info | Tester's Initials | Additional Info |
|:-----------:|:------------------:|:------------:|:------------------:|:---------------:|:------:|:----:|:----:|
| I1          | Verify Manager can add a player to and remove a player from the system  | JUnit test| be able to add/remove a player from the system | Able to add/remove a player from the system | Pass | KK | Cannot assign deck choice |
| I2          | Verify Manager can manage matches  | JUnit test | can (1) add match, return Match (2) end a match | | | | |
| I3.1        | Verify Manager can manage tournaments (1) start a tournament | JUnit test | return an ongoing tournament | | | | |
| I3.2        | Verify Manager can manage tournaments (2) end a tournament | JUnit test | an ongoing tournament is terminated, also label this tournament is completed or not correctly | | | | |
| I3.3        | Verify Manager can manage tournaments (3) issue refund | JUnit tests | give correct amount of money back to a not completed but already terminated tournament, also refund to this tournament players | | | | |
| I4          | Verify Manager can display current prizes | JUnit test (query database) | (1) successfully access to the database (2) return correct prizes | | | | |
| I5          | Verify Manager can display current profit  | JUnit test | calculate and display correct profit | | | | |
| I6          | Verify Manager can view past house profits  | JUnit test | calculate and display correct house profit | | | | |
| I7          | Verify Manager and Player can view player lists sorted by total  | JUnit test | return player list, the list should be listed sorted by total amount of money, from high to low | | | | |
| I8          | Verify Manager and Player can view match lists  | JUnit test | return a match list | | | | |
| I9          | Verify Manager can view a single player's prizes  | JUnit test, given the player's username | return prizes catagory and amount that the player has | | | | |


- **System Tests**

| Test No.    | Purpose      | Steps            | Expected Result  | Actual Result  | Pass/Fail Info | Tester's Initials | Additional Info |
|:-----------:|:------------:|:----------------:|:----------------:|:--------------:|:---------:|:-----:|:-----:|
| S1          | Verify UI has two modes | Manual test | UI has Manager and Player modes |UI has two modes |Pass | v| modes are in the first screen|
| S2(2.1, 2.2)| Verify Manager UI has required functions | Manual test | (1) S2.1 when no ongoing tournament, Manager UI show options to view the list of past house profits in chronological order and the total, view totals for every player as a list sorted by total (Player list) (2) S2.2 when has ongoing tournament, Manager UI show a match list| | | |
| S3(3.1, 3.2)| Verify Player UI has required functions | Manual test | (1) S3.1 when no ongoing tournament, Player UI show totals for every player in the system as a list sorted by total. (2) S3.2 when has ongoing tournament, Player UI show a match list | | | | |
| S4          | Verify match list UI function in Manager mode, further test S2.2 | Manual test | Match list will be able to (1) start a match ready to be played by selecting it from the list (2) end an ongoing match and specify a result (3) S4.3 end the tournament.| | | | |
| S5          | Verify match list UI function in Player mode, further test S3.2 | Manual test | Match list display a list of players paired with other players representing ongoing matches, matches ready to be played, and results from completed matches | | | | |
| S6          | Verify player list UI function in Manager mode, further test S2.1| Manual test | From here, the manager can also view a list of the player's individual prized by selecting the player from the list | | | | |
| S7          | Verify Input UI when starting a tournament | Manual test | has inputs for (1) house cut, (2) entry price, (3) player usernames (8 or 16) (4) S7.4| | | | |
| S7.4        | Verify the system can correctly calculate prizes and profit | JUnit Test | correct calculation | | | | |
| S7.5        | Verify input for house cut, entry price are in valid range| JUnit test for valid range, Manual Test for error message layout | If not valid, show error message | | | | |
| S8          | Verify early ending a tournament function, further testing S4.3| Test both end completed ongoing tournament and end not completed ongoing tournament | If the tournament is ended early, issue correct refund | | | | |
| S9          | Verify prizes will be recored in the database after a tournament completed | Query database | database should has record for the username and prize amount for first, second and third player | | | | |
| S10         | Verify the house prifit will be recored in the database after a tournament completed | Query database | database should record tournament id and related house profit | | | | |
| S11         | Overall review of UI | Manual Test | UI must be responsive and no dead link | | | | |

