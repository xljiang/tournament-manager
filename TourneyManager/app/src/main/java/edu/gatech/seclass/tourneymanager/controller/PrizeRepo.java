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
import edu.gatech.seclass.tourneymanager.model.Prize;

/**
 * Created by xiaolu on 3/2/17.
 * @author Xiaolu Jiang
 */

public class PrizeRepo {

    private final String TAG = PrizeRepo.class.getSimpleName().toString();

    private DBHelper dbHelper;

    public PrizeRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public static String createTable() {
        return "CREATE TABLE " + Prize.TABLE  + "("
                + Prize.KEY_RunningID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Prize.KEY_TournamentID + " INTEGER, "
                + Prize.KEY_PlayerID + " INTEGER, "
                + Prize.KEY_PrizeType + " TEXT, "
                + Prize.KEY_PrizeAmount + " INTEGER )";
    }

    public int insert(Prize prize) {
        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Prize.KEY_TournamentID, prize.getTournamentID());
        values.put(Prize.KEY_PlayerID, prize.getPlayerID());
        values.put(Prize.KEY_PrizeType, prize.getPrizeType());
        values.put(Prize.KEY_PrizeAmount, prize.getPrizeAmount());

        // Inserting Row
        long id = db.insert(Prize.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) id;
    }

    public void delete(int prizeRunningId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Prize.TABLE, Prize.KEY_RunningID + "= ?", new String[] { String.valueOf(prizeRunningId) });
        db.close();
    }

    // delete all items in the table
    public void deleteAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Prize.TABLE, null, null);
        db.close();
    }

    // delete all prize records in the Prize table for a single player
    // given a playerId, which will be deleted in Player table
    public void deletePlayerRecords(int playerId) {
        //TODO
    }

    public List<Map<String, String>> getIndividualPlayerPrizeList(int playerId) {
        List<Map<String, String>> playerPrizeList = new ArrayList<>();

        //Open connection to db
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selectQuery =  "SELECT  " +
                Prize.KEY_RunningID + "," +
                Prize.KEY_PlayerID + "," +
                Prize.KEY_TournamentID + "," +
                Prize.KEY_PrizeType + "," +
                Prize.KEY_PrizeAmount +
                " FROM " + Prize.TABLE
                + " WHERE " +
                Prize.KEY_PlayerID + "=?"
                ;
        // update query TODO
        // eg. 2015, US Open, 1st Place, $50
        // then update the table name below

        Log.d(TAG, selectQuery);

        Cursor cursor = db.rawQuery(selectQuery, new String[] {String.valueOf(playerId)});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> prize = new HashMap<String, String>();
                prize.put("runningId", cursor.getString(cursor.getColumnIndex(Prize.KEY_RunningID)));
                prize.put("tourId", cursor.getString(cursor.getColumnIndex(Prize.KEY_TournamentID)));
                //prize.put("playerName", cursor.getString(cursor.getColumnIndex("Table Name")));
                //prize.put("tourName", cursor.getString(cursor.getColumnIndex("Table Name")));
                prize.put("prizeType", cursor.getString(cursor.getColumnIndex(Prize.KEY_PrizeType)));
                prize.put("prizeAmount", cursor.getString(cursor.getColumnIndex(Prize.KEY_PrizeAmount)));

                playerPrizeList.add(prize);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return playerPrizeList;

    }

}
