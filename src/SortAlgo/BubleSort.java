package SortAlgo;



public class BubleSort {


    public static void main(String[] args) {

        int[] array = {20,5,-17,-1,66,33};

        for (int lastUnSortedIndex = array.length -1; lastUnSortedIndex > 0 ;lastUnSortedIndex--){
            for (int i = 0; i < lastUnSortedIndex; i++){
                if (array[i]> array[i+1]){
                    swipe(array,i,i+1);
                }
            }
        }

        for (int j : array) {
            System.out.println("array = " + j);
        }

    }

    public static void swipe(int[] array, int i , int j) {
        if (i==j){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}