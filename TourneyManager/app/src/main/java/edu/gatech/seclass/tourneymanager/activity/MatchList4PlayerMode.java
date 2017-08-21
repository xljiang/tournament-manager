package edu.gatech.seclass.tourneymanager.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.MatchRepo;

/**
 * @author Katja Krivoruchko
 * @author Xiaolu Jiang
 *
 */

public class MatchList4PlayerMode extends ListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list_player_mode);

        showList();
    }
    public void buttonReturn(View view){
        Intent intent = new Intent(MatchList4PlayerMode.this, ModeSelector.class);
        startActivity(intent);

    }

    public void showList() {
        MatchRepo matchRepo = new MatchRepo(this);
        List<Map<String, String>> matchList = matchRepo.getMatchList();
        if (matchList.size() != 0) {
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



}