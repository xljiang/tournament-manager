package edu.gatech.seclass.tourneymanager;

import android.app.Instrumentation;
import android.content.Intent;
import android.test.TouchUtils;
import android.widget.Button;

import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.AddPlayer;
import edu.gatech.seclass.tourneymanager.activity.ManagerMode;
import edu.gatech.seclass.tourneymanager.activity.MatchList4ManagerMode;
import edu.gatech.seclass.tourneymanager.activity.ModeSelector;
import edu.gatech.seclass.tourneymanager.activity.PlayerList4ManagerMode;


import static android.R.attr.button;
import static junit.framework.Assert.assertNotNull;
import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.activity.ProfitHistory;
import edu.gatech.seclass.tourneymanager.activity.StartTournament;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class UnitTests {

    @Test
    public void testAssertions() {
        //test data
        String name= new String ("abcd");
        String username = new String ("ab1234");
        String phonenum = "1234567890";

        //Check that an object isn't null
        assertNotNull(name);

        //Check that an object isn't null
        assertNotNull(username);

        //Check that an object isn't null
        assertNotNull(phonenum);

    }
    @Test

        public void testAddPlayerButton(){

        button buttonRegistor;
        TouchUtils.clickView(this,buttonRegistor);

        }


    @Test
    public void testButtonclear(){
        button buttonClear;
        TouchUtils.clickView(this,buttonClear);

        }


     @Test
     public void testreturnfromAddPlayerClassbutton() {
         button buttonReturn;
         TouchUtils.clickView(PlayerList4ManagerMode.class,buttonReturn);

     }

    @Test
    public void testreturnfromManagerModebutton() {
        button buttonReturn ;
        TouchUtils.clickView( ModeSelector.class,buttonReturn);
            }

    @Test
    public void testmatchlistbutton() {
        button matchlistbutton;
        TouchUtils.clickView(MatchList4ManagerMode.class,matchlistbutton);
    }
     @Test
     public void testaddplayerfrommanagermodebutton() {
         button addplayerbutton ;
         TouchUtils.clickView(PlayerList4ManagerMode.class,addplayerbutton);
     }


    @Test
    public void testprofithistorybutton() {
        button profithistorybutton;
        TouchUtils.clickView(ProfitHistory.class,profithistorybutton);
    }
    @Test
    public void testmanagetournamentbutton() {
        button managetournamentbutton;
        TouchUtils.clickView(StartTournament.class,managetournamentbutton);
    }


    @Test
    public void testreturnfrom_profithistory_button() {
        button retprofithistory_button;
        TouchUtils.clickView(ManagerMode.class,retprofithistory_button);

    }
    @Test
    public void testreturnfrom_starttournament_button() {
        button retstarttour_button;
        TouchUtils.clickView(ManagerMode.class,retstarttour_button);

    }

}