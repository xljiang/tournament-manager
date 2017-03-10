package edu.gatech.seclass.tourneymanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.MatchList4ManagerMode;
import edu.gatech.seclass.tourneymanager.activity.MatchList4PlayerMode;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class MatchList4PlayerModetest {
    private MatchList4PlayerMode matchList4PlayerMode;

    @Before
    public void setUp() {
        matchList4PlayerMode= new MatchList4PlayerMode();
    }

    @After
    public void teardown() {
        matchList4PlayerMode=null;
    }

    @Test
    public void testreturnButton()
    {
        assert matchList4PlayerMode.buttonReturn();
    }

}
