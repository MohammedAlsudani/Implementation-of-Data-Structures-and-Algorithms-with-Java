package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstRecurringChart {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 8, 6, 5, 9, 9, 6};
        System.out.println(findFirstRecurringChartNested(array));
    }

    private static int findFirstRecurringChartNested(int[] array) {
        // find the number by Nested, which by going throw the loop twice and check if this number is exist or not
        int length = array.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if (array[i]== array[j]){
                    return array[i];
                }
            }
        }
        return -1;
    }

    private static int findFirstRecurringChart(int[] array) {
        // first we can go throw the list and store the values in a hashtable
        // and whenever we find the values again then this is the first repeated item
        Set<Integer> keys = new HashSet<>();
        for (int j : array) {
            if (keys.contains(j)) {
                return j;
            }
            keys.add(j);
        }
        return -1;
    }


}
