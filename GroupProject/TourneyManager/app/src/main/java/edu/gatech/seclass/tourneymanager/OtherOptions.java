package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class OtherOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_options);

    }
    public void buttonReturn(View view){
        Intent intent = new Intent(OtherOptions.this, ManageTournament.class);
        startActivity(intent);

    }
    public void buttonStartManage(View view){
        Intent intent = new Intent(OtherOptions.this, StartTournament.class);
        startActivity(intent);

    }
    public void buttonEndManage(View view){
        Intent intent = new Intent(OtherOptions.this, EndTournament.class);
        startActivity(intent);

    }


}