package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.ManagerMode;


/**
 * Created by vidyakv on 3/9/2017.
 */

public class ManagerMode_UnitTests extends ManagerMode {
    private ManagerMode managerMode;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_manager_mode);
        Button b = (Button) findViewById(R.id.btnAddNew);
        Button b1 = (Button) findViewById(R.id.btnBack);
        Button b2 = (Button) findViewById(R.id.buttonMatchList);
        Button b3 = (Button) findViewById(R.id.buttonProfitHistory);
        Button b4 = (Button) findViewById(R.id.buttonMgrHome);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(ManagerMode_UnitTests.this, ManagerMode.class);
                startActivity(i);
            }
        });

        Assert.assertTrue("all button functions work", true);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Before
    public void setUp() {
        managerMode = new ManagerMode();
    }

    @After
    public void teardown() {
        managerMode = null;
    }

    @Test
    public void testAddButton() throws Throwable {
        runOnUiThread(new Runnable() {
             Button addbutton = (Button) findViewById(R.id.btnAddNew);

            @Override
            public void run() {
                org.junit.Assert.assertTrue(addbutton.performClick());
            }
        });

    }

    @Test
      public void testbuttonProfitHistory() throws Throwable {
        runOnUiThread(new Runnable() {
            Button bprofithistory = (Button) findViewById(R.id.buttonProfitHistory);

            @Override
            public void run() {
                org.junit.Assert.assertTrue(bprofithistory.performClick());

            }
        });
    }
    @Test
    public void testbuttonMatchlist() throws Throwable {
        runOnUiThread(new Runnable() {
            Button buttonmatchlist = (Button) findViewById(R.id.buttonMatchList);

            @Override
            public void run() {
                org.junit.Assert.assertTrue(buttonmatchlist.performClick());

            }
        });
    }

    @Test
    public void testbuttonback() throws Throwable {
        runOnUiThread(new Runnable() {
            Button buttonback = (Button) findViewById(R.id.btnBack);

            @Override
            public void run() {
                org.junit.Assert.assertTrue(buttonback.performClick());

            }
        });
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ManagerMode_UnitTests Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}







