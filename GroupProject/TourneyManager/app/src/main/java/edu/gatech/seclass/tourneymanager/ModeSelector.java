package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


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
        Intent intent = new Intent(ModeSelector.this, ManagerMode.class);
        startActivity(intent);

    }
    public void buttonPlayerMode(View view){
        Intent intent = new Intent(ModeSelector.this, PlayerMode.class);
        startActivity(intent);
    }


}