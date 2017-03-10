package edu.gatech.seclass.tourneymanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import edu.gatech.seclass.tourneymanager.activity.PlayerPrizeList;
import edu.gatech.seclass.tourneymanager.controller.PrizeRepo;

/**
 * Created by vidyakv on 3/10/2017.
 */

public class Playerprizestest {
    private PlayerPrizeList playerPrizeList;

    @Before
    public void setUp()
    {
        playerPrizeList= new PlayerPrizeList('Jeremy');
    }

    @After
    public void tearDown()
    {
        playerPrizeList=null;
    }


        @Test
        public void testreturnButton()
        {
            assert playerPrizeList.buttonReturn();
        }


}