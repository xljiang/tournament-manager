# Test Plan

version 1.0

**Author**: Team 50

## 1 Testing Strategy

### 1.1 Overall strategy

Our overall testing strategy is composed of four level tests: unit test, integration test, system test and regression test. 

First of all, each developer will be responsible for creating unit tests for code that they develop. The quality of these tests will then be validated by one other developer. Unit tests will be automated as much as possible using JUnit.

Secondly, once every module passed unit test, components will be integrated based on use cases. The developers who produced code that is essential to a particular integration will collaborate in developing tests and will also run those tests. Integration test will proceed until all individual use cases have been tested.

Thirdly, full system level testing will take place after integration test have been passed. Each team member will simulate a full deployment of the app independently so that any high level or complex bugs are more likely to be uncovered by scrutiny from multiple individuals.

Finally, as incremental changes are made, regression testing will take place. For example, if integration-testing unveils a bug and a fix is made, the automated unit tests will be repeated to ensure that no software regressions have occurred (or at least are corrected immediately). To this end, as many tests as is practical will be automated on the integration and system level.

### 1.2 Test Selection

Both white-box testing and black-box testing will be used. Test strategy will be selected based on if the tester knows the implementation of the function being tested or not. If known, we will use white-box testing; if not, we will use black-box testing.

In other words, at unit test level, we will use JUnit testing in a white-box testing strategy. At integration and system test level, we will use black-box testing strategy to ensure that the system works according to the requirements on a functional level.

### 1.3 Adequacy Criterion

Overall, we intend for our system level tests to satisfy all requirement specifications. All code and all functions involving calculations will be covered with JUnit testing. All use cases and user screens will have either unit testing associated with them or manual testing performed. We intend to cover above 90% corner cases.

### 1.4 Bug Tracking

Bugs and enhancement request will be tracked with a shared Google spreadsheet. In general, bugs at the unit level will be fixed independently by the developer of that code. Bugs at the integration level and above, as well as enhancements, will be aware of by all team members. Besides the spreadsheet, team members will also communicate bugs through instant chatting or e-mail, especially for high priority bugs. The QA manager will assign developers to fix these bugs either independently or collaboratively.

### 1.5 Technology

We will use a mixture of JUnit and manual testing. JUnit will be used to create automated testing for all unit tests and some integration tests. Manual testing will be used for UI related integration tests and system level tests.

## 2 Test Cases

All of the integration level and system level tests are shown below. Individual developers are responsible for unit testing of their own codes, such tests are not listed.

- **Integration Tests**

| Test No.    | Purpose      | Steps            | Expected Result  | Actual Result  | Pass/Fail Info | Tester's Initials | Additional Info |
|:-----------:|:------------------:|:------------:|:------------------:|:---------------:|:------:|:----:|:----:|
| I1          | Verify Manager can add a player to and remove a player from the system  | (1) add player (2) remove player| | | | | |
| I2          | Verify Manager can manage matches  | | | | | | |
| I3          | Verify Manager can manage tournaments  | (1) start a tournament (2) end a tournament (3) issue refund | | | | | |
| I4          | Verify Manager can display current prizes | (1) access to database (2) display correct prizes | | | | | |
| I5          | Verify Manager can display current profit  | | | | | | |
| I6          | Verify Manager can view past house profits  | | | | | | |
| I7          | Verify Manager and Player can view player lists sorted by total  | | | | | | |
| I8          | Verify Manager and Player can view match lists  | | | | | | |
| I9          | Verify Manager can view a single player's prizes  | | | | | | |
| I10         | Verify Player can play for a tournament  | | | | | | |



