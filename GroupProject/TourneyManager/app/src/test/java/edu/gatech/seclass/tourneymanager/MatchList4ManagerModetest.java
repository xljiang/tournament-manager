package edu.gatech.seclass.tourneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.MatchList4ManagerMode;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class MatchList4ManagerModetest extends MatchList4ManagerMode {
    private MatchList4ManagerMode matchList4ManagerMode;

    @Before
    public void setUp() {
        matchList4ManagerMode = new MatchList4ManagerMode();
    }

    @After
    public void teardown() {
        matchList4ManagerMode=null;
    }

    @Test
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_match_list_manager_mode);
        Button b = (Button) findViewById(R.id.btnEndTour);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(MatchList4ManagerModetest.this, MatchList4ManagerMode.class);
                startActivity(i);
            }
        });

    }
}
