package edu.gatech.seclass.tourneymanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.MatchRepo;
import edu.gatech.seclass.tourneymanager.model.Match;

/**
 * Created by Xiaolu Jiang on 3/3/17.
 * @author Xiaolu Jiang
 * @author Katja Krivoruchko
 */

public class MatchDetailNotReady extends AppCompatActivity implements android.view.View.OnClickListener  {

    Button btnBack;
    TextView textViewRound;
    TextView textViewPlayer1;
    TextView textViewPlayer2;
    TextView textViewStatus;
    //TextView textViewWinner;

    private int match_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail_not_ready);

       btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(this);

        // get match
        Intent intent = getIntent();
        match_Id = intent.getIntExtra("match_ID", 0);

        MatchRepo matchRepo = new MatchRepo(this);
        Match match = new Match();
        match = matchRepo.getMatchById(match_Id);

        // set text view content
        textViewRound = (TextView) findViewById(R.id.match_detail_round);
        textViewPlayer1 = (TextView) findViewById(R.id.match_detail_player1);
        textViewPlayer2 = (TextView) findViewById(R.id.match_detail_player2);
        textViewStatus = (TextView) findViewById(R.id.match_detail_status);
        //textViewWinner = (TextView) findViewById(R.id.match_detail_winner);

        textViewRound.setText(String.valueOf(match.getRound()));
        textViewPlayer1.setText(matchRepo.getNameByID(String.valueOf(match.getPlayer1ID())));
        textViewPlayer2.setText(matchRepo.getNameByID(String.valueOf(match.getPlayer2ID())));
        textViewStatus.setText("Not Ready");
        //textViewWinner.setText(String.valueOf(match.getWinnerID()));
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnBack)) {
            Intent intent = new Intent(MatchDetailNotReady.this, MatchList4ManagerMode.class);
            startActivity(intent);
        }
    }
}