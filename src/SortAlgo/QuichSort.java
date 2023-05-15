package SortAlgo;


/**
 A class implementing the QuickSort algorithm to sort an array of integers in ascending order.
 */
public class QuichSort {

    public static void main(String[] args) {
        int[] array = {20,5,-17,-1,66,33};
        quickSort(array,0,array.length);

        for (int j : array) {
            System.out.println("array = " + j);
        }

    }

    public static void quickSort(int[] input ,int start, int end){
        if (end - start < 2){
            return;
        }
        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    private static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;
        while (i < j){
            // Note empty loop
            while (i < j &&input[--j] >= pivot);
            if ( i < j){
                input[i] = input[j];
            }
            // Note empty loop
            while (i < j && input[++i] <= pivot);
            if (i < j){
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }
}
