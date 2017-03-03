package edu.gatech.seclass.tourneymanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.gatech.seclass.tourneymanager.R;
import edu.gatech.seclass.tourneymanager.controller.MatchRepo;
import edu.gatech.seclass.tourneymanager.controller.PlayerRepo;
import edu.gatech.seclass.tourneymanager.controller.PrizeRepo;
import edu.gatech.seclass.tourneymanager.controller.TournamentRepo;
import edu.gatech.seclass.tourneymanager.model.Match;
import edu.gatech.seclass.tourneymanager.model.Player;
import edu.gatech.seclass.tourneymanager.model.Prize;
import edu.gatech.seclass.tourneymanager.model.Tournament;


public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        insertSampleData();

    }

    public void buttonModeSelector(View view){
        //setContentView(R.layout.activity_tourney_calc);
        Intent intent = new Intent(splash.this, ModeSelector.class);
        startActivity(intent);
    }

    private void insertSampleData() {
        PlayerRepo playerRepo = new PlayerRepo(this);
        TournamentRepo tournamentRepo = new TournamentRepo(this);
        MatchRepo matchRepo = new MatchRepo(this);
        PrizeRepo prizeRepo = new PrizeRepo(this);

        // Delete Old data
        playerRepo.deleteAll();
        tournamentRepo.deleteAll();
        matchRepo.deleteAll();
        prizeRepo.deleteAll();

        // Insert sample data

        // insert several players
        Player player = new Player();

        player.setName("Mike");
        player.setUsername("mike");
        player.setPhone("123-123");
        player.setTotal(100);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setName("Tom");
        player.setUsername("tom");
        player.setPhone("123-123");
        player.setTotal(10);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setName("Jeremy");
        player.setUsername("jeremy");
        player.setPhone("123-123");
        player.setTotal(200);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setName("Julie");
        player.setUsername("julie");
        player.setPhone("123-123");
        player.setTotal(20);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setName("Sophie");
        player.setUsername("sophie");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        // insert several matches
        Match match = new Match();

        match.setPlayer1ID(1);
        match.setPlayer2ID(2);
        match.setRound(Match.ROUND_SEMIFINAL);
        match.setWinnerID(1);
        match.setStatus(Match.STATUS_ONGOING);
        matchRepo.insert(match);

        match.setPlayer1ID(3);
        match.setPlayer2ID(4);
        match.setRound(Match.ROUND_SEMIFINAL);
        match.setWinnerID(3);
        match.setStatus(Match.STATUS_ONGOING);
        matchRepo.insert(match);

        match.setPlayer1ID(1);
        match.setPlayer2ID(3);
        match.setRound(Match.ROUND_FINAL);
        //match.setWinnerID();
        match.setStatus(Match.STATUS_READY);
        matchRepo.insert(match);

        // insert several tournaments
        Tournament tournament = new Tournament();

        tournament.setTourName("Tournament1");
        tournament.setDate("2017-03-01");
        tournament.setHouseProfit(100);
        tournament.setTotalPrizeAwarded(40);
        tournamentRepo.insert(tournament);

        tournament.setTourName("Tournament2");
        tournament.setDate("2017-03-02");
        tournament.setHouseProfit(200);
        tournament.setTotalPrizeAwarded(80);
        tournamentRepo.insert(tournament);

        tournament.setTourName("Tournament3");
        tournament.setDate("2017-03-03");
        tournament.setHouseProfit(150);
        tournament.setTotalPrizeAwarded(70);
        tournamentRepo.insert(tournament);

        tournament.setTourName("Tournament4");
        tournament.setDate("2017-03-04");
        tournament.setHouseProfit(50);
        tournament.setTotalPrizeAwarded(40);
        tournamentRepo.insert(tournament);

        tournament.setTourName("Tournament5");
        tournament.setDate("2017-03-05");
        tournament.setHouseProfit(80);
        tournament.setTotalPrizeAwarded(80);
        tournamentRepo.insert(tournament);

        // insert several prizes
        Prize prize = new Prize();

        prize.setTournamentID(1);
        prize.setPlayerID(1);
        prize.setPrizeType(Prize.PRIZE_FIRST);
        prize.setPrizeAmount(30);
        prizeRepo.insert(prize);

        prize.setTournamentID(1);
        prize.setPlayerID(2);
        prize.setPrizeType(Prize.PRIZE_SECOND);
        prize.setPrizeAmount(20);
        prizeRepo.insert(prize);

        prize.setTournamentID(1);
        prize.setPlayerID(3);
        prize.setPrizeType(Prize.PRIZE_THIRD);
        prize.setPrizeAmount(10);
        prizeRepo.insert(prize);

        prize.setTournamentID(1);
        prize.setPlayerID(2);
        prize.setPrizeType(Prize.PRIZE_FIRST);
        prize.setPrizeAmount(30);
        prizeRepo.insert(prize);

        prize.setTournamentID(1);
        prize.setPlayerID(3);
        prize.setPrizeType(Prize.PRIZE_SECOND);
        prize.setPrizeAmount(20);
        prizeRepo.insert(prize);

        prize.setTournamentID(1);
        prize.setPlayerID(4);
        prize.setPrizeType(Prize.PRIZE_THIRD);
        prize.setPrizeAmount(10);
        prizeRepo.insert(prize);


    }


}