package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoogleInterviewExercise {


    public static void main(String[] args) {
        // an array of number, that are sorted, the outputs are all right integers
        int[] array = new int[]{1,2,3,4};
        // main sum value
        int sum = 8;
        // creating method that going to return true
        // if the array contains the sum otherwise will return false
        System.out.println(hasPairWithSum(array,sum));
    }

    private static boolean hasPairWithSum(int[] array, int sum) {
        // loop throw the array and check for pairs if they are equal the sum or not
        int length = array.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1 ; j <  length ; j++) {
                if ((array[i]+ array[j]) == sum) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean hasPairWithSum2(int[] array, int sum) {
        // use a hash set to keep track of the elements seen so far
        Set<Integer> set = new HashSet<Integer>();
        // loop through the array and check for pairs if they are equal the sum or not
        for (int j : array) {
            int complement = sum - j;
            if (set.contains(complement)) {
                return true;
            }
            set.add(j);
        }
        return false;
    }

    private static boolean hasPairWithSum3(int[] array, int sum) {
        // Sort the array
        Arrays.sort(array);
        // loop through the array and check for pairs if they are equal the sum or not
        int length = array.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];
            if (currentSum == sum) {
                return true;
            } else if (currentSum < sum) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
