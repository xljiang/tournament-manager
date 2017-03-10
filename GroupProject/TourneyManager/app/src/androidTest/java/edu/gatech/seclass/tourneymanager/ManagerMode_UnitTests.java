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
          assert managerMode.buttonAddPlayer();
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




}
