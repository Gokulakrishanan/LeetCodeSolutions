package org.example.dailyChallenges.model;

public class CountSubarraysOfLengthThreeWithACondition {
    public int countSubarrays(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 0; i + 2 < n; i++) {
            if (2 * (nums[i] + nums[i + 2]) == nums[i + 1]) count++;
        }
        return count;
    }
}
