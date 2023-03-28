package common;

import java.util.HashSet;
import java.util.Set;

public class CountSpecialIntegers {

    /**
     * Example usage: Count the number of special integers between 1 and 20
     */
    public static void main(String[] args) {
        int n = 20;
        int specialCount = countSpecialIntegers(n);
        System.out.println("There are " + specialCount + " special integers between 1 and " + n);
    }

    /**
     * Counts the number of special integers in the range [1, n].
     * A positive integer is special if all of its digits are distinct.
     *
     * @param n the upper bound of the range to consider
     * @return the number of special integers in the range [1, n]
     */
    public static int countSpecialIntegers(int n) {
        int count = 0; // Initialize a counter variable
        for (int i = 1; i <= n; i++) { // Iterate over each integer in the range [1, n]
            if (isSpecial(i)) { // If the integer is special
                count++; // Increment the counter
            }
        }
        return count; // Return the final count of special integers
    }

    /**
     * Checks if a positive integer has distinct digits.
     * Returns true if all digits in the integer are distinct, false otherwise.
     *
     * @param num the integer to check
     * @return true if all digits in the integer are distinct, false otherwise
     */
    public static boolean isSpecial(int num) {
        Set<Integer> digits = new HashSet<>(); // Create a HashSet to store the digits
        while (num > 0) { // Iterate over the digits in the integer
            int digit = num % 10; // Get the rightmost digit
            if (digits.contains(digit)) { // If the digit is already in the set, it is not distinct
                return false; // Return false
            }
            digits.add(digit); // Otherwise, add the digit to the set
            num /= 10; // Move on to the next digit
            System.out.println(" digit = " + digit + " num == "+ num);
        }
        return true; // If all digits are distinct, return true
    }


}
