package edu.gatech.seclass.tourneymanager;

import android.app.Activity;
import android.app.ListActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import edu.gatech.seclass.tourneymanager.activity.PlayerPrizeList;
import edu.gatech.seclass.tourneymanager.controller.PrizeRepo;

/**
 * Created by vidyakv on 3/10/2017.
 */

public class Playerprizeslist_test extends ActivityInstrumentationTestCase2<PlayerPrizeList> {
    private Activity activity;
    private ListView lview;

    private TextView tView;

    public  Playerprizeslist_test(){
        super(PlayerPrizeList.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = (ListActivity)getActivity();
        lview = (ListView) activity.findViewById(R.id.editTextUsername);

    }
    @Test
    public void testNotNullCase(){
        assertNotNull(activity);
        assertNotNull(lview);
    }

    @Test
    public void testClickonItem(){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lview.performItemClick(lview,3,1);
            }
        });
    }
    @Test
    public void displayplayerprizes()
    {
        PrizeRepo prizeRepo = new PrizeRepo(this);
        List<Map<String, String>> playerPrizeList = prizeRepo.getIndividualPlayerPrizeList(R.id.player_name);
        assertEquals("jeremy",R.id.player_name);
        assert(true);
    }

}
