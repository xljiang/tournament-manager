package edu.gatech.seclass.tourneymanager;

/**
 * Created by Xiaolu Jiang on 2/28/17.
 */

public class Match {
    // Labels table name
    public static final String TABLE = "Match";

    // Labels Table Columns names
    public static final String KEY_MatchID = "MatchID"; // primary key
    public static final String KEY_Player1ID = "Player1ID";
    public static final String KEY_Player2ID = "Player2ID";
    public static final String KEY_Round = "Round";
    public static final String KEY_WinnerID = "WinnerID";
    public static final String KEY_Status = "Status";

    // instant variables
    private String matchID;
    private String player1ID;
    private String player2ID;
    private String round;
    private String winnerID;
    private String status;


    // getters and setters

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public String getPlayer1ID() {
        return player1ID;
    }

    public void setPlayer1ID(String player1ID) {
        this.player1ID = player1ID;
    }

    public String getPlayer2ID() {
        return player2ID;
    }

    public void setPlayer2ID(String player2ID) {
        this.player2ID = player2ID;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getWinnerID() {
        return winnerID;
    }

    public void setWinnerID(String winnerID) {
        this.winnerID = winnerID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
