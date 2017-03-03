package edu.gatech.seclass.tourneymanager.activity;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.MatchRepo;
import edu.gatech.seclass.tourneymanager.model.Match;


public class MatchList4ManagerMode extends ListActivity implements View.OnClickListener {

    Button btnEndTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list_manager_mode);

        btnEndTour = (Button) findViewById(R.id.btnEndTour);
        btnEndTour.setOnClickListener(this);

        showList();
    }
    public void buttonReturn(View view){
        Intent intent = new Intent(MatchList4ManagerMode.this, ManagerMode.class);
        startActivity(intent);

    }

    public void showList() {
        final MatchRepo matchRepo = new MatchRepo(this);
        List<Map<String, String>> matchList = matchRepo.getMatchList();
        if (matchList.size() != 0) {
            ListView lv = getListView();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    TextView match_id = (TextView) view.findViewById(R.id.player_id);
                    int matchId = Integer.parseInt(match_id.getText().toString());
                    Match match = new Match();
                    match = matchRepo.getMatchById(matchId);
                    String status = match.getStatus();

                    Intent intent;
                    if (status.equals(Match.STATUS_READY)) {
                        intent = new Intent(getApplicationContext(), MatchDetailReady.class);
                        intent.putExtra("match_ID", matchId);
                        startActivity(intent);
                    } else if (status.equals(Match.STATUS_ONGOING)) {
                        intent = new Intent(getApplicationContext(), MatchDetailOngoing.class);
                        intent.putExtra("match_ID", matchId);
                        startActivity(intent);
                    } else if (status.equals(Match.STATUS_FINISHED)) {
                        intent = new Intent(getApplicationContext(), MatchDetailFinished.class);
                        intent.putExtra("match_ID", matchId);
                        startActivity(intent);
                    }

                }
            });

            ListAdapter adapter = new SimpleAdapter(this,
                    matchList,
                    R.layout.view_match_entry,
                    new String[] {"id", "player1name", "player2name", "round", "winnerName", "status"},
                    new int[] {R.id.match_id, R.id.player1_name, R.id.player2_name, R.id.match_round,
                            R.id.match_winner, R.id.match_status});

            setListAdapter(adapter);

        } else {
            Toast.makeText(this, "No Ongoing Tournament!", Toast.LENGTH_LONG).show();
        }
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnEndTour)) {
            //TODO

            // show final result

            // check if end properly or terminated early
            // completed tournament -> record to db
            // incompleted tournament -> refund

            Toast.makeText(this, "Tournament Ended!", Toast.LENGTH_SHORT);

        }
    }




}