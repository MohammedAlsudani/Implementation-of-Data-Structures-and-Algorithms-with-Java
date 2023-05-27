package SortAlgo;

public class ShellSort {

    public static void main(String[] args) {
        int[] array = {20,5,-17,-1,66,33};
        for (int gap = array.length/2; gap > 0 ; gap /=2) {
            for (int i = gap ; i < array.length ; i++) {
                int newElement = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > newElement){
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
        for (int j : array) {
            System.out.println("array = " + j);
        }

    }
}