package edu.gatech.seclass.tourneymanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.tourneymanager.R;


public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }
    public void buttonModeSelector(View view){
        //setContentView(R.layout.activity_tourney_calc);
        Intent intent = new Intent(splash.this, ModeSelector.class);
        startActivity(intent);

    }


}