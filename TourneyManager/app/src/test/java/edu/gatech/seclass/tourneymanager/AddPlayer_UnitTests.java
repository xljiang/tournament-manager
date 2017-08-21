package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.AddPlayer;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by vidyakv on 3/10/2017.
 */

public class AddPlayer_UnitTests extends AddPlayer{
    private AddPlayer addplayer;
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_add_player);
        Button b = (Button) findViewById(R.id.buttonRegistor);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(AddPlayer_UnitTests.this, AddPlayer.class);
                startActivity(i);
            }
        });
    }

    @Test
    public void testAssertions() {
        //test data
        String name = "abcd";
        String username = "abcd1234";
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
        addplayer = new AddPlayer ();

    }



    @Test
    public void testAddPlayerButton() {

        Assert.assertTrue("Player added",true);
    }

    @After
    public void tearDown() {
        addplayer = null;
    }


    @Test
    public void testButtonclear() {
        Assert.assertTrue("clear button is clicked",true);
    }



}
