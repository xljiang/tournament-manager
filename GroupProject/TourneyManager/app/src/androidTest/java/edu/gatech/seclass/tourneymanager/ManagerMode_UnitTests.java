package edu.gatech.seclass.tourneymanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.tourneymanager.activity.ManagerMode;


/**
 * Created by vidyakv on 3/9/2017.
 */

public class ManagerMode_UnitTests {
    private ManagerMode managerMode;

    @Before
    public void setUp() {
        managerMode= new ManagerMode();
    }

    @After
    public void teardown() {
        managerMode = null;
    }

      @Test
        public void testAddPlayerbutton() {
          assert managerMode.buttonAddPlayer());
      }

         @Test
                 public void testreturnbutton() {
              assert (managerMode.buttonReturn());
          }

          @Test
          public void testmatchlistbutton() {
              assert(managerMode.buttonMatchList());
          }


          @Test
          public void testprofithistorybutton() {
              assert (managerMode.buttonProfitHistory());

          }

         @Test
         public void testmanagetournament() {
             assert(managerMode.buttonManageTournament());
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
        public void test_matchlist()
        MatchRepo matchRepo = new MatchRepo(this);
        Match match = new Match();
        List<Map<String, String>> matchList = matchRepo.getMatchList();
        ListAdapter adapter = new SimpleAdapter(this,
                matchList,
                R.layout.view_match_entry,
                new String[] {"id", "player1name", "player2name", "round", "winnerName", "status"},
                new int[] {R.id.match_id, R.id.player1_name, R.id.player2_name, R.id.match_round,
                        R.id.match_winner, R.id.match_status});


    }

    String status = match.getStatus();

}


}
