package edu.gatech.seclass.tourneymanager;

/**
 * Created by Xiaolu Jiang on 2/28/17.
 */

public class Tournament {
    // Labels table name
    public static final String TABLE = "Tournament";

    // Labels Table Columns names
    public static final String KEY_ID = "tournamentID";
    public static final String KEY_houseProfit = "houseProfit";
    public static final String KEY_totalPrizeAwarded = "totalPrizeAwarded";

    // properties help us to keep data
    private String tournamentID;
    private String houseProfit;
    private String totalPrizeAwarded;

    // getters and setters
    public String getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(String tournamentID) {
        this.tournamentID = tournamentID;
    }

    public String getHouseProfit() {
        return houseProfit;
    }

    public void setHouseProfit(String houseProfit) {
        this.houseProfit = houseProfit;
    }

    public String getTotalPrizeAwarded() {
        return totalPrizeAwarded;
    }

    public String setTotalPrizeAwarded(String totalPrizeAwarded) {
        return totalPrizeAwarded;
    }
}
