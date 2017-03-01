package edu.gatech.seclass.tourneymanager;

/**
 * Created by Xiaolu Jiang on 2/28/17.
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

    // instance variables
    private String tournamentID;
    private String playerID;
    private String prizeType;
    private String prizeAmount;


    // getters and setters
    public String getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(String tournamentID) {
        this.tournamentID = tournamentID;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    public String getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(String prizeAmount) {
        this.prizeAmount = prizeAmount;
    }
}
