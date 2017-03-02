package edu.gatech.seclass.tourneymanager.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.tourneymanager.R;


public class MatchList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list_manager_mode);

    }
    public void buttonReturn(View view){
        Intent intent = new Intent(MatchList.this, ManagerMode.class);
        startActivity(intent);

    }




}