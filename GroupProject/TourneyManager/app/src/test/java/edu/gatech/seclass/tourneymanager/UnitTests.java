package edu.gatech.seclass.tourneymanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.AddPlayer;
import edu.gatech.seclass.tourneymanager.activity.ManagerMode ;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class AddPlayer_UnitTests {
    private AddPlayer addplayer;

    @Test
    public void testAssertions() {
        //test data
        String name = new String("abcd");
        String username = new String("ab1234");
        String phonenum = "1234567890";

        //Check that an object isn't null
        assertNotNull(name);

        //Check that an object isn't null
        assertNotNull(username);

        //Check that an object isn't null
        assertNotNull(phonenum);

    }

    @Before
    public void setUp() {
        addplayer = new AddPlayer {
            "abcd", "ab1234", "1234567890", "engineer"
        }
    }


    @Test
    public void testAddPlayerButton() {
        assertTrue(AddPlayer.buttonRegistor);
    }

    @After
    public void tearDown() {
        addplayer = null;
    }

    @Before
    public void setUp() {
        addplayer = new AddPlayer {
            "abcd", "ab1234", "1234567890", "engineer"
        }
    }

    @Test
    public void testButtonclear() {
        assertTrue(AddPlayer.buttonClear);
    }



}

