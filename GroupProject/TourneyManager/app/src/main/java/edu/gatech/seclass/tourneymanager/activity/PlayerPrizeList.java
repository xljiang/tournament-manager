package edu.gatech.seclass.tourneymanager.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
import edu.gatech.seclass.tourneymanager.controller.PrizeRepo;
import edu.gatech.seclass.tourneymanager.model.Player;


public class PlayerPrizeList extends ListActivity implements View.OnClickListener {

    TextView textViewPlayerName;
    Button btnUpdate, buttonDelete;

    private int player_Id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_prize_list);

        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        btnUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);


        Intent intent = getIntent();
        player_Id =intent.getIntExtra("player_Id", 0);

        // get player
        PlayerRepo playerRepo = new PlayerRepo(this);
        Player player = new Player();
        player = playerRepo.getStudentById(player_Id);

        textViewPlayerName = (TextView)findViewById(R.id.player_name);
        textViewPlayerName.setText(String.valueOf(player.getName()));

        showPlayerPrizeList(player_Id);
    }


    public void showPlayerPrizeList(int playerId) {
        PrizeRepo prizeRepo = new PrizeRepo(this);
        List<Map<String, String>> playerPrizeList = prizeRepo.getIndividualPlayerPrizeList(playerId);
        if (playerPrizeList.size() != 0) {
            ListAdapter adapter = new SimpleAdapter(this,
                    playerPrizeList,
                    R.layout.view_prize_entry,
                    new String[] {"runningId", "prizeType", "prizeAmount"},
                    new int[] {R.id.running_id, R.id.prize_type, R.id.prize_amount});
            setListAdapter(adapter);
        } else {
            Toast.makeText(this, "No record! This player didn't win any prize!", Toast.LENGTH_LONG).show();
        }
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnUpdate)) {
            Intent intent = new Intent(PlayerPrizeList.this, PlayerDetail.class);
            intent.putExtra("player_Id", player_Id);
            startActivity(intent);
        }
        if (view == findViewById(R.id.buttonDelete)) {
            PlayerRepo playerRepo = new PlayerRepo(this);
            playerRepo.delete(player_Id);
            Toast.makeText(this, "Player Record Deleted", Toast.LENGTH_SHORT).show();
            finish();
        }

    }


}