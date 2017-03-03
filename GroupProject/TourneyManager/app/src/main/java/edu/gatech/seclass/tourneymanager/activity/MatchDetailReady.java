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
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
import edu.gatech.seclass.tourneymanager.model.Match;

import static edu.gatech.seclass.tourneymanager.R.id.buttonClear;
import static edu.gatech.seclass.tourneymanager.R.id.buttonDelete;
import static edu.gatech.seclass.tourneymanager.R.id.editTextName;
import static edu.gatech.seclass.tourneymanager.R.id.editTextUsername;

/**
 * Created by Xiaolu Jiang on 3/2/17.
 */

public class MatchDetailReady extends AppCompatActivity implements android.view.View.OnClickListener {

    Button btnStartMatch, btnRefreshMatch;
    TextView textViewRound;
    TextView textViewPlayer1;
    TextView textViewPlayer2;
    TextView textViewStatus;

    private int match_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail_ready);

        btnStartMatch = (Button) findViewById(R.id.btnStartMatch);
        btnRefreshMatch = (Button) findViewById(R.id.btnRefreshMatch);

        btnStartMatch.setOnClickListener(this);
        btnRefreshMatch.setOnClickListener(this);

        // get match
        Intent intent = getIntent();
        match_Id =intent.getIntExtra("match_ID", 0);

        showMatch();

    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnStartMatch)) {
            startMatch();
        } else if (view == findViewById(R.id.btnRefreshMatch)) {
            showMatch();
        }

    }

    private void startMatch() {
        MatchRepo matchRepo = new MatchRepo(this);
        Match match = new Match();
        match = matchRepo.getMatchById(match_Id);

        String status = match.getStatus();
        if (status.equals(Match.STATUS_READY)) {
            match.setStatus(Match.STATUS_ONGOING);
            matchRepo.update(match);
        } else {
            Toast.makeText(this, "The match is ongoing", Toast.LENGTH_SHORT).show();
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

        textViewRound.setText(String.valueOf(match.getRound()));
        textViewPlayer1.setText(String.valueOf(match.getPlayer1ID()));
        textViewPlayer2.setText(String.valueOf(match.getPlayer2ID()));
        textViewStatus.setText(String.valueOf(match.getStatus()));
    }


}