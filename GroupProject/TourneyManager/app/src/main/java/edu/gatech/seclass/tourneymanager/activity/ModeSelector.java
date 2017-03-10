package edu.gatech.seclass.tourneymanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.Manager;
import edu.gatech.seclass.tourneymanager.controller.MatchRepo;

/**
 * @author Katja Krivoruchko
 *
 */

public class ModeSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selector);

    }
    public void buttonReturn(View view){
        Intent intent = new Intent(ModeSelector.this, splash.class);
        startActivity(intent);

    }
    public void buttonManagerMode(View view){
        Manager manager = new Manager();
        Intent intent = new Intent();
        if (manager.hasOngoingTournament(this)) {
            intent = new Intent(ModeSelector.this, MatchList4ManagerMode.class);
        } else {
            intent = new Intent(ModeSelector.this, ManagerMode.class);
        }
        startActivity(intent);

    }
    public void buttonPlayerMode(View view){
        Manager manager = new Manager();
        Intent intent = new Intent();
        if (manager.hasOngoingTournament(this)) {
            intent = new Intent(ModeSelector.this, MatchList4PlayerMode.class);
        } else {
            intent = new Intent(ModeSelector.this, PlayerList4PlayerMode.class);
        }
        startActivity(intent);
    }


}