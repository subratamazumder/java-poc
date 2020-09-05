package com.subrata.poc.functional;
import java.util.stream.IntStream;

public final class MyFunction {
    private MyFunction() {
    }
    public static void main(String[] args) {
        System.out.println("Hello Function!");
        System.out.println("input 1 :" + isPrime(1));
        System.out.println("input 2 :" + isPrime(2));
        System.out.println("input 3 :" + isPrime(4));
        System.out.println("input 123 :" + isPrime(1236777777));
    }

    private static boolean isPrime(final int input) {
        return input > 1 && IntStream.range(2, input).noneMatch(eachItem -> eachItem % input == 0);
    }
}
