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
            if (map.containsKey(j)){
                result.put(j, result.getOrDefault(j,1)+1);
            }
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
            if (set.contains(complement)) {
                return true;
            }
            set.add(j);
        }
        return false;
    }


    public static Map<Integer, Integer> pairListEqualsTarget(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result.put(nums[complement], i);
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complimnt =  target - nums[i] ;
            if (map.containsKey(complimnt)) {
                return new int[]{map.get(complimnt), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    public int[] twoSumNestedLoop(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
