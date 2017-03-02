package edu.gatech.seclass.tourneymanager.model;

/**
 * Created by Xiaolu Jiang on 2/28/17.
 */

public class Tournament {
    // Labels table name
    public static final String TABLE = "Tournament";

    // Labels Table Columns names
    public static final String KEY_TourID = "TournamentID"; // primary key
    public static final String KEY_HouseProfit = "HouseProfit";
    public static final String KEY_TotalPrizeAwarded = "TotalPrizeAwarded";

    // properties help us to keep data
    private int tournamentID;
    private int houseProfit;
    private int totalPrizeAwarded;

    // getters and setters
    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public int getHouseProfit() {
        return houseProfit;
    }

    public void setHouseProfit(int houseProfit) {
        this.houseProfit = houseProfit;
    }

    public int getTotalPrizeAwarded() {
        return totalPrizeAwarded;
    }

    public void setTotalPrizeAwarded(int totalPrizeAwarded) {
        this.totalPrizeAwarded = totalPrizeAwarded;
    }
}
