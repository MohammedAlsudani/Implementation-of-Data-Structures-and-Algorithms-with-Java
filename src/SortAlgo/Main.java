package SortAlgo;

import java.util.Arrays;
import java.util.Iterator;

public class Main {


    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,55,44,8,9,78,2};
        String[] strings = new String[]{"a","c","z","f","b"};

        Arrays.sort(array);
        Arrays.sort(strings);
        for (int num : array){
            System.out.println(num);
        }

        for (int i = 0; i < strings.length; i++){
            System.out.println(strings[i]);
        }

        Iterator<String> iterator = Arrays.stream(strings).iterator();
        while (iterator.hasNext()){
            System.out.println("next = "+ iterator.next());
        }
    }
}
