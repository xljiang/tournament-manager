package edu.gatech.seclass.tourneymanager.com.tourneymanager.app.tests;

import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.Test;

/**
 * Created by vidyakv on 3/7/2017.
 */

public class fullTest {
    public static Test suite(){
        return new TestSuiteBuilder(fullTest.class)
                .includeAllPackagesUnderHere().build();
    }
    public fullTest(){
        super();
    }
}
