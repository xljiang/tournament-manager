package edu.gatech.seclass.tourneymanager.controller;

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
import edu.gatech.seclass.tourneymanager.model.Match;

/**
 * Created by xiaolu on 3/2/17.
 * @author Xiaolu Jiang
 */

public class MatchRepo {
    private final String TAG = MatchRepo.class.getSimpleName().toString();

    private DBHelper dbHelper;

    public MatchRepo(Context context) {
        dbHelper = new DBHelper(context);
    }


    public static String createTable() {
        return "CREATE TABLE " + Match.TABLE  + "("
                + Match.KEY_MatchID  + " INTEGER PRIMARY KEY ,"
                + Match.KEY_Player1ID + " INTEGER, "
                + Match.KEY_Player2ID + " INTEGER, "
                + Match.KEY_Round + " TEXT, "
                + Match.KEY_WinnerID + " INTEGER, "
                + Match.KEY_Status + " TEXT )";
    }

    public int insert(Match match) {
        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Match.KEY_MatchID, match.getMatchID());
        values.put(Match.KEY_Player1ID, match.getPlayer1ID());
        values.put(Match.KEY_Player2ID, match.getPlayer2ID());
        values.put(Match.KEY_Round, match.getRound());
        values.put(Match.KEY_WinnerID, match.getWinnerID());
        values.put(Match.KEY_Status, match.getStatus());

        // Inserting Row
        long matchId = db.insert(Match.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) matchId;
    }

    public void delete(int matchId) {
        //TODO
    }

    // delete all items in the table
    public void deleteAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Match.TABLE, null, null);
        db.close();
    }

    public void update(Match match) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Match.KEY_Player1ID, match.getPlayer1ID());
        values.put(Match.KEY_Player2ID, match.getPlayer2ID());
        values.put(Match.KEY_Round, match.getRound());
        values.put(Match.KEY_WinnerID, match.getWinnerID());
        values.put(Match.KEY_Status, match.getStatus());

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Match.TABLE, values, Match.KEY_MatchID + "= ?", new String[] { String.valueOf(match.getMatchID()) });
        db.close(); // Closing database connection

    }

    public Match getMatchById(int matchId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Match.KEY_MatchID + "," +
                Match.KEY_Player1ID + "," +
                Match.KEY_Player2ID + "," +
                Match.KEY_Round + "," +
                Match.KEY_WinnerID + "," +
                Match.KEY_Status +
                " FROM " + Match.TABLE
                + " WHERE " +
                Match.KEY_MatchID + "=?"
                ;

        Log.d(TAG, selectQuery);

        Match match = new Match();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(matchId) } );

        if (cursor.moveToFirst()) {
            do {
                match.setMatchID(cursor.getInt(cursor.getColumnIndex(Match.KEY_MatchID)));
                match.setPlayer1ID(cursor.getInt(cursor.getColumnIndex(Match.KEY_Player1ID)));
                match.setPlayer2ID(cursor.getInt(cursor.getColumnIndex(Match.KEY_Player2ID)));
                match.setRound(cursor.getString(cursor.getColumnIndex(Match.KEY_Round)));
                match.setWinnerID(cursor.getInt(cursor.getColumnIndex(Match.KEY_WinnerID)));
                match.setStatus(cursor.getString(cursor.getColumnIndex(Match.KEY_Status)));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return match;
    }



    public List<Map<String, String>> getMatchList() {
        List<Map<String, String>> matchList = new ArrayList<>();

        //Open connection to db
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selectQuery =  "SELECT  " +
                Match.KEY_MatchID + "," +
                Match.KEY_Player1ID + "," +
                Match.KEY_Player2ID + "," +
                Match.KEY_Round + "," +
                Match.KEY_WinnerID + "," +
                Match.KEY_Status +
                " FROM " + Match.TABLE
                ;
        //TODO
        //need to change query to show player's name rather than id

        Log.d(TAG, selectQuery);

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> match = new HashMap<String, String>();
                match.put("id", cursor.getString(cursor.getColumnIndex(Match.KEY_MatchID)));
                match.put("player1name", cursor.getString(cursor.getColumnIndex(Match.KEY_Player1ID)));// store id now
                match.put("player2name", cursor.getString(cursor.getColumnIndex(Match.KEY_Player2ID)));// store id now
                match.put("round", cursor.getString(cursor.getColumnIndex(Match.KEY_Round)));
                match.put("winnerName", cursor.getString(cursor.getColumnIndex(Match.KEY_WinnerID)));// store id now
                match.put("status", cursor.getString(cursor.getColumnIndex(Match.KEY_Status)));

                matchList.add(match);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return matchList;

    }

    // return how many players in this match
    public int getPlayerCount() {
        //Open connection to db
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String countQuery = "SELECT  * FROM " + Match.TABLE;
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    // return true if all matches has finished
    public boolean allMatchCompleted() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selectQuery =  "SELECT " + Match.KEY_Status + " FROM " + Match.TABLE;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String status = cursor.getString(cursor.getColumnIndex(Match.KEY_Status));
                if (!status.equals(Match.STATUS_FINISHED)) {
                    return false;
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return true;
    }

}
