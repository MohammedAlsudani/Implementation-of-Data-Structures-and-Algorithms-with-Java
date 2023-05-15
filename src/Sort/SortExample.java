package Sort;

import java.util.*;

public class SortExample {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,55,44,8,9,78,2};
        String[] strings = new String[]{"a","c","z","f","b"};
        Arrays.sort(array);
        Arrays.sort(strings);
        for (int num : array){
            System.out.println(num);
        }


        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(9);

        // Sort the list in ascending order
        Collections.sort(numbers);

        // Print the sorted list
        System.out.println("numbers = "+ numbers);
        // Sort the list in descending order
        numbers.sort(Collections.reverseOrder());

        // Print the sorted list
        System.out.println("numbers descending order = "+ numbers);

        // Sort the list based on age using custom Comparator
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
    }
}
