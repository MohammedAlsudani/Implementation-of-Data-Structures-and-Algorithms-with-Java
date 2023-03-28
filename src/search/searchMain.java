package search;

public class searchMain {

    public static void main(String[] args) {
        int[] inputArray = {-22,-14,1,7,20,35,55,56,57,58,59,60,61,62};

        System.out.println(linearSearchAlgorithm(inputArray,-14));
        System.out.println(linearSearchAlgorithm(inputArray,-22));
        System.out.println(linearSearchAlgorithm(inputArray,20));
        System.out.println(iterativeBinarySearch(inputArray,55));
        System.out.println(recursiveBinarySearch(inputArray,20));
        System.out.println(recursiveBinarySearch(inputArray,55));
        int[] arr = {1, 3, 5, 7, 9};
        int index = recursiveBinarySearch(arr, 0, arr.length-1, 10);
        System.out.println(recursiveBinarySearch(arr,5));
    }

    private static int linearSearchAlgorithm(int[] inputArray, int value) {
        for (int i = 0; i < inputArray.length; i++){
            if (inputArray[i]==value){
                return i;
            }
        }
        return -1;
    }

    public static int iterativeBinarySearch(int[] inputArray, int value) {
        int start = 0;
        int end = inputArray.length;

        while (start < end) {
            int midPoint = (start+end) / 2 ;
            if (inputArray[midPoint] == value) {
                return midPoint;
            } else if (inputArray[midPoint] < value) {
                start = midPoint + 1;
            } else {
                end = midPoint;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] inputArray, int value) {
        return recursiveBinarySearch(inputArray, 0, inputArray.length,value);
    }

    private static int recursiveBinarySearch(int[] inputArray, int start, int end, int value) {
        if (start >= end){
            return -1;
        }
        int midPoint = (start+end) / 2 ;
        if (inputArray[midPoint] == value) {
            return midPoint;
        } else if (inputArray[midPoint] < value) {
           return recursiveBinarySearch(inputArray,midPoint + 1,end,value);
        } else {
           return recursiveBinarySearch(inputArray,start,midPoint,value);
        }
    }

}
