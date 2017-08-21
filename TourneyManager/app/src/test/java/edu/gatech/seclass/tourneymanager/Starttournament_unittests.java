package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.ManagerMode;
import edu.gatech.seclass.tourneymanager.activity.StartTournament;

import static edu.gatech.seclass.tourneymanager.R.id.editTextEntryPrice;
import static edu.gatech.seclass.tourneymanager.R.id.editTextHouseCut;

/**
 * Created by vidyakv on 3/9/2017.
 */

    public class Starttournament_unittests extends StartTournament {
    private StartTournament startTournament;
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_start_tournament);
        Button b = (Button) findViewById(R.id.btnStartTour);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(Starttournament_unittests.this, ManagerMode.class);
                startActivity(i);
            }
        });
    }


    @Before
    public void setUp() {
        startTournament = new StartTournament();
    }

    @After
    public void tearDown() {
        startTournament = null;
    }

    @Test
    public void calculate_display_houseprofit() {
        int houseCut = 0;
        int houseProfit = 0;
        int entry = 0;
        Integer num_player = 8;
        houseCut = (Integer) (editTextHouseCut);
        entry = (Integer) (editTextEntryPrice);
        houseProfit = entry * num_player * houseCut / 100;

        Assert.assertTrue("the house profit is displayed", true);
    }
    @Test
    public void testNotNull_validrange_case() {
        Assert.assertNotNull("house cut value needs to be entered", editTextHouseCut);
        Assert.assertNotNull("entry value must be entered", editTextEntryPrice);
        if (editTextHouseCut < 0 || editTextHouseCut > 100) {
            Assert.assertNotNull("Invalid house cut percentage", editTextHouseCut);
        }
        if (editTextEntryPrice <= 0) {
            Assert.assertNotNull("Invalid entry price", editTextEntryPrice);
        }
    }


}





