package edu.gatech.seclass.tourneymanager.controller;

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
                + Match.KEY_MatchID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Match.KEY_Player1ID + " INTEGER, "
                + Match.KEY_Player2ID + " INTEGER, "
                + Match.KEY_Round + " TEXT, "
                + Match.KEY_WinnerID + " INTEGER, "
                + Match.KEY_Status + " TEXT )";
    }

    public int insert(Match match) {
        //TODO
        return 0;
    }

    public void delete(int matchId) {
        //TODO
    }

    public void deleteAll() {
        //TODO

    }

    public void update(Match match) {
        //TODO

    }

    public Match getMatchById(int matchId) {
        //TODO
        return null;
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
}
