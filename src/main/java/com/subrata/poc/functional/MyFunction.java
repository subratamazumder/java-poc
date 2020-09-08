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
//        System.out.println("input 1 :" + isPrime(1));
//        System.out.println("input 2 :" + isPrime(2));
//        System.out.println("input 3 :" + isPrime(4));
//        System.out.println("input 1236777777 :" + isPrime(1236777777));
        System.out.println("Why stream is so slow????");
        System.out.println("Sum of 100 number - stream -" + sumOfNNumbersStream(1000000));
        System.out.println("Sum of 100 number - regular -" + sumOfNNumbersRegular(1000000));
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
