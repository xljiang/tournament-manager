package edu.gatech.seclass.tourneymanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.Manager;
import edu.gatech.seclass.tourneymanager.controller.MatchRepo;
import edu.gatech.seclass.tourneymanager.model.Match;

/**
 * Created by Xiaolu Jiang on 3/2/17.
 * @author Xiaolu Jiang
 */

public class MatchDetailOngoing extends AppCompatActivity implements View.OnClickListener {

    Button btnEndMatch, btnBack;
    TextView textViewRound;
    TextView textViewPlayer1;
    TextView textViewPlayer2;
    TextView textViewStatus;
    TextView textViewWinner;
    EditText editTextWinner;

    private int match_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail_ongoing);

        btnEndMatch = (Button) findViewById(R.id.btnEndMatch);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnEndMatch.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        // get match
        Intent intent = getIntent();
        match_Id =intent.getIntExtra("match_ID", 0);

        showMatch();

        // get winner (player1 or player2)
        editTextWinner = (EditText) findViewById(R.id.match_detail_choose_winner);

    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnEndMatch)) {
            endMatch();
            showMatch();
        } else if (view == findViewById(R.id.btnBack)) {
            Intent intent = new Intent(MatchDetailOngoing.this, MatchList4ManagerMode.class);
            startActivity(intent);
        }

    }

    private void showMatch() {
        MatchRepo matchRepo = new MatchRepo(this);
        Match match = new Match();
        match = matchRepo.getMatchById(match_Id);

        // set text view content
        textViewRound = (TextView) findViewById(R.id.match_detail_round);
        textViewPlayer1 = (TextView) findViewById(R.id.match_detail_player1);
        textViewPlayer2 = (TextView) findViewById(R.id.match_detail_player2);
        textViewStatus = (TextView) findViewById(R.id.match_detail_status);
        textViewWinner = (TextView) findViewById(R.id.match_detail_winner);

        textViewRound.setText(String.valueOf(match.getRound()));
        textViewPlayer1.setText(matchRepo.getNameByID(String.valueOf(match.getPlayer1ID())));
        textViewPlayer2.setText(matchRepo.getNameByID(String.valueOf(match.getPlayer2ID())));
        textViewStatus.setText(String.valueOf(match.getStatus()));
        if (match.getWinnerID() != 0) {
            textViewWinner.setText(matchRepo.getNameByID(String.valueOf(match.getWinnerID())));
        } else textViewWinner.setText("");
    }


    private void endMatch() {
        MatchRepo matchRepo = new MatchRepo(this);
        Match match = new Match();
        match = matchRepo.getMatchById(match_Id);
        int count = matchRepo.getPlayerCount();

        String status = match.getStatus();
        if (status.equals(Match.STATUS_ONGOING)) {
            // get winner id
            String winnerStr = editTextWinner.getText().toString();
            int winnerId = 0;
            int looserId = 0;
            if (winnerStr.equals("1")) {
                winnerId = match.getPlayer1ID();
                looserId = match.getPlayer2ID();
            } else if (winnerStr.equals("2")) {
                winnerId = match.getPlayer2ID();
                looserId = match.getPlayer1ID();
            } else {
                Toast.makeText(this, "Please choose valid winner: only input 1 or 2.", Toast.LENGTH_SHORT).show();
            }

            if (winnerId != 0) {
                // ------update current match-------
                // update winnerId and status
                match.setWinnerID(winnerId);
                match.setStatus(Match.STATUS_FINISHED);
                // update database
                matchRepo.update(match);

                // ------update following match------
                //put winner information to the next attending match
                //also need to put looser information to the final and 3rd place match
                // if already in final or 3rd place match, do nothing here
                int currMatchId = match_Id;
                Manager manager = new Manager();
                manager.putPlayerIntoNextMatch(matchRepo, currMatchId, count, winnerId, looserId);
            }
        } else {
            Toast.makeText(this, "The match is already finished, CAN NOT change the result!", Toast.LENGTH_SHORT).show();
        }
    }
    





}
