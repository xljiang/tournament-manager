package edu.gatech.seclass.tourneymanager.activity;

/**
 * @author Katja Krivoruchko
 * @author Xiaolu Jiang
 *
 * reference: instinctcoder.com
 */

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
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

import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
import edu.gatech.seclass.tourneymanager.R;

public class PlayerList4ManagerMode extends ListActivity  implements android.view.View.OnClickListener{

    Button btnAdd,btnGetAll, btnBack;
    TextView player_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list_manager_mode);

        btnAdd = (Button) findViewById(R.id.btnAddNew);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        refreshList();

    }

    public void buttonReturn(View view){
        Intent intent = new Intent(PlayerList4ManagerMode.this, ManagerMode.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAddNew)) {

            Intent intent = new Intent(this, AddPlayer.class);
            //intent.putExtra("player_Id", 0);
            startActivity(intent);
        }

        if (view== findViewById(R.id.btnBack)){

                Intent intent = new Intent(this,ManagerMode.class);
                //intent.putExtra("player_Id",0);
                startActivity(intent);

        }else {
            refreshList();
        }
    }

    public void refreshList(){
        PlayerRepo playerRepo = new PlayerRepo(this);
        List<Map<String, String>> playerTotalList =  playerRepo.getPlayerTotalList();
        if(playerTotalList.size() != 0) {
            ListView lv = getListView();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    player_id = (TextView) view.findViewById(R.id.player_id);
                    String playerId = player_id.getText().toString();
                    Intent objIndent = new Intent(getApplicationContext(),PlayerPrizeList.class);
                    objIndent.putExtra("player_Id", Integer.parseInt(playerId));
                    startActivity(objIndent);
                }
            });
            ListAdapter adapter = new SimpleAdapter(this,
                                                    playerTotalList,
                                                    R.layout.view_player_entry,
                                                    new String[] {"id", "name", "total"},
                                                    new int[] {R.id.player_id, R.id.player_name, R.id.player_total});
            setListAdapter(adapter);

        }else{
            Toast.makeText(this,"No records! Please add player",Toast.LENGTH_SHORT).show();
        }

    }

}