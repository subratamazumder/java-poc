package com.subrata.poc.functional;

import org.apache.commons.lang3.time.StopWatch;

import java.util.stream.IntStream;

import static com.subrata.poc.util.MyUtil.*;

public final class MyStream {
    private static StopWatch watch = new StopWatch();

    private MyStream() {
    }

    public static void main(String[] args) {
        printJavaVersion();
        System.out.println("Why stream is so slow????");
        System.out.println("Sum of 1000000 number - stream range -" + sumOfNNumbersStream(1000000));
        System.out.println("Sum of 1000000 number - stream iterate -" + sumOfNNumbersStreamIterate(1000000));
        System.out.println("Sum of 1000000 number - regular -" + sumOfNNumbersRegular(1000000));
    }

    private static int sumOfNNumbersStream(int n) {
        logCurrentPosition(Thread.currentThread().getStackTrace());
        logTimeStart(watch);
        //Write your code here - start
        int result = 0;
        result = IntStream.range(0, n+1).sum();
        //Write your code here - finish
        logTimeFinish(watch);
        return result;

    }
    private static int sumOfNNumbersStreamIterate(int n) {
        logCurrentPosition(Thread.currentThread().getStackTrace());
        logTimeStart(watch);
        //Write your code here - start
        int result = 0;
        result = IntStream.iterate(0, i -> i +1 ).limit(n).sum();
        //Write your code here - finish
        logTimeFinish(watch);
        return result;

    }

    private static int sumOfNNumbersRegular(int n) {
        logCurrentPosition(Thread.currentThread().getStackTrace());
        logTimeStart(watch);
        //Write your code here - start
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result = result + i;
        }
        //Write your code here - finish
        logTimeFinish(watch);
        return result;
    }
}
