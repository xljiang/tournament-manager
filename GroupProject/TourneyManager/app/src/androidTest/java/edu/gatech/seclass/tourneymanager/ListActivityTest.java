package edu.gatech.seclass.tourneymanager;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.widget.ListViewCompat;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.MatchList4ManagerMode;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class ListActivityTest extends ActivityInstrumentationTestCase2<MatchList4ManagerMode> {
    private Activity activity;
    private ListView lview;

    private TextView tView;

    public  ListActivityTest(){
        super(MatchList4ManagerMode.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = (ListActivity)getActivity();
        lview = (ListView) activity.findViewById(R.id.match_id);

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
                lview.performItemClick(lview,2,1);
            }
        });
    }

    @Test
    public void testlistview_display(){
        ListView listview = (ListView)activity.findViewById(R.id.match_id);

        assertEquals((int) listview.getCount(), 7);
    }



}
