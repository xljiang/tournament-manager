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

    // property help us to keep data
    public int player_ID;
    public String name;
    public String username;
    public String phone;
}