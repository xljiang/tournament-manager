package edu.gatech.seclass.tourneymanager.controller;

/**
 * @author Katja Krivoruchko
 * @author Xiaolu Jiang
 *
 * reference: instinctcoder.com
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.gatech.seclass.tourneymanager.db.DBHelper;
import edu.gatech.seclass.tourneymanager.db.DatabaseManager;
import edu.gatech.seclass.tourneymanager.model.Player;

public class PlayerRepo {
    private final String TAG = PlayerRepo.class.getSimpleName().toString();

    private DBHelper dbHelper;

    public PlayerRepo(Context context) {
        dbHelper = new DBHelper(context);
    }


    public static String createTable() {
        return "CREATE TABLE " + Player.TABLE  + "("
                + Player.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Player.KEY_name + " TEXT, "
                + Player.KEY_phone + " TEXT, "
                + Player.KEY_username + " TEXT, "
                + Player.KEY_Deck + " TEXT, "
                + Player.KEY_Total + " INTEGER )";
    }

    public int insert(Player player) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Player.KEY_name, player.name);
        values.put(Player.KEY_username,player.username);
        values.put(Player.KEY_phone, player.phone);
        values.put(Player.KEY_Deck, player.getDeck());
        values.put(Player.KEY_Total, player.getTotal());


        // Inserting Row
        long playerId = db.insert(Player.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) playerId;
    }

    public void delete(int playerId) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Player.TABLE, Player.KEY_ID + "= ?", new String[] { String.valueOf(playerId) });
        db.close(); // Closing database connection
    }

    public void deleteAll() {
        //TODO
    }

    public void update(Player player) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Player.KEY_phone, player.phone);
        values.put(Player.KEY_username,player.username);
        values.put(Player.KEY_name, player.name);
        values.put(Player.KEY_Deck, player.getDeck());
        values.put(Player.KEY_Total, player.getTotal());

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Player.TABLE, values, Player.KEY_ID + "= ?", new String[] { String.valueOf(player.playerID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getStudentList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Player.KEY_ID + "," +
                Player.KEY_name + "," +
                Player.KEY_username + "," +
                Player.KEY_phone + "," +
                Player.KEY_Deck + "," +
                Player.KEY_Total +
                " FROM " + Player.TABLE;

        Log.d(TAG, selectQuery);
        //Player player = new Player();
        ArrayList<HashMap<String, String>> studentList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> player = new HashMap<String, String>();
                player.put("id", cursor.getString(cursor.getColumnIndex(Player.KEY_ID)));
                player.put("name", cursor.getString(cursor.getColumnIndex(Player.KEY_name)));
                //player.put("username", cursor.getString(cursor.getColumnIndex(Player.KEY_username)));
                //player.put("phone", cursor.getString(cursor.getColumnIndex(Player.KEY_phone)));

                studentList.add(player);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return studentList;

    }

    public Player getStudentById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Player.KEY_ID + "," +
                Player.KEY_name + "," +
                Player.KEY_username + "," +
                Player.KEY_phone + "," +
                Player.KEY_Deck + "," +
                Player.KEY_Total +
                " FROM " + Player.TABLE
                + " WHERE " +
                Player.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        Log.d(TAG, selectQuery);
        //int iCount =0;
        Player player = new Player();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                player.playerID =cursor.getInt(cursor.getColumnIndex(Player.KEY_ID));
                player.name =cursor.getString(cursor.getColumnIndex(Player.KEY_name));
                player.username  =cursor.getString(cursor.getColumnIndex(Player.KEY_username));
                player.phone =cursor.getString(cursor.getColumnIndex(Player.KEY_phone));
                player.setDeck(cursor.getString(cursor.getColumnIndex(Player.KEY_Deck)));
                player.setTotal(cursor.getInt(cursor.getColumnIndex(Player.KEY_Total)));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return player;
    }


    // return a list of map with player name and player total prize amount
    public List<Map<String, String>> getPlayerTotalList() {
        List<Map<String, String>> playerTotalList = new ArrayList<>();

        //Open connection to db
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selectQuery =  "SELECT  " +
                Player.KEY_ID + "," +
                Player.KEY_name + "," +
                Player.KEY_Total +
                " FROM " + Player.TABLE +
                " ORDER BY " + Player.KEY_Total + " DESC";

        Log.d(TAG, selectQuery);

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> player = new HashMap<String, String>();
                player.put("id", cursor.getString(cursor.getColumnIndex(Player.KEY_ID)));
                player.put("name", cursor.getString(cursor.getColumnIndex(Player.KEY_name)));
                player.put("total", cursor.getString(cursor.getColumnIndex(Player.KEY_Total)));

                playerTotalList.add(player);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return playerTotalList;

    }

}