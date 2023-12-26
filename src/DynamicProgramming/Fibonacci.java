package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static int calculations = 0;

    public static void main(String[] args) {
        System.out.println("Slow: " + fibonacci(35));
        System.out.println("DP: " + fibonacciMaster(100));
        System.out.println("DP2: " + fibonacciMaster2(100));
        System.out.println("We did " + calculations + " calculations");
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciMaster(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return fib(n, cache);
    }

    private static int fib(int n, Map<Integer, Integer> cache) {
        calculations++;
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            if (n < 2) {
                return n;
            } else {
                int result = fib(n - 1, cache) + fib(n - 2, cache);
                cache.put(n, result);
                return result;
            }
        }
    }

    public static int fibonacciMaster2(int n) {
        int[] answer = new int[]{0, 1};
        for (int i = 2; i <= n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return answer[n];
    }
}