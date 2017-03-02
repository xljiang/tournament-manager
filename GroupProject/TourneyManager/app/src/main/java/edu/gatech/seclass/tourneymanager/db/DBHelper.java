package edu.gatech.seclass.tourneymanager.db;

/**
 * Code from instinctcoder.com
 * Edited by Katja Krivoruchko for CS 6300 Spring 2017
 * Edited by Xiaolu Jiang.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import edu.gatech.seclass.tourneymanager.model.Player;
import edu.gatech.seclass.tourneymanager.model.Match;
import edu.gatech.seclass.tourneymanager.model.Prize;
import edu.gatech.seclass.tourneymanager.model.Tournament;

public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 16;

    // Database Name
    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

/*        String CREATE_TABLE_STUDENT = "CREATE TABLE " + Player.TABLE  + "("
                + Player.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Player.KEY_name + " TEXT, "
                 + Player.KEY_phone + " TEXT, "
                + Player.KEY_username + " TEXT )";*/
        System.out.println("onCreate()");
        String CREATE_TABLE_STUDENT =  "CREATE TABLE " + Player.TABLE  + "("
                + Player.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Player.KEY_name + " TEXT, "
                + Player.KEY_phone + " TEXT, "
                + Player.KEY_username + " TEXT, "
                + Player.KEY_Deck + " TEXT, "
                + Player.KEY_Total + " INTEGER )";
        System.out.println(CREATE_TABLE_STUDENT);
        db.execSQL(CREATE_TABLE_STUDENT);

        //db.execSQL(PlayerRepo.createTable());
        //db.execSQL(TournamentRepo.createTable());
        //db.execSQL(MatchRepo.createTable());
        //db.execSQL(PrizeRepo.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("onUpgd()");

        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Player.TABLE);
        //db.execSQL("DROP TABLE IF EXISTS " + Tournament.TABLE);
        //db.execSQL("DROP TABLE IF EXISTS " + Match.TABLE);
        //db.execSQL("DROP TABLE IF EXISTS " + Prize.TABLE);

        // Create tables again
        onCreate(db);

    }

}