package edu.gatech.seclass.tourneymanager.controller;

import android.content.Context;

import edu.gatech.seclass.tourneymanager.model.Match;

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



    public void startTournament() {
        //TODO
        // refactor code from StartTournament class
    }



    //put winner information to the next attending match
    //also need to put looser information to the final and 3rd place match
    // if current match is final or 3rd place match, do nothing
    public void putPlayerIntoNextMatch(MatchRepo matchRepo, int currMatchId, int count, int winnerId, int looserId) {
        Match nextMatch1 = new Match();
        Match nextMatch2 = new Match();
        if (count == 8) {
            switch (currMatchId) {
                case 1:
                    nextMatch1 = matchRepo.getMatchById(5);
                    nextMatch1.setPlayer1ID(winnerId);
                    matchRepo.update(nextMatch1);
                    break;
                case 2:
                    nextMatch1 = matchRepo.getMatchById(5);
                    nextMatch1.setPlayer2ID(winnerId);
                    nextMatch1.setStatus(Match.STATUS_READY);
                    matchRepo.update(nextMatch1);
                    break;
                case 3:
                    nextMatch1 = matchRepo.getMatchById(6);
                    nextMatch1.setPlayer1ID(winnerId);
                    matchRepo.update(nextMatch1);
                    break;
                case 4:
                    nextMatch1 = matchRepo.getMatchById(6);
                    nextMatch1.setPlayer2ID(winnerId);
                    nextMatch1.setStatus(Match.STATUS_READY);
                    matchRepo.update(nextMatch1);
                    break;
                case 5:
                    nextMatch1 = matchRepo.getMatchById(8);
                    nextMatch1.setPlayer1ID(winnerId);
                    nextMatch2 = matchRepo.getMatchById(7);
                    nextMatch2.setPlayer1ID(looserId);
                    matchRepo.update(nextMatch1);
                    matchRepo.update(nextMatch2);
                    break;
                case 6:
                    nextMatch1 = matchRepo.getMatchById(8);
                    nextMatch1.setPlayer2ID(winnerId);
                    nextMatch1.setStatus(Match.STATUS_READY);
                    nextMatch2 = matchRepo.getMatchById(7);
                    nextMatch2.setPlayer2ID(looserId);
                    nextMatch2.setStatus(Match.STATUS_READY);
                    matchRepo.update(nextMatch1);
                    matchRepo.update(nextMatch2);
                    break;
                case 7:
                    return;
                case 8:
                    return;
            }
        } else if (count == 16) {
            // TODO
        }

    }
}
