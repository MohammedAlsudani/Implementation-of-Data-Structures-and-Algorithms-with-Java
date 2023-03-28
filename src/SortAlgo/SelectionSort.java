package SortAlgo;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {20,5,-17,-1,66,33};

        for (int lastUnSortedIndex = array.length -1; lastUnSortedIndex > 0; lastUnSortedIndex--){
            int Largest = 0;
            for (int i = 1; i<= lastUnSortedIndex; i++) {
                if (array[i] > array[Largest]){
                    Largest = i;
                }
            }
            swape(array,Largest, lastUnSortedIndex);
        }

        for (int j : array) {
            System.out.println("array = " + j);
        }
    }

    public static void swape(int[] array, int i , int j) {
        if (i==j){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}