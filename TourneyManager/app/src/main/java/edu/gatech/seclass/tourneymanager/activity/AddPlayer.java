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

public class AddPlayer extends AppCompatActivity implements android.view.View.OnClickListener {

    Button buttonRegister;
    Button buttonClear;
    //EditText editTextId;
    EditText editTextName;
    EditText editTextUsername;
    EditText editTextPhone;
    String deck = "Engineer";
    Spinner spinnerDropdown;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        buttonRegister = (Button) findViewById(R.id.buttonRegistor);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        //editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);

        buttonRegister.setOnClickListener(this);
        buttonClear.setOnClickListener(this);



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

    }



    public void onClick(View view) {
        if (view == findViewById(R.id.buttonRegistor)){
            PlayerRepo playerRepo = new PlayerRepo(this);
            Player player = new Player();
            ArrayList items2 = playerRepo.getPlayerUsernames();


            if (editTextName.getText().toString().trim().length() == 0){
                editTextName.setError("Please enter a value for name!");
            }
            else if (editTextUsername.getText().toString().trim().length() == 0){
                editTextUsername.setError("Please enter a value for username!");
            }
            else if (items2.contains(editTextUsername.getText().toString())) {
                editTextUsername.setError("Username already exists!");
            }


            else {
                // get player properties from UI
                //player.setPlayerID(Integer.parseInt(editTextId.getText().toString()));
                player.setUsername(editTextUsername.getText().toString());
                player.setName(editTextName.getText().toString());
                player.setPhone(editTextPhone.getText().toString());
                player.setDeck(deck);

                // add new player to database
                playerRepo.insert(player);

                Toast.makeText(this, "New Player Added", Toast.LENGTH_SHORT).show();
            }
        }

        if (view== findViewById(R.id.buttonClear)){

            //editTextId.setText("");
            editTextUsername.setText(String.valueOf(""));
            editTextName.setText(String.valueOf(""));
            editTextPhone.setText(String.valueOf(""));
            spinnerDropdown.setSelection(0);

        }

    }

    public void buttonReturn(View view){
        Intent intent = new Intent(AddPlayer.this, PlayerList4ManagerMode.class);
        startActivity(intent);
    }




}
