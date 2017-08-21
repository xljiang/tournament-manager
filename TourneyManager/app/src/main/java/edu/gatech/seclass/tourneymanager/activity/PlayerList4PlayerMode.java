package edu.gatech.seclass.tourneymanager.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;

/**
 * @author Katja Krivoruchko
 * @author Xiaolu Jiang
 *
 */

public class PlayerList4PlayerMode extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list_player_mode);

        showList();
    }

    public void buttonReturn(View view){
        Intent intent = new Intent(PlayerList4PlayerMode.this, ModeSelector.class);
        startActivity(intent);
    }

    public void showList() {
        PlayerRepo playerRepo = new PlayerRepo(this);
        List<Map<String, String>> playerTotalList = playerRepo.getPlayerTotalList();
        if (playerTotalList.size() != 0) {
            ListAdapter adapter = new SimpleAdapter(this,
                    playerTotalList,
                    R.layout.view_player_entry,
                    new String[] {"id", "name", "total"},
                    new int[] {R.id.player_id, R.id.player_name, R.id.player_total});
            setListAdapter(adapter);

        } else {
            Toast.makeText(this, "No records! Please go to the Manager Mode and add player!", Toast.LENGTH_LONG).show();
        }
    }


}