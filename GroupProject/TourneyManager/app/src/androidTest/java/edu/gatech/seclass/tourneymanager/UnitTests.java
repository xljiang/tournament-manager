package edu.gatech.seclass.tourneymanager;

import android.app.Instrumentation;
import android.content.Intent;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import edu.gatech.seclass.tourneymanager.activity.AddPlayer;
import edu.gatech.seclass.tourneymanager.activity.ManagerMode;
import edu.gatech.seclass.tourneymanager.activity.MatchList4ManagerMode;
import edu.gatech.seclass.tourneymanager.activity.ModeSelector;
import edu.gatech.seclass.tourneymanager.activity.PlayerList4ManagerMode;


import static android.R.*;

import static android.R.attr.button;
import static edu.gatech.seclass.tourneymanager.R.id.editTextEntryPrice;
import static edu.gatech.seclass.tourneymanager.R.id.editTextHouseCut;
import static edu.gatech.seclass.tourneymanager.R.id.editTextName;
import static edu.gatech.seclass.tourneymanager.R.id.editTextPhone;
import static edu.gatech.seclass.tourneymanager.R.id.editTextUsername;
import static edu.gatech.seclass.tourneymanager.R.id.match_id;
import static edu.gatech.seclass.tourneymanager.R.id.textCurrentProfit;
import static edu.gatech.seclass.tourneymanager.R.id.textCurrentTotalPrizeAmount;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertSame;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.activity.ProfitHistory;
import edu.gatech.seclass.tourneymanager.activity.StartTournament;
import edu.gatech.seclass.tourneymanager.controller.MatchRepo;
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
import edu.gatech.seclass.tourneymanager.model.Match;
import edu.gatech.seclass.tourneymanager.model.Player;

/**
 * Created by vidyakv on 3/9/2017.
 */

public class UnitTests {

    @Test
    public void testAssertions() {
        //test data
        String name = new String("abcd");
        String username = new String("ab1234");
        String phonenum = "1234567890";

        //Check that an object isn't null
        assertNotNull(name);

        //Check that an object isn't null
        assertNotNull(username);

        //Check that an object isn't null
        assertNotNull(phonenum);

    }

    @Test

    public void testAddPlayerButton() {

        button buttonRegistor;
        TouchUtils.clickView(this, buttonRegistor);

    }


    @Test
    public void testButtonclear() {
        button buttonClear;
        TouchUtils.clickView(this, buttonClear);

    }


    @Test
    public void testreturnfromAddPlayerClassbutton() {
        button buttonReturn;
        TouchUtils.clickView(PlayerList4ManagerMode.class, buttonReturn);

    }

    @Test
    public void testreturnfromManagerModebutton() {
        button buttonReturn;
        TouchUtils.clickView(ModeSelector.class, buttonReturn);
    }

    @Test
    public void testmatchlistbutton() {
        button matchlistbutton;
        TouchUtils.clickView(MatchList4ManagerMode.class, matchlistbutton);
    }

    @Test
    public void testaddplayerfrommanagermodebutton() {
        button addplayerbutton;
        TouchUtils.clickView(PlayerList4ManagerMode.class, addplayerbutton);
    }


    @Test
    public void testprofithistorybutton() {
        button profithistorybutton;
        TouchUtils.clickView(ProfitHistory.class, profithistorybutton);
    }

    @Test
    public void testmanagetournamentbutton() {
        button managetournamentbutton;
        TouchUtils.clickView(StartTournament.class, managetournamentbutton);
    }


    @Test
    public void testreturnfrom_profithistory_button() {
        button retprofithistory_button;
        TouchUtils.clickView(ManagerMode.class, retprofithistory_button);

    }

    @Test
    public void testreturnfrom_starttournament_button() {
        button retstarttour_button;
        TouchUtils.clickView(ManagerMode.class, retstarttour_button);

    }

    @Test
    public void noduplicateusername() {
        assertNotSame(editTextUsername, R.id.editTextUsername, 0);
    }

    @Test
    public void ongoingmatch() {
        MatchRepo matchRepo = new MatchRepo(this);
        Match match = new Match();
        match = matchRepo.getMatchById(match_id);
        String status = match.getStatus();

        assertSame("match ongoing", status, Match.STATUS_ONGOING);

    }

    @Test
    public void endmatch() {
        MatchRepo matchRepo = new MatchRepo(this);
        Match match = new Match();
        match = matchRepo.getMatchById(match_id);
        String status = match.getStatus();
        assertSame("end of match", status, Match.STATUS_FINISHED);
    }

    @Test
    public void addmatch() {
        MatchRepo matchRepo = new MatchRepo(this);
        Match match = new Match();
        match = matchRepo.getMatchById(match_id);
        String status = match.getStatus();
        assertSame("match ready", status, Match.STATUS_READY);
        matchRepo.update(match);
    }

    @Test
    public void calculate_display_houseprofit() {
        int houseCut = 0;
        int houseProfit = 0;
        int entry = 0;
        Integer num_player = 8;
        int houseProfit = 0;
        houseCut = (Integer) (editTextHouseCut);
        entry = (Integer) (editTextEntryPrice);
        houseProfit = entry * num_player * houseCut / 100;
        Toast.makeText("house profit calculated", houseProfit, 5);
        Assert.assertTrue("the house profit is displayed", 1);
    }
}

