package SortAlgo;

public class mergeSort {



    public static void main(String[] args) {

        int[] array = {20,5,-17,-1,66,33};

        mergeSort(array, 0 ,array.length);

        for (int j : array) {
            System.out.println("array = " + j);
        }
    }

    public static void mergeSort(int[] input, int start, int end){

        if (end - start < 2){
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input,start,mid);
        mergeSort(input,mid,end);
        mergeDes(input,start,mid,end);
    }

    public static void merge(int[] input, int start, int mid, int end){

        if (input[mid - 1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] tempArray = new int[end - start] ;

        while (i < mid && j < end ){
            if (input[i] <= input[j]){
                tempArray[tempIndex++] = input[i++];
            }else {
                tempArray[tempIndex++] = input[j++];
            }
        }

//        while (i < mid && j < end ){
//            tempArray[tempIndex++] = input[i] <= input[j]? input[i++] : input[j++];
//        }
        System.arraycopy(input,i,input,start + tempIndex,mid - i);
        System.arraycopy(tempArray , 0, input ,start , tempIndex);

    }

    public static void mergeDes(int[] input, int start, int mid, int end){

        if (input[mid - 1] >= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] tempArray = new int[end - start] ;

        while (i < mid && j < end ){
            if (input[i] >= input[j]){
                tempArray[tempIndex++] = input[i++];
            }else {
                tempArray[tempIndex++] = input[j++];
            }
        }

//        while (i < mid && j < end ){
//            tempArray[tempIndex++] = input[i] <= input[j]? input[i++] : input[j++];
//        }
        System.arraycopy(input,i,input,start + tempIndex,mid - i);
        System.arraycopy(tempArray , 0, input ,start , tempIndex);

    }

}