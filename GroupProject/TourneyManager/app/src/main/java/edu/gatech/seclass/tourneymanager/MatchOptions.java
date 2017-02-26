package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MatchOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_options);

    }
    public void buttonReturn(View view){
        Intent intent = new Intent(MatchOptions.this, ManageTournament.class);
        startActivity(intent);

    }



}