package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeTwoArraysExercise {

    public static void main(String[] args) {
        int[] arr1={1, 2, 3, 4, 5, 6};  //first array
        int[] arr2={7, 8, 9, 0};    //second array
        int arr3[] = {0,1,5,2};

        System.out.println(mergeTowArrayWithLoop(arr1,arr2));    //prints the resultant array.
        System.out.println(mergeTowArrayWithArrayCopy(arr1,arr2));    //prints the resultant array.
        System.out.println(mergeTowArrayWithCollections(arr1,arr2));    //prints the resultant array.
    }

    private static String mergeTowArrayWithCollections(int[] arr1, int[] arr2) {
        List<int[]> result = new ArrayList<>(Collections.singletonList(arr1));
        result.addAll(Collections.singletonList(arr2));
        return Arrays.toString(result.toArray());
    }

    private static String mergeTowArrayWithLoop(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int pos = 0;
        for (int j : arr1) {
            result[pos] = j;
            pos++;
        }
        for (int j : arr2) {
            result[pos] = j;
            pos++;
        }
        return Arrays.toString(result);
    }

    private static String mergeTowArrayWithArrayCopy(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1,0, result,0,arr1.length);
        System.arraycopy(arr2,0, result, arr1.length, arr2.length);
        return Arrays.toString(result);
    }

}
