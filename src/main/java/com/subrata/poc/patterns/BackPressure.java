package com.subrata.poc.patterns;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import static com.subrata.poc.util.MyUtil.*;

/**
 * Template Class to work with various scenarios
 */
public final class BackPressure {
    private static StopWatch watch = new StopWatch();

    private BackPressure() {
    }

    public static void main(String[] args) {
        printJavaVersion();
        illustrateBackPressure();
    }

    private static void illustrateBackPressure() {
        logCurrentPosition(Thread.currentThread().getStackTrace());
        //Write your code here - start
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5, true);
        //produce to Q at rate of 1 per second
        new Thread(() -> {
            int i = 0;
            try {
                while (true) {
                    System.out.println("Queue - " + arrayBlockingQueue);
                    System.out.println("Producing " + i);
                    if(isQueueFull(arrayBlockingQueue)){
                        System.out.println("Q is full maintaining back pressure & waiting");
                    }
                    arrayBlockingQueue.put(i);
                    i++;
                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ).start();

        //consume from Q at rate of 2 sec
        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Consuming " + arrayBlockingQueue.take());
                    Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ).start();

        //Write your code here - finish
    }

    private static boolean isQueueFull(ArrayBlockingQueue arrayBlockingQueue) {
        return arrayBlockingQueue.remainingCapacity() == 0 ? true : false;
    }

    private static void pocScenarioB() {
        logCurrentPosition(Thread.currentThread().getStackTrace());
        logTimeStart(watch);
        //Write your code here - start

        //Write your code here - finish
        logTimeFinish(watch);
    }
}
