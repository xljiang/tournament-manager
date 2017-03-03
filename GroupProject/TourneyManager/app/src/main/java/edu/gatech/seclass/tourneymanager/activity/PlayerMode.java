package edu.gatech.seclass.tourneymanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.tourneymanager.R;

/**
 * @author Katja Krivoruchko
 *
 */

public class PlayerMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_mode);

    }
    public void buttonReturn(View view){
        Intent intent = new Intent(PlayerMode.this, ModeSelector.class);
        startActivity(intent);

    }
    public void buttonOngoingTournament (View view){
        Intent intent = new Intent(PlayerMode.this, MatchList4PlayerMode.class);
        startActivity(intent);

    }
    public void buttonPlayerList (View view){
        Intent intent = new Intent(PlayerMode.this, PlayerList4PlayerMode.class);
        startActivity(intent);
    }


}