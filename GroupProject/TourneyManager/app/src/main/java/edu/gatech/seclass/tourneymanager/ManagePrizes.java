package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class ManagePrizes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_prizes);

    }
    public void buttonReturn(View view){
        Intent intent = new Intent(ManagePrizes.this, ManageTournament.class);
        startActivity(intent);

    }


}