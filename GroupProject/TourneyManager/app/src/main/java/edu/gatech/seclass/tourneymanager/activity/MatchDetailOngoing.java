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
import edu.gatech.seclass.tourneymanager.controller.MatchRepo;
import edu.gatech.seclass.tourneymanager.model.Match;

/**
 * Created by Xiaolu Jiang on 3/2/17.
 * @author Xiaolu Jiang
 */

public class MatchDetailOngoing extends AppCompatActivity implements View.OnClickListener {

    Button btnEndMatch, btnRefreshMatch;
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
        btnRefreshMatch = (Button) findViewById(R.id.btnRefreshMatch);

        btnEndMatch.setOnClickListener(this);
        btnRefreshMatch.setOnClickListener(this);

        // get match
        Intent intent = getIntent();
        match_Id =intent.getIntExtra("match_ID", 0);

        showMatch();

        // get winner (player1 or player2)
        editTextWinner = (EditText) findViewById(R.id.match_detail_winner);

    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnEndMatch)) {
            endMatch();
        } else if (view == findViewById(R.id.btnRefreshMatch)) {
            showMatch();
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
        textViewPlayer1.setText(String.valueOf(match.getPlayer1ID()));
        textViewPlayer2.setText(String.valueOf(match.getPlayer2ID()));
        textViewStatus.setText(String.valueOf(match.getStatus()));
        textViewWinner.setText(String.valueOf(match.getWinnerID()));
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
                putPlayerIntoNextMatch(matchRepo, currMatchId, count, winnerId, looserId);
            }
        } else {
            Toast.makeText(this, "The match is already finished, CAN NOT change the result!", Toast.LENGTH_SHORT).show();
        }
    }
    

    //put winner information to the next attending match
    //also need to put looser information to the final and 3rd place match
    // if current match is final or 3rd place match, do nothing
    private void putPlayerIntoNextMatch(MatchRepo matchRepo, int currMatchId, int count, int winnerId, int looserId) {
        Match nextMatch1 = new Match();
        Match nextMatch2 = new Match();
        if (count == 8) {
            switch (currMatchId) {
                case 1:
                    nextMatch1 = matchRepo.getMatchById(5);
                    nextMatch1.setPlayer1ID(winnerId);
                    matchRepo.update(nextMatch1);
                    break;
                case 2:
                    nextMatch1 = matchRepo.getMatchById(5);
                    nextMatch1.setPlayer2ID(winnerId);
                    nextMatch1.setStatus(Match.STATUS_READY);
                    matchRepo.update(nextMatch1);
                    break;
                case 3:
                    nextMatch1 = matchRepo.getMatchById(6);
                    nextMatch1.setPlayer1ID(winnerId);
                    matchRepo.update(nextMatch1);
                    break;
                case 4:
                    nextMatch1 = matchRepo.getMatchById(6);
                    nextMatch1.setPlayer2ID(winnerId);
                    nextMatch1.setStatus(Match.STATUS_READY);
                    matchRepo.update(nextMatch1);
                    break;
                case 5:
                    nextMatch1 = matchRepo.getMatchById(8);
                    nextMatch1.setPlayer1ID(winnerId);
                    nextMatch2 = matchRepo.getMatchById(7);
                    nextMatch2.setPlayer1ID(looserId);
                    matchRepo.update(nextMatch1);
                    matchRepo.update(nextMatch2);
                    break;
                case 6:
                    nextMatch1 = matchRepo.getMatchById(8);
                    nextMatch1.setPlayer2ID(winnerId);
                    nextMatch1.setStatus(Match.STATUS_READY);
                    nextMatch2 = matchRepo.getMatchById(7);
                    nextMatch2.setPlayer2ID(looserId);
                    nextMatch2.setStatus(Match.STATUS_READY);
                    matchRepo.update(nextMatch1);
                    matchRepo.update(nextMatch2);
                    break;
                case 7:
                    return;
                case 8:
                    return;
            }
        } else if (count == 16) {
            // TODO
        }

    }



}
