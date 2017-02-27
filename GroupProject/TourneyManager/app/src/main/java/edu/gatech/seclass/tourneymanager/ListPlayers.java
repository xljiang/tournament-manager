package edu.gatech.seclass.tourneymanager;

/**
 * Code from instinctcoder.com
 * Edited by Katja Krivoruchko for CS 6300 Spring 2017
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

import java.util.ArrayList;
import java.util.HashMap;

public class ListPlayers extends ListActivity  implements android.view.View.OnClickListener{

    Button btnAdd,btnGetAll, btnBack;
    TextView player_Id;

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)) {

            Intent intent = new Intent(this, PlayerDetail.class);
            intent.putExtra("player_Id", 0);
            startActivity(intent);
        }if (view== findViewById(R.id.btnBack)){

                Intent intent = new Intent(this,ManagerMode.class);
                //intent.putExtra("player_Id",0);
                startActivity(intent);

            }else {

            PlayerRepo repo = new PlayerRepo(this);

            ArrayList<HashMap<String, String>> studentList =  repo.getStudentList();
            if(studentList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        player_Id = (TextView) view.findViewById(R.id.player_Id);
                        String studentId = player_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),PlayerDetail.class);
                        objIndent.putExtra("player_Id", Integer.parseInt( studentId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( ListPlayers.this,studentList, R.layout.view_player_entry, new String[] { "id","name"}, new int[] {R.id.player_Id, R.id.student_name});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this,"No records! Please add player",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_players);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);



    }
    public void buttonReturn(View view){
        Intent intent = new Intent(ListPlayers.this, ManagerMode.class);
        startActivity(intent);
    }


}