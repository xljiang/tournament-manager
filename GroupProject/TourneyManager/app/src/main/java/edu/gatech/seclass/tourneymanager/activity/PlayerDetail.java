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
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
import edu.gatech.seclass.tourneymanager.model.Player;

/**
 * @author Katja Krivoruchko
 * @author Xiaolu Jiang
 *
 * Reference: instinctcoder.com
 */

public class PlayerDetail extends AppCompatActivity implements android.view.View.OnClickListener {

    Button buttonRegister;
    Button buttonClear;
    EditText editTextId;
    EditText editTextName;
    EditText editTextUsername;
    EditText editTextPhone;
    private int _Student_Id=0;
    String deck = "Engineer";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        buttonRegister = (Button) findViewById(R.id.buttonRegistor);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);

        buttonRegister.setOnClickListener(this);
        buttonClear.setOnClickListener(this);



        Spinner dropdown = (Spinner)findViewById(R.id.spinner_deck);
        String[] items = new String[]{"Engineer", "Buzz", "Sideways", "Wreck", "T", "RAT"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new OnItemSelectedListener() {

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

        _Student_Id =0;
        Intent intent = getIntent();
        _Student_Id =intent.getIntExtra("player_Id", 0);
        PlayerRepo repo = new PlayerRepo(this);
        Player player = new Player();
        player = repo.getStudentById(_Student_Id);
        if (player.getPlayerID() != 0) {
            editTextId.setText(String.valueOf(player.getPlayerID()));
        }
        if (player.username != null){
            editTextUsername.setText(String.valueOf(player.username));}
        if (player.name != null){
            editTextName.setText(String.valueOf(player.name));}
        if (player.phone != null){
            editTextPhone.setText(String.valueOf(player.phone));}
        if (player.getDeck() != null) {
                int spinnerPosition = adapter.getPosition(player.getDeck());
                dropdown.setSelection(spinnerPosition);
                //editTextDeck.setText((String.valueOf(player.getDeck())));
        }
        //if ((Integer)player.getTotal() != null) {
        //    editTextTotal.setText(String.valueOf(player.getTotal()));
        //}
    }



    public void onClick(View view) {
        if (view == findViewById(R.id.buttonRegistor)){
            PlayerRepo playerRepo = new PlayerRepo(this);
            Player player = new Player();
            player.username=editTextUsername.getText().toString();
            player.phone = editTextPhone.getText().toString();
            player.name=editTextName.getText().toString();
            player.setDeck(deck);

            //player.setTotal(Integer.parseInt(editTextTotal.getText().toString()));
            player.playerID =_Student_Id;

            if (_Student_Id==0){
                _Student_Id = playerRepo.insert(player);

                Toast.makeText(this,"New Player Added",Toast.LENGTH_SHORT).show();
            }else{

                playerRepo.update(player);
                Toast.makeText(this,"Player Record updated",Toast.LENGTH_SHORT).show();
            }
        }
        if (view== findViewById(R.id.buttonClear)){
            //TODO implement clear function
            finish();
        }


    }

}
