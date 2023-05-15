package Sort;


public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {20, 5, -17, -1, 66, 33};

        for (int lastUnSortedIndex = array.length - 1; lastUnSortedIndex > 0; lastUnSortedIndex--) {
            for (int i = 0; i < lastUnSortedIndex; i++) {
                if (array[i] > array[i + 1]) {
                    Swipe(array, i, i + 1);
                }
            }
        }

        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-1; j++){
                if (array[j] > array[j + 1]) {
                    Swipe(array, j, j + 1);
                }
            }
        }
        for (int num: array){
            System.out.println(num);
        }
    }

    public static void Swipe(int[] list, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
