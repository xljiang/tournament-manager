package edu.gatech.seclass.tourneymanager.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
import edu.gatech.seclass.tourneymanager.model.Player;

/**
 * @author Katja Krivoruchko
 * @author Xiaolu Jiang
 *
 * Reference: instinctcoder.com
 */

public class UpdatePlayer extends AppCompatActivity implements View.OnClickListener {

    Button buttonUpdatePlayer;
    Button buttonDeletePlayer;
    //EditText editTextId;
    EditText editTextName;
    EditText editTextUsername;
    EditText editTextPhone;
    String deck = "Engineer";
    Spinner spinnerDropdown;

    private int player_Id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_player);

        buttonUpdatePlayer = (Button) findViewById(R.id.buttonUpdatePlayer);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);

        buttonUpdatePlayer.setOnClickListener(this);

        spinnerDropdown = (Spinner)findViewById(R.id.spinner_deck);
        String[] items = new String[]{"Engineer", "Buzz", "Sideways", "Wreck", "T", "RAT"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerDropdown.setAdapter(adapter);
        spinnerDropdown.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View position,
                                       int pos, long id) {

                switch (pos) {
                    case 0:
                        deck = "Engineer";
                        break;
                    case 1:
                        deck = "Buzz";
                        break;
                    case 2:
                        deck = "Sideways";
                        break;
                    case 3:
                        deck = "Wreck";
                        break;
                    case 4:
                        deck = "T";
                        break;
                    case 5:
                        deck = "RAT";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        Intent intent = getIntent();
        player_Id = intent.getIntExtra("player_Id", 0);

        System.out.println(player_Id);
        PlayerRepo playerRepo = new PlayerRepo(this);
        Player player = new Player();
        player = playerRepo.getStudentById(player_Id);
        if (player.getUsername() != null) {
            editTextUsername.setText(String.valueOf(player.getUsername()));
        }
        if (player.getName() != null) {
            editTextName.setText(String.valueOf(player.getName()));
        }
        if (player.getPhone() != null) {
            editTextPhone.setText(String.valueOf(player.getPhone()));
        }
        if (player.getDeck() != null) {
            int spinnerPosition = adapter.getPosition(player.getDeck());
            spinnerDropdown.setSelection(spinnerPosition);
        }

    }



    public void onClick(View view) {

        if (view == findViewById(R.id.buttonUpdatePlayer)){
            PlayerRepo playerRepo = new PlayerRepo(this);
            Player player = new Player();
            player = playerRepo.getStudentById(player_Id);
            String old_username = String.valueOf(player.getUsername());

            // get player properties from UI
            //player.setPlayerID(Integer.parseInt(editTextId.getText().toString()));
            ArrayList items2 = playerRepo.getPlayerUsernames();
            items2.remove(player.getUsername());



            if ((items2.contains(editTextUsername.getText().toString()))) {
                editTextUsername.setError("Username already exists!");
            }
            if (editTextName.getText().toString().trim().length() == 0){
                editTextName.setError("Please enter a value for name!");
            }
            if (editTextUsername.getText().toString().trim().length() == 0){
                editTextUsername.setError("Please enter a value for username!");
            }
            else {
                player.setUsername(editTextUsername.getText().toString());
                player.setName(editTextName.getText().toString());
                player.setPhone(editTextPhone.getText().toString());
                player.setDeck(deck);

                // update player info to database
                playerRepo.update(player);

                Toast.makeText(this, "Player Information Updated", Toast.LENGTH_SHORT).show();
            }
        }



    }

    public void buttonReturn(View view){
        Intent intent = new Intent(UpdatePlayer.this, PlayerList4ManagerMode.class);
        startActivity(intent);
    }




}
