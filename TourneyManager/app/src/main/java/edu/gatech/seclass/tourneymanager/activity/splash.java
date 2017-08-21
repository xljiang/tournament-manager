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
import edu.gatech.seclass.tourneymanager.model.Player;


public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //insertSampleData();

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

        //Delete Old data
        playerRepo.deleteAll();
        tournamentRepo.deleteAll();
        matchRepo.deleteAll();
        prizeRepo.deleteAll();

        // Insert sample data

        // insert several players
        Player player = new Player();

        player.setPlayerID(1);
        player.setName("Mike");
        player.setUsername("mike");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setPlayerID(2);
        player.setName("Tom");
        player.setUsername("tom");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setPlayerID(3);
        player.setName("Jeremy");
        player.setUsername("jeremy");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setPlayerID(4);
        player.setName("Julie");
        player.setUsername("julie");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setPlayerID(5);
        player.setName("Sophie");
        player.setUsername("sophie");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setPlayerID(6);
        player.setName("Ann");
        player.setUsername("ann");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setPlayerID(7);
        player.setName("Lisa");
        player.setUsername("lisa");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setPlayerID(8);
        player.setName("Dan");
        player.setUsername("dan");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setPlayerID(9);
        player.setName("Emma");
        player.setUsername("emma");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        player.setPlayerID(10);
        player.setName("Bob");
        player.setUsername("bob");
        player.setPhone("123-123");
        player.setTotal(0);
        player.setDeck("T");
        playerRepo.insert(player);

        // insert several matches
       /* Match match = new Match();

        match.setMatchID(1);
        match.setPlayer1ID(211);
        match.setPlayer2ID(212);
        match.setRound(Match.ROUND_QUARTERFINAL);
        match.setStatus(Match.STATUS_READY);
        matchRepo.insert(match);

        match.setMatchID(2);
        match.setPlayer1ID(213);
        match.setPlayer2ID(214);
        match.setRound(Match.ROUND_QUARTERFINAL);
        match.setStatus(Match.STATUS_READY);
        matchRepo.insert(match);

        match.setMatchID(3);
        match.setPlayer1ID(215);
        match.setPlayer2ID(216);
        match.setRound(Match.ROUND_QUARTERFINAL);
        match.setStatus(Match.STATUS_READY);
        matchRepo.insert(match);

        match.setMatchID(4);
        match.setPlayer1ID(217);
        match.setPlayer2ID(218);
        match.setRound(Match.ROUND_QUARTERFINAL);
        match.setStatus(Match.STATUS_READY);
        matchRepo.insert(match);

        match.setPlayer1ID(0); // 0 is no player
        match.setPlayer2ID(0); // 0 is no player

        match.setMatchID(5);
        match.setRound(Match.ROUND_SEMIFINAL);
        match.setStatus(Match.STATUS_NOTREADY);
        matchRepo.insert(match);

        match.setMatchID(6);
        match.setRound(Match.ROUND_SEMIFINAL);
        match.setStatus(Match.STATUS_NOTREADY);
        matchRepo.insert(match);

        match.setMatchID(7);
        match.setRound(Match.ROUND_THIRDPLACE);
        match.setStatus(Match.STATUS_NOTREADY);
        matchRepo.insert(match);

        match.setMatchID(8);
        match.setRound(Match.ROUND_FINAL);
        match.setStatus(Match.STATUS_NOTREADY);
        matchRepo.insert(match);



        // insert several tournaments
        /*Tournament tournament = new Tournament();

        tournament.setTourName("Tournament1");
        tournament.setDate("2017-03-01");
        tournament.setHouseProfit(100);
        tournament.setTotalPrizeAwarded(100);
        tournamentRepo.insert(tournament);

        tournament.setTourName("Tournament2");
        tournament.setDate("2017-03-02");
        tournament.setHouseProfit(100);
        tournament.setTotalPrizeAwarded(100);
        tournamentRepo.insert(tournament);

        tournament.setTourName("Tournament3");
        tournament.setDate("2017-03-03");
        tournament.setHouseProfit(100);
        tournament.setTotalPrizeAwarded(100);
        tournamentRepo.insert(tournament);

        tournament.setTourName("Tournament4");
        tournament.setDate("2017-03-04");
        tournament.setHouseProfit(100);
        tournament.setTotalPrizeAwarded(100);
        tournamentRepo.insert(tournament);

        tournament.setTourName("Tournament5");
        tournament.setDate("2017-03-05");
        tournament.setHouseProfit(100);
        tournament.setTotalPrizeAwarded(100);
        tournamentRepo.insert(tournament);

        // insert several prizes
        Prize prize = new Prize();

        prize.setTournamentID(1);
        prize.setPlayerID(1);
        prize.setPrizeType(Prize.PRIZE_FIRST);
        prize.setPrizeAmount(100);
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

        prize.setTournamentID(2);
        prize.setPlayerID(2);
        prize.setPrizeType(Prize.PRIZE_FIRST);
        prize.setPrizeAmount(30);
        prizeRepo.insert(prize);

        prize.setTournamentID(2);
        prize.setPlayerID(3);
        prize.setPrizeType(Prize.PRIZE_SECOND);
        prize.setPrizeAmount(20);
        prizeRepo.insert(prize);

        prize.setTournamentID(2);
        prize.setPlayerID(4);
        prize.setPrizeType(Prize.PRIZE_THIRD);
        prize.setPrizeAmount(10);
        prizeRepo.insert(prize);*/


    }


}