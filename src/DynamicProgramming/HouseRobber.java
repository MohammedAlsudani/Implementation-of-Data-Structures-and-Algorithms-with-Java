package DynamicProgramming;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int maxAmount = rob(nums);
        System.out.println("Maximum amount of money that can be robbed: " + maxAmount);
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[0] = 0; // Base case: no houses to rob
        dp[1] = nums[0]; // Rob the first house

        for (int i = 2; i <= n; i++) {
            // Choose between robbing the current house or skipping it
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[n];
    }
}