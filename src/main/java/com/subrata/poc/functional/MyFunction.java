package com.subrata.poc.functional;

import org.apache.commons.lang3.time.StopWatch;

import java.util.stream.IntStream;

import static com.subrata.poc.util.MyUtil.*;
import static com.subrata.poc.util.MyUtil.logTimeFinish;

public final class MyFunction {
    private static StopWatch watch = new StopWatch();

    private MyFunction() {
    }

    public static void main(String[] args) {
        printJavaVersion();
        System.out.println("input 1 :" + isPrime(1));
        System.out.println("input 2 :" + isPrime(2));
        System.out.println("input 3 :" + isPrime(4));
        System.out.println("input 1236777777 :" + isPrime(1236777777));
    }

    private static boolean isPrime(final int input) {
        logCurrentPosition(Thread.currentThread().getStackTrace());
        logTimeStart(watch);
        //Write your code here - start
        boolean result = input > 1 && IntStream.range(2, input).noneMatch(eachItem -> eachItem % input == 0);
        //Write your code here - finish
        logTimeFinish(watch);
        return result;
    }
}
