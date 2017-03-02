package edu.gatech.seclass.tourneymanager.db;

/**
 * @author Katja Krivoruchko
 * @author Xiaolu Jiang.
 *
 * Reference: instinctcoder.com
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import edu.gatech.seclass.tourneymanager.controller.MatchRepo;
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
import edu.gatech.seclass.tourneymanager.controller.PrizeRepo;
import edu.gatech.seclass.tourneymanager.controller.TournamentRepo;
import edu.gatech.seclass.tourneymanager.model.Player;
import edu.gatech.seclass.tourneymanager.model.Match;
import edu.gatech.seclass.tourneymanager.model.Prize;
import edu.gatech.seclass.tourneymanager.model.Tournament;

public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 17;

    // Database Name
    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

/*        String CREATE_TABLE_STUDENT =  "CREATE TABLE " + Player.TABLE  + "("
                + Player.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Player.KEY_name + " TEXT, "
                + Player.KEY_phone + " TEXT, "
                + Player.KEY_username + " TEXT, "
                + Player.KEY_Deck + " TEXT, "
                + Player.KEY_Total + " INTEGER )";
        db.execSQL(CREATE_TABLE_STUDENT);*/

        db.execSQL(PlayerRepo.createTable());
        db.execSQL(TournamentRepo.createTable());
        db.execSQL(MatchRepo.createTable());
        db.execSQL(PrizeRepo.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Player.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Tournament.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Match.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Prize.TABLE);

        // Create tables again
        onCreate(db);

    }

}