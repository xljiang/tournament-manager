package edu.gatech.seclass.tourneymanager;

/**
 * Code from instinctcoder.com
 * Edited by Katja Krivoruchko for CS 6300 Spring 2017
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class ManagerMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_mode);

    }
    public void buttonReturn(View view){
        Intent intent = new Intent(ManagerMode.this, ModeSelector.class);
        startActivity(intent);

    }
    public void buttonAddPlayer (View view){
        Intent intent = new Intent(ManagerMode.this, ListPlayers.class);
        startActivity(intent);

    }

    public void buttonManageTournament(View view){
        Intent intent = new Intent(ManagerMode.this, ManageTournament.class);
        startActivity(intent);
    }


}