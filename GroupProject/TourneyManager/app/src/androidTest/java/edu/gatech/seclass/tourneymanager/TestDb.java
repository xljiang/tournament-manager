package edu.gatech.seclass.tourneymanager.com.tourneymanager.app.tests;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import edu.gatech.seclass.tourneymanager.db.DBHelper;

/**
 * Created by vidyakv on 3/7/2017.
 */

public class TestDb extends AndroidTestCase {
    public void testCreateDb() throws Throwable {
        mContext.deleteDatabase(DBHelper
                .DATABASE_NAME );
        SQLiteDatabase d = new DBHelper(this.mContext).getWritableDatabase();
        assertEquals(true,d.isOpen());
        d.close();
    }
    public void testInsertintoDb()
        //Insert some testdata into the database to see if it works
    String testPlayerName = "Mickey";
    String testUserName = "M7809"
            double testPhoneNumber = 123456789;
    //if there is error in the SQL table creation statements it will be thrown up here
    DBHelper dbHelper=new DBHelper(mContext);
    SQLiteDatabase db=dbHelper.getWritableDatabase();

    //Create a new map of values where column names are the keys
    ContentValues values = new ContentValues();


}
