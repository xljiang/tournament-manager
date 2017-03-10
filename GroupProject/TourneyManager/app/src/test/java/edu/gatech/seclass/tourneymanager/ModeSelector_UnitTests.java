package edu.gatech.seclass.tourneymanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.ModeSelector;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class ModeSelector_UnitTests {
    private ModeSelector modeSelector;

    @Before
    public void setUp() {
        modeSelector = new ModeSelector();
    }

    @After
    public void tearDown() {
        modeSelector = null;
    }

    @Test
    public void testmanagermodebutton(){
        assert modeSelector.buttonManagerMode();
    }

    @Test
    public void testplayermodebutton(){
        assert modeSelector.buttonPlayerMode();
    }

    @Test
    public void testreturnbutton(){
        assert modeSelector.buttonReturn();
    }

}
