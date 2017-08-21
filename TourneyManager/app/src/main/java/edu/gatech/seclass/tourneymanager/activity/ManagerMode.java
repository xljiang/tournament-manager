package edu.gatech.seclass.tourneymanager.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;

/**
 * @author Katja Krivoruchko
 */

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
        Intent intent = new Intent(ManagerMode.this, PlayerList4ManagerMode.class);
        startActivity(intent);

    }
    public void buttonProfitHistory (View view){
        Intent intent = new Intent(ManagerMode.this, ProfitHistory.class);
        startActivity(intent);

    }
    public void buttonManageTournament(View view){
        PlayerRepo playerRepo = new PlayerRepo(this);
        List<Map<String, String>> playerTotalList = playerRepo.getPlayerTotalList();
        if (playerTotalList.size() <8){
            Toast.makeText(this,"At least 8 players required!",Toast.LENGTH_SHORT).show();
        }
        else{Intent intent = new Intent(ManagerMode.this, StartTournament.class);
            startActivity(intent);
        }

            }


}