package Recursion;

public class findFactorial {

    public static void main(String[] args) {
        int testNumber = 5;
        System.out.println("findFactorialIterative = "+ findFactorialIterative(testNumber));
        System.out.println("factorial = "+ findFactorialRecursively(testNumber));
    }

    public static int findFactorialIterative(int number) {
        if (number <= 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        }
        int factorial = 1;
        for (int i = number; i >= 1; i--) {
            factorial *= i;
        }
        return factorial;
    }

    public static int findFactorialIterative2(int number) {
        if (number == 2){
            return 2;
        }
        int answer = 1;
        for (int i = 2; i <= number; i++) {
            answer = answer * i;
        }
        return answer;
    }

    public static int findFactorialRecursively(int number) {
        if (number == 1){
            return 1;
        }
        return number * findFactorialRecursively(number-1);
    }
}
