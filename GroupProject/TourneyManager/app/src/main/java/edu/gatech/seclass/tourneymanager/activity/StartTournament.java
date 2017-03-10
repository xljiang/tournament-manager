package edu.gatech.seclass.tourneymanager.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

    Button btnCheckEntry, btnClear, btnStartTour;

    private EditText editTextHouseCut;
    private EditText editTextEntryPrice;
    private TextView textPlayerList;
    private TextView textCurrentProfit;
    private TextView textCurrentTotalPrizeAmount;

    Integer num_player = 8;
    String playerText = "";
    Integer num_players_selected = 0;
    ArrayList<Integer> selectedPlayers = new ArrayList<Integer>();
    PlayerRepo playerRepo = new PlayerRepo(this);
    int houseCut = 0;
    int houseProfit = 0;
    int entry = 0;
    int totalPrizeAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_start_tournament);

        btnCheckEntry = (Button) findViewById(R.id.btnCheckEntry);
        btnStartTour = (Button) findViewById(R.id.btnStartTour);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnCheckEntry.setOnClickListener(this);
        btnStartTour.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        editTextHouseCut = (EditText) findViewById(R.id.editTextHouseCut);
        editTextEntryPrice = (EditText) findViewById(R.id.editTextEntryPrice);

        textPlayerList = (TextView) findViewById(R.id.textPlayerList);
        textCurrentProfit = (TextView) findViewById(R.id.textCurrentProfit);
        textCurrentTotalPrizeAmount = (TextView) findViewById(R.id.textCurrentTotalPrizeAmount);
        //textSelectionInstruction = (TextView) findViewById(R.id.textSelectInstruction);





        Spinner players = (Spinner)findViewById(R.id.players_dropdown);

        List<Map<String, String>> playerTotalList = playerRepo.getPlayerTotalList();
        String[] items;
        if (playerTotalList.size() <16){
            items = new String[]{"8-player tourney (not enough players for 16)"};
        }
        else{items = new String[]{"8-player tourney", "16-player tourney"};}

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        players.setAdapter(adapter);
        players.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View position,
                                       int pos, long id) {

                switch (pos) {
                    case 0:
                        num_player = 8;
                        //textSelectionInstruction.setText("Please select 8 players for the tourney:");
                        break;
                    case 1:
                        num_player = 16;
                        //textSelectionInstruction.setText("Please select 16 players for the tourney:");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });




        final Spinner playersList = (Spinner)findViewById(R.id.spinnerPlayerList);

        final ArrayList items2 = playerRepo.getPlayerUsernames();
        final String emp = "Please select a player for the tourney:";
        items2.add(0, emp);




        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        playersList.setAdapter(adapter2);
        playersList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View position,
                                       int pos, long id) {
                Integer selectedID = 0;
                if (pos != 0) {
                    //Instead of makeText, remove the username from list and add it to the textbox below
                    //Once the number of items added is equal num_players, stop (show message?)

                    playerText = playerText + " " + parent.getItemAtPosition(pos).toString() + ", ";
                    textPlayerList.setText(playerText);


                    selectedID = playerRepo.getIDbyUsername(parent.getItemAtPosition(pos).toString());
                    num_players_selected = num_players_selected + 1;
                    selectedPlayers.add(selectedID);

                    items2.remove(pos);
                    playersList.setAdapter(adapter2);


                }
                if (num_players_selected == num_player){
                    //Remove all remaining players from the dropdown list
                    items2.clear();
                    //remove the last comma
                    playerText = playerText.substring(0, playerText.length() - 1);
                    textPlayerList.setText(playerText);
                    String done = "(All " + num_player.toString() + " players selected)";
                    items2.add(0, done);

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
        houseCut = convertEditTextToInteger(editTextHouseCut);
        entry = convertEditTextToInteger(editTextEntryPrice);
        houseProfit = entry *  num_player * houseCut /100;
        totalPrizeAmount = entry *num_player - houseProfit;


        ArrayList<Integer> selectedPlayerIDs = new ArrayList<Integer>();


        if (view == findViewById(R.id.btnCheckEntry)) {
            if (isValidInput(houseCut, entry)) {
                // show player list, house profit, total prize amount on the screen.
                //textPlayerList.setText(players.toString()); //
                textCurrentProfit.setText("Current House Profit: " + String.valueOf(houseProfit));
                textCurrentTotalPrizeAmount.setText("Total Prize Amount: " + String.valueOf(totalPrizeAmount));
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
                    || textPlayerList.getText().toString().isEmpty()){

                // if input is not checked or invalid
                Toast.makeText(this, "Please Check Entry First.", Toast.LENGTH_SHORT).show();

            }
            else if(num_player != num_players_selected){
                //if there are fewer than 8 or 16 players selected
                Toast.makeText(this, "Please make sure to select " + num_player.toString() + " players for the tournament.", Toast.LENGTH_SHORT).show();

            }

            else {
                final TournamentRepo tournamentRepo = new TournamentRepo(this);
                final MatchRepo matchRepo = new MatchRepo(this);
                final Manager manager = new Manager();

                if (matchRepo.getPlayerCount() != 0) { // has ongoing tournament, don't start
                    Toast.makeText(this, "Can not start! Already has an ongoing tournament!", Toast.LENGTH_SHORT).show();

                } else { // start the tournament
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Start Tournament?")
                            .setTitle("Woodruff Lounge")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    manager.startTournament(tournamentRepo, matchRepo, houseProfit, totalPrizeAmount, selectedPlayers);
                                    Intent intent = new Intent(StartTournament.this, MatchList4ManagerMode.class);
                                    startActivity(intent);
                                }

                            })
                            .setNeutralButton("No", null);
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        }
        if (view == findViewById(R.id.btnClear)) {
            Intent refresh = new Intent(this, StartTournament.class);
            startActivity(refresh);
            this.finish();
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