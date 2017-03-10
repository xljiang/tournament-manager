package edu.gatech.seclass.tourneymanager;

import android.app.Activity;
import android.app.ListActivity;
import android.widget.ListView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.MatchList4ManagerMode;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class MatchList4ManagerModetest {
    private MatchList4ManagerMode matchList4ManagerMode;

    @Before
    public void setUp() {
        matchList4ManagerMode = new MatchList4ManagerMode();
    }

    @After
    public void teardown() {
        matchList4ManagerMode=null;
    }

    @Test
     public void testreturnButton()
    {
        assert matchList4ManagerMode.buttonReturn();
    }



}
