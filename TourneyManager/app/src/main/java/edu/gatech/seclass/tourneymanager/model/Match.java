package edu.gatech.seclass.tourneymanager.model;

/**
 * Created by Xiaolu Jiang on 2/28/17.
 * @author Xiaolu Jiang
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

    // Match Round
    public static final String ROUND_FINAL = "Final"; // 2
    public static final String ROUND_SEMIFINAL = "1/2"; //4
    public static final String ROUND_THIRDPLACE = "3rd";
    public static final String ROUND_QUARTERFINAL = "1/4"; // 8
    public static final String ROUND_EIGHTHFINAL = "1/8"; // 16

    // Match Status
    public static final String STATUS_FINISHED = "Finished";
    public static final String STATUS_ONGOING = "Ongoing";
    public static final String STATUS_READY = "Ready";
    public static final String STATUS_NOTREADY = "Not Ready";


    // instant variables
    private int matchID;
    private int player1ID;
    private int player2ID;
    private String round;
    private int winnerID;
    private String status;


    // getters and setters

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public int getPlayer1ID() {
        return player1ID;
    }

    public void setPlayer1ID(int player1ID) {
        this.player1ID = player1ID;
    }

    public int getPlayer2ID() {
        return player2ID;
    }

    public void setPlayer2ID(int player2ID) {
        this.player2ID = player2ID;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public int getWinnerID() {
        return winnerID;
    }

    public void setWinnerID(int winnerID) {
        this.winnerID = winnerID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
