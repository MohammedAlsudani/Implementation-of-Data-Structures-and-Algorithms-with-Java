package common;

public class CountSpecialIntegers2 {

    /**
     * Example usage: Count the number of special integers between 1 and 20
     */
    public static void main(String[] args) {
        int n = 8087006;
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
        int[] digits = getDigits(n); // Get an array of the digits of n
        return countSpecialIntegersHelper(0, digits, new boolean[10], true); // Start with an empty prefix and all digits available
    }

    /**
     * Recursively counts the number of special integers with the given prefix and available digits.
     *
     * @param index the index of the current digit in the prefix
     * @param digits an array of the digits of n
     * @param used an array indicating which digits are already used in the prefix
     * @param isLeading whether the prefix can contain leading zeros
     * @return the number of special integers with the given prefix and available digits
     */
    public static int countSpecialIntegersHelper(int index, int[] digits, boolean[] used, boolean isLeading) {
        if (index == digits.length) { // If the prefix has the same number of digits as n, it is a valid special integer
            return 1; // Return 1 to count it
        }
        int count = 0;
        for (int i = isLeading ? 1 : 0; i <= 9; i++) { // Iterate over all possible digits
            if (!used[i]) { // If the digit is not already used
                boolean newIsLeading = isLeading && i == 0; // Update the isLeading flag if necessary
                if (i < digits[index] || newIsLeading) { // If the current prefix is smaller than n, continue generating special integers
                    used[i] = true; // Mark the digit as used
                    count += countSpecialIntegersHelper(index + 1, digits, used, newIsLeading); // Recursively count special integers with the updated prefix
                    used[i] = false; // Unmark the digit as used
                }
            }
        }
        return count; // Return the total count of special integers with the given prefix
    }

    /**
     * Returns an array of the digits of a positive integer in reverse order.
     *
     * @param num the positive integer to get the digits of
     * @return an array of the digits of the positive integer in reverse order
     */
    public static int[] getDigits(int num) {
        int[] digits = new int[Integer.toString(num).length()];
        int index = 0;
        while (num > 0) {
            digits[index] = num % 10;
            num /= 10;
            index++;
        }
        return digits;
    }

}
