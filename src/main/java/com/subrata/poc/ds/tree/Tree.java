package com.subrata.poc.ds.tree;
import org.apache.commons.lang3.time.StopWatch;

import static com.subrata.poc.util.MyUtil.*;

/**
 * Template Class to work with various scenarios
 */
public final class Tree {
    private static StopWatch watch = new StopWatch();
    private Tree() {
    }

    public static void main(String[] args) {
        printJavaVersion();
        pocScenarioA();
        pocScenarioB();
    }
    private static void pocScenarioA(){
        logCurrentPosition(Thread.currentThread().getStackTrace());
        logTimeStart(watch);
        //Write your code here - start

        //Write your code here - finish
        logTimeFinish(watch);
    }
    private static void pocScenarioB(){
        logCurrentPosition(Thread.currentThread().getStackTrace());
        logTimeStart(watch);
        //Write your code here - start

        //Write your code here - finish
        logTimeFinish(watch);
    }
}