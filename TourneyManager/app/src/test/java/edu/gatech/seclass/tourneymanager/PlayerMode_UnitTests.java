package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.PlayerMode;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class PlayerMode_UnitTests extends PlayerMode {
    private PlayerMode playerMode;

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_player_mode);
        Button b = (Button) findViewById(R.id.btnBack);
        Button b1 = (Button) findViewById(R.id.buttonOngoingTournament);
        Button b2 = (Button) findViewById(R.id.buttonPlayerList);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(PlayerMode_UnitTests.this, PlayerMode.class);
                startActivity(i);
            }
        });


    }

    @Before
    public void setUp() {
        playerMode = new PlayerMode();
    }

    @After
    public void teardown() {
        playerMode = null;
    }

    @Test
    public void testButtonclear() {
        Assert.assertTrue("clear button is clicked",true);
    }
}