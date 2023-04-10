package practice;

public class maxSubArray {

    public static void main(String[] args) {
        int[] array4 = new int[]{3,3,2,7,11,15,3,2,4};

        System.out.println(maxSubArray(array4));
    }

    public static int maxSubArray(int[] nums) {
        // Initialize the maximum sum and current sum to the smallest possible integer value
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];// Add the current element to the current sum
            if (currentSum > maxSum) {// If current sum is greater than the maximum sum, update the maximum sum
                maxSum = currentSum;
            }
            if (currentSum < 0) {// If current sum becomes negative, reset it to 0
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
