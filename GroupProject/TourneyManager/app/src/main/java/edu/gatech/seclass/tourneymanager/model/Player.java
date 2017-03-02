package edu.gatech.seclass.tourneymanager.model;

/**
 * Created by IT001 on 23-Jun-16.
 */
public class Player {
    // Labels table name
    public static final String TABLE = "Player";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_username = "username";
    public static final String KEY_phone = "phone";
    public static final String KEY_Deck = "Deck";
    public static final String KEY_Total = "Total";

    // property help us to keep data
    public int playerID;
    public String name;
    public String username;
    public String phone;
    private String deck;
    private int total;

    // getters and setters

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int player_ID) {
        this.playerID = player_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int currTotalAmount) {
        this.total = currTotalAmount;
    }

    public void setTotal(int currTotalAmount, int newPrizeAmount) {
        this.total = currTotalAmount + newPrizeAmount;
    }
}