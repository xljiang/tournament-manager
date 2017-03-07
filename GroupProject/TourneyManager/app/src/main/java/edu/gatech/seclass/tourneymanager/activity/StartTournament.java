package edu.gatech.seclass.tourneymanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.Manager;
import edu.gatech.seclass.tourneymanager.controller.MatchRepo;
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
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
    Integer num_player = 8;

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

        Spinner players = (Spinner)findViewById(R.id.players_dropdown);
        PlayerRepo playerRepo = new PlayerRepo(this);
        List<Map<String, String>> playerTotalList = playerRepo.getPlayerTotalList();
        String[] items;
        if (playerTotalList.size() <16){
            items = new String[]{"8"};
        }
        else{items = new String[]{"8", "16"};}

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        players.setAdapter(adapter);
        players.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View position,
                                       int pos, long id) {

                switch (pos) {
                    case 0:
                        num_player = 8;
                        break;
                    case 1:
                        num_player = 16;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

    }


    @Override
    public void onClick(View view) {
        int houseCut = convertEditTextToInteger(editTextHouseCut);
        int entry = convertEditTextToInteger(editTextEntryPrice);
        int houseProfit = entry *  num_player * houseCut /100;
        int totalPrizeAmount = entry *num_player - houseProfit;



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
            if (isValidInput(houseCut, entry)) {
                // show player list, house profit, total prize amount on the screen.
                textPlayerList.setText(players.toString()); // show name in the future //TODO
                textCurrentProfit.setText(String.valueOf(houseProfit));
                textCurrentTotalPrizeAmount.setText(String.valueOf(totalPrizeAmount));
            } else {
                if (houseCut < 0 || houseCut > 100) {
                    editTextHouseCut.setError("Invalid house cut percentage");
                }
                if (entry <= 0) {
                    editTextEntryPrice.setError("Invalid entry price");
                }
                textCurrentProfit.setText("");
                textCurrentTotalPrizeAmount.setText("");
            }
        }

        if (view == findViewById(R.id.btnStartTour)) {


            if (textCurrentProfit.getText().toString().isEmpty()
                    || textCurrentTotalPrizeAmount.getText().toString().isEmpty()
                    || textPlayerList.getText().toString().isEmpty()) {

                // if input is not checked or invalid
                Toast.makeText(this, "Please Check Entry First.", Toast.LENGTH_SHORT).show();

            } else {
                TournamentRepo tournamentRepo = new TournamentRepo(this);
                MatchRepo matchRepo = new MatchRepo(this);
                Manager manager = new Manager();

                if (matchRepo.getPlayerCount() != 0) { // has ongoing tournament, don't start
                    Toast.makeText(this, "Can not start! Already has an ongoing tournament!", Toast.LENGTH_SHORT).show();

                } else { // start the tournament
                    manager.startTournament(tournamentRepo, matchRepo, houseProfit, totalPrizeAmount, players);
                }
            }
        }
    }


    public void buttonReturn(View view){
        Intent intent = new Intent(StartTournament.this, ManagerMode.class);
        startActivity(intent);
    }

    // check if house cut and entry is a valid input
    private boolean isValidInput(int houseCut, int entry) {
        return entry > 0 && houseCut >= 0 && houseCut <= 100;
    }

    // convert an EditText (number) to Integer
    private int convertEditTextToInteger(EditText editText) {
        if (editText.getText().toString().equals("")) {
            return -1;
        }
        return Integer.parseInt(editText.getText().toString());
    }

}