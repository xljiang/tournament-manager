package edu.gatech.seclass.tourneymanager.controller;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.gatech.seclass.tourneymanager.model.Match;
import edu.gatech.seclass.tourneymanager.model.Player;
import edu.gatech.seclass.tourneymanager.model.Prize;
import edu.gatech.seclass.tourneymanager.model.Tournament;

/**
 * Created by xiaolu on 3/3/17.
 * @author Xiaolu Jiang
 */

public class Manager {

    public Manager() {

    }

    // return true if there is a ongoing tournament
    // if match list is not empty, then there is ongoing tournament
    public boolean hasOngoingTournament(Context context) {
        MatchRepo matchRepo = new MatchRepo(context);
        int count = matchRepo.getPlayerCount();
        return count == 0 ? false : true;
    }


    // start a new tournament and add
    public void startTournament(TournamentRepo tournamentRepo, MatchRepo matchRepo,
                                int houseProfit, int totalPrizeAmount, ArrayList<Integer> players) {

        int count = players.size();

        // shuffle the player list
        Collections.shuffle(players);

        // create new match list
        if (count == 8) {
            // at 8 matches to start
            insertMatch(matchRepo, 1, players.get(0), players.get(1), Match.ROUND_QUARTERFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 2, players.get(2), players.get(3), Match.ROUND_QUARTERFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 3, players.get(4), players.get(5), Match.ROUND_QUARTERFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 4, players.get(6), players.get(7), Match.ROUND_QUARTERFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 5, 0, 0, Match.ROUND_SEMIFINAL, 0, Match.STATUS_NOTREADY);
            insertMatch(matchRepo, 6, 0, 0, Match.ROUND_SEMIFINAL, 0, Match.STATUS_NOTREADY);
            insertMatch(matchRepo, 7, 0, 0, Match.ROUND_THIRDPLACE, 0, Match.STATUS_NOTREADY);
            insertMatch(matchRepo, 8, 0, 0, Match.ROUND_FINAL, 0, Match.STATUS_NOTREADY);

        } else if (count == 16) {
            insertMatch(matchRepo, 1, players.get(0), players.get(1), Match.ROUND_EIGHTHFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 2, players.get(2), players.get(3), Match.ROUND_EIGHTHFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 3, players.get(4), players.get(5), Match.ROUND_EIGHTHFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 4, players.get(6), players.get(7), Match.ROUND_EIGHTHFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 5, players.get(8), players.get(9), Match.ROUND_EIGHTHFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 6, players.get(10), players.get(11), Match.ROUND_EIGHTHFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 7, players.get(12), players.get(13), Match.ROUND_EIGHTHFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 8, players.get(14), players.get(15), Match.ROUND_EIGHTHFINAL, 0, Match.STATUS_READY);
            insertMatch(matchRepo, 9, 0, 0, Match.ROUND_QUARTERFINAL, 0, Match.STATUS_NOTREADY);
            insertMatch(matchRepo, 10, 0, 0, Match.ROUND_QUARTERFINAL, 0, Match.STATUS_NOTREADY);
            insertMatch(matchRepo, 11, 0, 0, Match.ROUND_QUARTERFINAL, 0, Match.STATUS_NOTREADY);
            insertMatch(matchRepo, 12, 0, 0, Match.ROUND_QUARTERFINAL, 0, Match.STATUS_NOTREADY);
            insertMatch(matchRepo, 13, 0, 0, Match.ROUND_SEMIFINAL, 0, Match.STATUS_NOTREADY);
            insertMatch(matchRepo, 14, 0, 0, Match.ROUND_SEMIFINAL, 0, Match.STATUS_NOTREADY);
            insertMatch(matchRepo, 15, 0, 0, Match.ROUND_THIRDPLACE, 0, Match.STATUS_NOTREADY);
            insertMatch(matchRepo, 16, 0, 0, Match.ROUND_FINAL, 0, Match.STATUS_NOTREADY);
        }

        // record current ongoing tournament info (name, date, profit, total prize) to db
        Tournament tournament = new Tournament();
        tournament.setTourName("Tournament");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        tournament.setDate(date);
        tournament.setHouseProfit(houseProfit);
        tournament.setTotalPrizeAwarded(totalPrizeAmount);
        tournamentRepo.insert(tournament);
    }



    // end the tournament and record result to db
    public void endTournament(MatchRepo matchRepo, TournamentRepo tournamentRepo, PrizeRepo prizeRepo, PlayerRepo playerRepo) {
        // count = how many players in the match
        int count = matchRepo.getPlayerCount();

        if (count == 0) return; // emtpy match list, no ongoing tournament

        // the last tournament in the Tournament table is the ongoing tournament
        Tournament ongoingTournament = tournamentRepo.getLastTournament();
        int ongoingTourId = ongoingTournament.getTournamentID();

        // the final and 3rd place match
        int idFinal = 8;
        int id3rdPlace = 7;
        if (count == 16) {
            idFinal = 16;
            id3rdPlace = 15;
        }
        Match matchFinal = matchRepo.getMatchById(idFinal);
        Match match3rdPlace = matchRepo.getMatchById(id3rdPlace);

        if (matchRepo.allMatchCompleted()) { // the tournament was ended properly
            // record result to db

            // get first, second, third info
            int firstPlayerId = matchFinal.getWinnerID();
            int secondPlayerId = matchFinal.getPlayer1ID();
            if (secondPlayerId == firstPlayerId) {
                secondPlayerId = matchFinal.getPlayer2ID();
            }
            int thirdPlayerId = match3rdPlace.getWinnerID();

            int prizes = ongoingTournament.getTotalPrizeAwarded();
            int firstPrizeAmount = (int) (prizes * 0.5);
            int secondPrizeAmount = (int) (prizes * 0.3);
            int thirdPrizeAmount = (int) (prizes * 0.2);

            // no need to change record Tournament Table

            // record to Prize table
            addPrize(prizeRepo, ongoingTourId, firstPlayerId, Prize.PRIZE_FIRST, firstPrizeAmount);
            addPrize(prizeRepo, ongoingTourId, secondPlayerId, Prize.PRIZE_SECOND, secondPrizeAmount);
            addPrize(prizeRepo, ongoingTourId, thirdPlayerId, Prize.PRIZE_THIRD, thirdPrizeAmount);

            // update Player table (update total)
            updatePlayer(playerRepo, firstPlayerId, firstPrizeAmount);
            updatePlayer(playerRepo, secondPlayerId, secondPrizeAmount);
            updatePlayer(playerRepo, thirdPlayerId, thirdPrizeAmount);


        } else { // the tournament was terminated early
            // delete tournament Table entry
            tournamentRepo.delete(ongoingTourId);
            // don't need to record result to the Prize table
            // don't need to update Player table
        }

        // delete all match results
        matchRepo.deleteAll();
    }

    // add new prize to the database - Prize Table
    private void addPrize(PrizeRepo prizeRepo, int tourId, int playerId, String prizeType, int amount) {
        Prize prize = new Prize();
        prize.setTournamentID(tourId);
        prize.setPlayerID(playerId);
        prize.setPrizeType(prizeType);
        prize.setPrizeAmount(amount);
        prizeRepo.insert(prize);
    }

    // update player total amount - Player Table
    private void updatePlayer(PlayerRepo playerRepo, int playerId, int amount) {
        Player player = playerRepo.getStudentById(playerId);
        player.setTotal(player.getTotal() + amount);
        playerRepo.update(player);
    }

    // insert new match to the Match Table
    private void insertMatch(MatchRepo matchRepo, int matchId, int player1Id, int player2Id, String round, int winnerId, String status) {
        Match match = new Match();
        match.setMatchID(matchId);
        match.setPlayer1ID(player1Id);
        match.setPlayer2ID(player2Id);
        match.setRound(round);
        match.setWinnerID(winnerId);
        match.setStatus(status);
        matchRepo.insert(match);
    }



    //put winner information to the next attending match
    //also need to put loser information to the final and 3rd place match
    // if current match is final or 3rd place match, do nothing
    public void putPlayerIntoNextMatch(MatchRepo matchRepo, int currMatchId, int count, int winnerId, int looserId) {
        // -1 or "-1" means no change!
        if (count == 8) {
            switch (currMatchId) {
                case 1:
                    updateMatch(matchRepo, 5, winnerId, -1, "-1");
                    break;
                case 2:
                    updateMatch(matchRepo, 5, -1, winnerId, Match.STATUS_READY);
                    break;
                case 3:
                    updateMatch(matchRepo, 6, winnerId, -1, "-1");
                    break;
                case 4:
                    updateMatch(matchRepo, 6, -1, winnerId, Match.STATUS_READY);
                    break;
                case 5:
                    updateMatch(matchRepo, 8, winnerId, -1, "-1");
                    updateMatch(matchRepo, 7, looserId, -1, "-1");
                    break;
                case 6:
                    updateMatch(matchRepo, 8, -1, winnerId, Match.STATUS_READY);
                    updateMatch(matchRepo, 7, -1, looserId, Match.STATUS_READY);
                    break;
                case 7:
                    return;
                case 8:
                    return;
            }
        } else if (count == 16) {
            switch (currMatchId) {
                case 1:
                    updateMatch(matchRepo, 9, winnerId, -1, "-1");
                    break;
                case 2:
                    updateMatch(matchRepo, 9, -1, winnerId, Match.STATUS_READY);
                    break;
                case 3:
                    updateMatch(matchRepo, 10, winnerId, -1, "-1");
                    break;
                case 4:
                    updateMatch(matchRepo, 10, -1, winnerId, Match.STATUS_READY);
                    break;
                case 5:
                    updateMatch(matchRepo, 11, winnerId, -1, "-1");
                    break;
                case 6:
                    updateMatch(matchRepo, 11, -1, winnerId, Match.STATUS_READY);
                    break;
                case 7:
                    updateMatch(matchRepo, 12, winnerId, -1, "-1");
                    break;
                case 8:
                    updateMatch(matchRepo, 12, -1, winnerId, Match.STATUS_READY);
                    break;
                case 9:
                    updateMatch(matchRepo, 13, winnerId, -1, "-1");
                    break;
                case 10:
                    updateMatch(matchRepo, 13, -1, winnerId, Match.STATUS_READY);
                    break;
                case 11:
                    updateMatch(matchRepo, 14, winnerId, -1, "-1");
                    break;
                case 12:
                    updateMatch(matchRepo, 14, -1, winnerId, Match.STATUS_READY);
                    break;
                case 13:
                    updateMatch(matchRepo, 16, winnerId, -1, "-1");
                    updateMatch(matchRepo, 15, looserId, -1, "-1");
                    break;
                case 14:
                    updateMatch(matchRepo, 16, -1, winnerId, Match.STATUS_READY);
                    updateMatch(matchRepo, 15, -1, looserId, Match.STATUS_READY);
                    break;
                case 15:
                    return;
                case 16:
                    return;
            }
        }

    }

    // update a match with match id = matchId
    // only update 1) player1Id, 2) player2Id, 3) match status
    // if player1Id or player2Id = -1, or status = "-1", means no change to this field
    private void updateMatch(MatchRepo matchRepo, int matchId, int player1Id, int player2Id, String status) {
        Match match = new Match();
        match = matchRepo.getMatchById(matchId);
        if (player1Id != -1) {
            match.setPlayer1ID(player1Id);
        }
        if (player2Id != -1) {
            match.setPlayer2ID(player2Id);
        }
        if (!status.equals("-1")) {
            match.setStatus(status);
        }
        // update match to database
        matchRepo.update(match);
    }

    public void print(List<Map<String, String>> list) {
        for (int i = 0; i <= list.size(); i++) {
            Map<String, String> map = list.get(i);
            for (String key: map.keySet()) {
                System.out.println(key + ": " + map.get(key));
            }
        }
    }
}
