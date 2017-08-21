package edu.gatech.seclass.tourneymanager.model;

/**
 * Created by Xiaolu Jiang on 2/28/17.
 * @author Xiaolu Jiang
 */

public class Prize {
    // Labels table name
    public static final String TABLE = "Prize";

    // Labels Table Columns names
    public static final String KEY_RunningID = "RunningID"; // primary key
    public static final String KEY_TournamentID = "TournamentID";
    public static final String KEY_PlayerID = "PlayerID";
    public static final String KEY_PrizeType = "PrizeType";
    public static final String KEY_PrizeAmount = "PrizeAmount";

    // Prize type
    public static final String PRIZE_FIRST = "First";
    public static final String PRIZE_SECOND = "Second";
    public static final String PRIZE_THIRD = "Third";


    private int runningID;
    private int tournamentID;
    private int playerID;
    private String prizeType;
    private int prizeAmount;


    // getters and setters

    public int getRunningID() {
        return runningID;
    }

    public void setRunningID(int runningID) {
        this.runningID = runningID;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }
}
