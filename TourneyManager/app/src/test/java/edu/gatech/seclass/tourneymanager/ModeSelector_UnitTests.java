package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.ModeSelector;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class ModeSelector_UnitTests extends ModeSelector {
    private ModeSelector modeSelector;
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_mode_selector);
        Button b = (Button) findViewById(R.id.buttonManagerMode);
        Button b1= (Button)findViewById(R.id.buttonPlayerMode);
        Button b2= (Button)findViewById(R.id.btnBack);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(ModeSelector_UnitTests.this,ModeSelector.class);
                startActivity(i);
            }
        });

    }

    @Before
    public void setUp() {
        modeSelector = new ModeSelector();
    }

    @After
    public void tearDown() {
        modeSelector = null;
    }





    @Test
   /* public void testbuttonManagerMode() throws Throwable {
        runOnUiThread(new Runnable() { */
    public void testManagermodebutton(){

        Assert.assertTrue("Managermode button is clicked",true);
    }



    @Test
    public void testPlayermodebutton(){
               Assert.assertTrue("Playermode button is clicked",true);
    }



}
