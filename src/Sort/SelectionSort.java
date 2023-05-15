package Sort;


public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {20, 5, -17, -1, 66, 33};
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            int temp = array[i];
           for (int j = i+1; j < length; j++){
               if (array[j] < array[min]) {
                   min = j;
               }
           }
           Swipe(array,min,i);
        }

        for (int num: array){
            System.out.println(num);
        }
    }

    public static void Swipe(int[] list, int j, int i) {
        int temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }
}
