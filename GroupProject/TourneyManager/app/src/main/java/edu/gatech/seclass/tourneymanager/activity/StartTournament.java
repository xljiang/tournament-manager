package edu.gatech.seclass.tourneymanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.Manager;
import edu.gatech.seclass.tourneymanager.controller.MatchRepo;
import edu.gatech.seclass.tourneymanager.controller.TournamentRepo;

/**
 * Created by Katja Krivoruchko
 * @author Xiaolu Jiang
 */
public class StartTournament extends AppCompatActivity implements View.OnClickListener {

    Button btnCheckEntry, btnStartTour;

    private EditText editTextHouseCut;
    private EditText editTextEntryPrice;
    private TextView textPlayerList;
    private TextView textCurrentProfit;
    private TextView textCurrentTotalPrizeAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_tournament);

        btnCheckEntry = (Button) findViewById(R.id.btnCheckEntry);
        btnStartTour = (Button) findViewById(R.id.btnStartTour);

        btnCheckEntry.setOnClickListener(this);
        btnStartTour.setOnClickListener(this);

        editTextHouseCut = (EditText) findViewById(R.id.editTextHouseCut);
        editTextEntryPrice = (EditText) findViewById(R.id.editTextEntryPrice);

        textPlayerList = (TextView) findViewById(R.id.textPlayerList);
        textCurrentProfit = (TextView) findViewById(R.id.textCurrentProfit);
        textCurrentTotalPrizeAmount = (TextView) findViewById(R.id.textCurrentTotalPrizeAmount);

    }


    @Override
    public void onClick(View view) {
        int houseCut = Integer.parseInt(editTextHouseCut.getText().toString());
        int entry = Integer.parseInt(editTextEntryPrice.getText().toString());
        int houseProfit = entry * houseCut /100;
        int totalPrizeAmount = entry - houseProfit;

        //TODO get player list from UI selection
        ArrayList<Integer> players = new ArrayList<Integer>();
        players.add(1);
        players.add(2);
        players.add(3);
        players.add(4);
        players.add(5);
        players.add(6);
        players.add(7);
        players.add(8);

        if (view == findViewById(R.id.btnCheckEntry)) {
            // show player list, house profit, total prize amount on the screen.
            textPlayerList.setText(players.toString()); // show name in the future //TODO
            textCurrentProfit.setText(String.valueOf(houseProfit));
            textCurrentTotalPrizeAmount.setText(String.valueOf(totalPrizeAmount));
        }

        if (view == findViewById(R.id.btnStartTour)) {
            TournamentRepo tournamentRepo = new TournamentRepo(this);
            MatchRepo matchRepo = new MatchRepo(this);
            Manager manager = new Manager();

            if (matchRepo.getPlayerCount() != 0) { // has ongoing tournament, don't start
                Toast.makeText(this,"Can not start! Already has an ongoing tournament!",Toast.LENGTH_SHORT).show();

            } else { // start the tournament
                manager.startTournament(tournamentRepo, matchRepo, houseProfit, totalPrizeAmount, players);
            }
        }
    }


    public void buttonReturn(View view){
        Intent intent = new Intent(StartTournament.this, ManagerMode.class);
        startActivity(intent);
    }

}