package SortAlgo;

public class InsertionSort {

    public static void main(String[] args) {

        int[] array = {20,5,-17,-1,66,33};

        insertionSort(array,array.length);

//        for (int firstUnSortedIndex = 1 ; firstUnSortedIndex < array.length ;firstUnSortedIndex++){
//            int newElement = array[firstUnSortedIndex];
//
//            int i;
//
//            for (i = firstUnSortedIndex; i > 0 && array[i-1] > newElement ; i--){
//                array[i] = array[i-1];
//            }
//
//            array[i] = newElement;
//        }

        for (int j : array) {
            System.out.println("array = " + j);
        }
    }

    public static void insertionSort(int[] input, int numItems) {

        if (numItems < 2) {
            return;
        }

        insertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;

        System.out.println("Result of call when numItems = " + numItems);
        for (i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("---------------------");


    }

}