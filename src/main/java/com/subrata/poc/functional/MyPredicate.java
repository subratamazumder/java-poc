package com.subrata.poc.functional;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static com.subrata.poc.util.MyUtil.*;

public class MyPredicate {
    private static StopWatch watch = new StopWatch();
    public static void main(String[] args) {
        printJavaVersion();
        simplePredicate();
        predicateChaining();
        predicateAsArgument();
    }

    private static void simplePredicate(){
        logTimeStart(watch);
        logCurrentPosition(Thread.currentThread().getStackTrace());
        Predicate<Integer> integerPredicateGtTen = (input) -> (input > 10);
        System.out.println("11 is GT 10 = "+integerPredicateGtTen.test(11));
        System.out.println("10 is GT 10 = "+integerPredicateGtTen.test(10));
        logTimeFinish(watch);
    }
    private static void predicateChaining(){
        logTimeStart(watch);
        logCurrentPosition(Thread.currentThread().getStackTrace());
        Predicate<Integer> integerPredicateGtTen = (input) -> (input > 10);
        Predicate<Integer> integerPredicateLtTwenty = (input) -> (input < 20);
        System.out.println("16 is GT 10 and LT 20 = "+integerPredicateGtTen.and(integerPredicateLtTwenty).test(16));
        logTimeFinish(watch);
    }
    private static void predicateAsArgument(){
        logTimeStart(watch);
        logCurrentPosition(Thread.currentThread().getStackTrace());
        Predicate<Integer> integerPredicateGtTen = (input) -> (input > 10);
        System.out.println("11 is GT 10 = "+methodWithPredicate(11, integerPredicateGtTen));
        logTimeFinish(watch);
    }
    private static boolean methodWithPredicate(int number, Predicate<Integer> integerPredicate){
        logCurrentPosition(Thread.currentThread().getStackTrace());
        return integerPredicate.test(number);
    }
}
