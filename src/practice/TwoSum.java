package practice;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] array1 = new int[]{2,7,11,15};
        int target1 = 9;
        int[] array2 = new int[]{3,2,4};
        int target2 = 6;
        int[] array3 = new int[]{3,3};
        int target3 = 6;

        int[] array4 = new int[]{3,3,2,7,11,15,3,2,4};
        int target4 = 6;

        System.out.println(Arrays.toString(twoSum(array1, target1)));
        System.out.println(Arrays.toString(twoSum(array2, target2)));
        System.out.println(Arrays.toString(twoSum(array3, target3)));

        System.out.println(pairListEqualsTarget(array4, target4));

        String s = "aaaa kkkk rrr tt yyyyyy";
        System.out.println(calculateTheMatchingCharts(s));
    }

    private static Map<Character, Integer> calculateTheMatchingCharts(String s) {
        char[] cha = s.trim().replace(" ","").toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> result = new HashMap<>();
        for (char j : cha){
            // check if the character is already in the map
            if (map.containsKey(j)){
                // if it is, increment its count in the result map
                result.put(j, result.getOrDefault(j,1)+1);
            }
            // add the character to the map with a count of 0
            map.put(j,0);
        }
        return result;
    }

    private static boolean twoSumWithSet(int[] array, int sum) {
        // use a hash set to keep track of the elements seen so far
        Set<Integer> set = new HashSet<Integer>();
        // loop through the array and check for pairs if they are equal the sum or not
        for (int j : array) {
            int complement = sum - j;
            // check if the complement of the current element has been seen before
            if (set.contains(complement)) {
                // if it has, we have found a pair that sums to the target
                return true;
            }
            // add the current element to the set
            set.add(j);
        }
        // no pair was found that sums to the target
        return false;
    }


    public static Map<Integer, Integer> pairListEqualsTarget(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // check if the complement of the current element has been seen before
            if (map.containsKey(complement)) {
                // if it has, we have found a pair that sums to the target
                result.put(nums[complement], i);
            }
            // add the current element to the map
            map.put(nums[i],i);
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int compliment =  target - nums[i] ;
            // check if the complement of the current element has been seen before
            if (map.containsKey(compliment)) {
                // if it has, we have found a pair that sums to the target
                return new int[]{map.get(compliment), i};
            }
            // add the current element to the map
            map.put(nums[i],i);
        }
        // no pair was found that sums to the target
        return new int[]{};
    }


    public int[] twoSumNestedLoop(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // check if the sum of the current pair is equal to the target
                if (nums[i] + nums[j] == target) {
                    // if it is, return the indices of the pair
                    return new int[] { i, j };
                }
            }
        }
        // no pair was found that sums to the target
        throw new IllegalArgumentException("No two sum solution");
    }
}
