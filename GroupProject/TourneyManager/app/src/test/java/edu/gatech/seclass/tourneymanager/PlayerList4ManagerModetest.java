package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.AddPlayer;

import static edu.gatech.seclass.tourneymanager.R.styleable.View;
import static org.junit.Assert.assertSame;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class PlayerList4ManagerModetest {
    private PlayerList4ManagerModetest playerList4ManagerModetest;
    @Before
    public void setUp() {
        playerList4ManagerModetest= new PlayerList4ManagerModetest();
    }

    @After
    public void teardown() {
        playerList4ManagerModetest=null;
    }

    @Test
    public void testreturnButton()
    {
        assert playerList4ManagerModetest.buttonReturn();

    }

    private boolean buttonReturn() {
        return true;
    }

    @Test
    public void testAddButton(){
        android.view.View view;
        if (View assertSame(view ,R.id.btnAddNew))) {

            Intent intent = new Intent(this, AddPlayer.class);


        }
    }


}
