package edu.gatech.seclass.tourneymanager;

/**
 * Code from instinctcoder.com
 * Edited by Katja Krivoruchko for CS 6300 Spring 2017
 */


/**
 * Created by IT001 on 23-Jun-16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayerRepo {
    private DBHelper dbHelper;

    public PlayerRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Player player) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Player.KEY_phone, player.phone);
        values.put(Player.KEY_username,player.username);
        values.put(Player.KEY_name, player.name);

        // Inserting Row
        long player_Id = db.insert(Player.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) player_Id;
    }

    public void delete(int player_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Player.TABLE, Player.KEY_ID + "= ?", new String[] { String.valueOf(player_Id) });
        db.close(); // Closing database connection
    }

    public void update(Player player) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Player.KEY_phone, player.phone);
        values.put(Player.KEY_username,player.username);
        values.put(Player.KEY_name, player.name);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Player.TABLE, values, Player.KEY_ID + "= ?", new String[] { String.valueOf(player.player_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getStudentList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Player.KEY_ID + "," +
                Player.KEY_name + "," +
                Player.KEY_username + "," +
                Player.KEY_phone +
                " FROM " + Player.TABLE;

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
                Player.KEY_phone +
                " FROM " + Player.TABLE
                + " WHERE " +
                Player.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Player player = new Player();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                player.player_ID =cursor.getInt(cursor.getColumnIndex(Player.KEY_ID));
                player.name =cursor.getString(cursor.getColumnIndex(Player.KEY_name));
                player.username  =cursor.getString(cursor.getColumnIndex(Player.KEY_username));
                player.phone =cursor.getString(cursor.getColumnIndex(Player.KEY_phone));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return player;
    }

}