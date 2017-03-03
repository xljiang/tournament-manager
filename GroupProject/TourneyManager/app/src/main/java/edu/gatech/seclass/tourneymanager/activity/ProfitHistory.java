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
import edu.gatech.seclass.tourneymanager.controller.TournamentRepo;
import edu.gatech.seclass.tourneymanager.model.Tournament;

/**
 * Created by Xiaolu Jiang on 2/28/17.
 * @author Xiaolu Jiang
 */

public class ProfitHistory extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit_history);

        showList();
    }
    public void buttonReturn(View view){
        Intent intent = new Intent(ProfitHistory.this, ManagerMode.class);
        startActivity(intent);

    }

    public void showList() {
        TournamentRepo tournamentRepo = new TournamentRepo(this);
        List<Map<String, String>> tournamentList = tournamentRepo.getTourProfitHistoryList();
        if (tournamentList.size() != 0) {
            ListAdapter adapter = new SimpleAdapter(this,
                    tournamentList,
                    R.layout.view_tournament_entry,
                    new String[] {"tourId", "tourName", "tourDate", "tourProfit", "tourTotalPrizeAmount"},
                    new int[] {R.id.tour_id, R.id.tour_name, R.id.tour_date, R.id.tour_profit, R.id.tour_total});
            setListAdapter(adapter);

        } else {
            Toast.makeText(this, "No Tournament in Record!", Toast.LENGTH_LONG).show();
        }
    }




}