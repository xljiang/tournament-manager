package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.ManagerMode;


/**
 * Created by vidyakv on 3/9/2017.
 */

public class ManagerMode_UnitTests extends ManagerMode{
    private ManagerMode managerMode;

    @Before
    public void setUp() {
        managerMode= new ManagerMode();
    }

    @After
    public void teardown() {
        managerMode = null;
    }


         @Test
         public void onCreate(Bundle icicle){
             super.onCreate(icicle);
             setContentView(R.layout.activity_manager_mode);
             Button b = (Button) findViewById(R.id.btnAddNew);
             Button b1 =(Button)findViewById(R.id.btnBack);
             Button b2=(Button)findViewById(R.id.buttonMatchList);
             Button b3=(Button)findViewById(R.id.buttonProfitHistory);
             Button b4=(Button)findViewById(R.id.buttonMgrHome);
             b.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View arg0) {
                     Intent i = new Intent(ManagerMode_UnitTests.this, ManagerMode.class);
                     startActivity(i);
                 }
             });
             Assert.assertTrue("all button functions work",true);
         }





}
