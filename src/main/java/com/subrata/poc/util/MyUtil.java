package com.subrata.poc.util;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

public class MyUtil {
    public static void logCurrentPosition(StackTraceElement[] stackTraceElements){
        System.out.println(String.format("Line %s:%s:%s",stackTraceElements[1].getLineNumber(),stackTraceElements[1].getClassName(),stackTraceElements[1].getMethodName()));
    }
    public static void printJavaVersion(){
        System.out.println("Program is running on Java version -"+System.getProperty("java.version"));
    }
    public static void logTimeStart(StopWatch watch){
        watch.reset();
        watch.start();
    }
    public static void logTimeFinish(StopWatch watch){
        watch.stop();
        System.out.println("Time Taken (nano sec): " + watch.getTime(TimeUnit.NANOSECONDS)+" (milli sec):"+watch.getTime(TimeUnit.MILLISECONDS));
    }
}
