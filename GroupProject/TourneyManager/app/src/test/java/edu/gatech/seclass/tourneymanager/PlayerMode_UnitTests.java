package edu.gatech.seclass.tourneymanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.PlayerMode;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class PlayerMode_UnitTests {
    private PlayerMode playerMode;
    @Before
    public void setUp() {
        playerMode = new PlayerMode();
    }

    @After
    public void teardown() {
        playerMode=null;
    }

    @Test
    public void testreturnbutton()
    {
        assert playerMode.buttonReturn();
    }

    @Test
    public void testOngoingTournamentbutton()
    {
        assert playerMode.buttonOngoingTournament();
    }

    @Test
    public void testPlayerListbutton()
    {
        assert playerMode.buttonPlayerList();
    }

}
