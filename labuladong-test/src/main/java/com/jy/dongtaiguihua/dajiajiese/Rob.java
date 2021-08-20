package com.jy.dongtaiguihua.dajiajiese;

public class Rob {
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[nums.length - 1];
    }

    private static int robRange(int[] nums, int start, int end) {
        int dp_2 = 0;
        int dp_1 = 0;
        for (int i = start; i < end; i++) {
            if (i == 0) {
                dp_1 = nums[i];
            } else if (i == 1) {
                int dp = dp_1;
                dp_1 = Math.max(dp_1, nums[1]);
                dp_2 = dp;
            } else {
                int dp = dp_1;
                dp_1 = Math.max(dp_1, dp_2 + nums[i]);
                dp_2 = dp;
            }
        }
        return dp_1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        int rob = rob(nums);
        System.out.println(rob);
    }
}
