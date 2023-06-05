package Recursion;

import java.util.ArrayList;

public class Fibonacci {

    public static void main(String[] args) {

        int testNumber = 1;
        System.out.println(findFibonacciRecursive(testNumber));
        System.out.println(findFibonacciIterative(testNumber));
    }

    private static Integer findFibonacciIterative(int value) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0);
        array.add(1);
        for (int i = 2; i < value + 1 ;i++){
            array.add(array.get(i-2) + array.get(i-1));
        }
        return array.get(value);
    }

    private static int findFibonacciRecursive(int value) {
        if (value < 2){
            return value;
        }
        return findFibonacciRecursive(value - 1) + findFibonacciRecursive(value - 2);
    }

}
