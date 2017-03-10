package edu.gatech.seclass.tourneymanager;

import android.widget.Toast;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.StartTournament;

import static edu.gatech.seclass.tourneymanager.R.id.editTextEntryPrice;
import static edu.gatech.seclass.tourneymanager.R.id.editTextHouseCut;

/**
 * Created by vidyakv on 3/9/2017.
 */
public class Starttournament_unittests {
    StartTournament startTournament;

    @Before
    public void setUp(){
        startTournament = new StartTournament();
    }

    @After
    public void tearDown(){
        startTournament = null;
    }

    @Test
    public void calculate_display_houseprofit() {
        int houseCut = 0;
        int houseProfit = 0;
        int entry = 0;
        Integer num_player = 8;
        houseCut = (Integer)(editTextHouseCut);
        entry = (Integer) (editTextEntryPrice);
        houseProfit = entry * num_player * houseCut / 100;

        assert ("the house profit is displayed", 1);
    }

}
