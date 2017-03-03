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
import edu.gatech.seclass.tourneymanager.model.Tournament;

/**
 * Created by xiaolu on 3/2/17.
 * @author Xiaolu Jiang
 */

public class TournamentRepo {

    private final String TAG = TournamentRepo.class.getSimpleName().toString();

    private DBHelper dbHelper;

    public TournamentRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public static String createTable() {
        return "CREATE TABLE " + Tournament.TABLE  + "("
                + Tournament.KEY_TourID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Tournament.KEY_TourName + " TEXT, "
                + Tournament.KEY_TourDate + " TEXT, "
                + Tournament.KEY_HouseProfit + " INTEGER, "
                + Tournament.KEY_TotalPrizeAwarded + " INTEGER )";
    }

    public int insert(Tournament tournament) {
        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Tournament.KEY_TourName, tournament.getTourName());
        values.put(Tournament.KEY_TourDate, tournament.getDate());
        values.put(Tournament.KEY_HouseProfit, tournament.getHouseProfit());
        values.put(Tournament.KEY_TotalPrizeAwarded, tournament.getTotalPrizeAwarded());

        // Inserting Row
        long tourId = db.insert(Tournament.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) tourId;
    }

    // delete all items in the table
    public void deleteAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Tournament.TABLE, null, null);
        db.close();
    }

    public List<Map<String, String>> getTourProfitHistoryList() {
        List<Map<String, String>> tournamentProfitList = new ArrayList<>();

        //Open connection to db
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selectQuery =  "SELECT  " +
                Tournament.KEY_TourID + "," +
                Tournament.KEY_TourName + "," +
                Tournament.KEY_TourDate + "," +
                Tournament.KEY_HouseProfit + "," +
                Tournament.KEY_TotalPrizeAwarded +
                " FROM " + Tournament.TABLE ;
                // order by date? TODO

        Log.d(TAG, selectQuery);

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> tournament = new HashMap<String, String>();
                tournament.put("tourId", cursor.getString(cursor.getColumnIndex(Tournament.KEY_TourID)));
                tournament.put("tourName", cursor.getString(cursor.getColumnIndex(Tournament.KEY_TourName)));
                tournament.put("tourDate", cursor.getString(cursor.getColumnIndex(Tournament.KEY_TourDate)));
                tournament.put("tourProfit", cursor.getString(cursor.getColumnIndex(Tournament.KEY_HouseProfit)));
                tournament.put("tourTotalPrizeAmount", cursor.getString(cursor.getColumnIndex(Tournament.KEY_TotalPrizeAwarded)));

                tournamentProfitList.add(tournament);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return tournamentProfitList;

    }
}
