package org.example.dailyChallenges.model;

public class MaximumAscendingSubArraySum {
    public int maxSum(int[] nums) {
        int currentSum = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = nums[i] > nums[i - 1] ? currentSum + nums[i] : nums[i];
            ans = Math.max(currentSum, ans);
        }
        return ans;
    }

}
