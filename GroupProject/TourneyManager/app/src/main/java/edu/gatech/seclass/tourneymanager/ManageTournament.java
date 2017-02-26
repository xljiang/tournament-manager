package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class ManageTournament extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_tournament);

    }
    public void buttonReturn(View view){
        Intent intent = new Intent(ManageTournament.this, ManagerMode.class);
        startActivity(intent);

    }
    public void buttonManagePlayers (View view){
        Intent intent = new Intent(ManageTournament.this, ManagePlayers.class);
        startActivity(intent);

    }
    public void buttonPrizes (View view){
        Intent intent = new Intent(ManageTournament.this, ManagePrizes.class);
        startActivity(intent);
    }
    public void buttonMatchOptions(View view){
        Intent intent = new Intent(ManageTournament.this, MatchOptions.class);
        startActivity(intent);
    }
    public void buttonOther(View view){
        Intent intent = new Intent(ManageTournament.this, OtherOptions.class);
        startActivity(intent);
    }


}