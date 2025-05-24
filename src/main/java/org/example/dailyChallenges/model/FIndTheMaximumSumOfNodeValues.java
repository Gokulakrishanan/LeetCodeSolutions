package org.example.dailyChallenges.model;

public class FIndTheMaximumSumOfNodeValues {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long[] dp = {0, Long.MIN_VALUE};
        for (int num : nums) {
            long count0 = dp[0] + num, count1 = dp[1] + num;
            int xorValue = num ^ k;
            dp = new long[]{
                    Math.max(count0, dp[1] + xorValue), Math.max(count1, dp[0] + xorValue)
            };

        }

        return dp[0];
    }
}
