package edu.gatech.seclass.tourneymanager;

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
        Intent intent = new Intent(ManagerMode.this, splash.class);
        startActivity(intent);

    }
    public void buttonAddPlayer (View view){
        Intent intent = new Intent(ManagerMode.this, AddPlayer.class);
        startActivity(intent);

    }
    public void buttonDeletePlayer(View view){
        Intent intent = new Intent(ManagerMode.this, DeletePlayer.class);
        startActivity(intent);
    }
    public void buttonManageTournament(View view){
        Intent intent = new Intent(ManagerMode.this, ManageTournament.class);
        startActivity(intent);
    }


}