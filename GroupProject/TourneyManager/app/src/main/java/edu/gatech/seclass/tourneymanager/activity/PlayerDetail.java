package edu.gatech.seclass.tourneymanager.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.model.Player;

/**
 * @author Katja Krivoruchko
 * @author Xiaolu Jiang
 *
 * Reference: instinctcoder.com
 */

public class PlayerDetail extends AppCompatActivity implements android.view.View.OnClickListener{

    Button buttonRegister ,  buttonDelete;
    Button buttonClear;
    EditText editTextName;
    EditText editTextUsername;
    EditText editTextPhone;
    EditText editTextDeck;
    EditText editTextTotal;
    private int _Student_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        buttonRegister = (Button) findViewById(R.id.buttonRegistor);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextDeck = (EditText) findViewById(R.id.editTextDeck);
        editTextTotal = (EditText) findViewById(R.id.editTextTotal);

        buttonRegister.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonClear.setOnClickListener(this);


        _Student_Id =0;
        Intent intent = getIntent();
        _Student_Id =intent.getIntExtra("player_Id", 0);
        PlayerRepo repo = new PlayerRepo(this);
        Player player = new Player();
        player = repo.getStudentById(_Student_Id);
        if (player.username != null){
            editTextUsername.setText(String.valueOf(player.username));}
        if (player.name != null){
            editTextName.setText(String.valueOf(player.name));}
        if (player.phone != null){
            editTextPhone.setText(String.valueOf(player.phone));}
        if (player.getDeck() != null) {
            editTextDeck.setText(String.valueOf(player.getDeck()));
        }
        if ((Integer)player.getTotal() != null) {
            editTextTotal.setText(String.valueOf(player.getTotal()));
        }
    }



    public void onClick(View view) {
        if (view == findViewById(R.id.buttonRegistor)){
            PlayerRepo playerRepo = new PlayerRepo(this);
            Player player = new Player();
            player.username=editTextUsername.getText().toString();
            player.phone = editTextPhone.getText().toString();
            player.name=editTextName.getText().toString();
            player.setDeck(editTextDeck.getText().toString());
            player.setTotal(Integer.parseInt(editTextTotal.getText().toString()));
            player.playerID =_Student_Id;

            if (_Student_Id==0){
                _Student_Id = playerRepo.insert(player);

                Toast.makeText(this,"New Player Added",Toast.LENGTH_SHORT).show();
            }else{

                playerRepo.update(player);
                Toast.makeText(this,"Player Record updated",Toast.LENGTH_SHORT).show();
            }
        }
        if (view== findViewById(R.id.buttonDelete)){
            PlayerRepo playerRepo = new PlayerRepo(this);
            playerRepo.delete(_Student_Id);
            Toast.makeText(this, "Player Record Deleted", Toast.LENGTH_SHORT);
            finish();
        } if (view== findViewById(R.id.buttonClear)){
            finish();
        }


    }

}
