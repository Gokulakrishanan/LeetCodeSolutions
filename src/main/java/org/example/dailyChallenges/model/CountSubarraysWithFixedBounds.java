package org.example.dailyChallenges.model;

public class CountSubarraysWithFixedBounds {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int start = -1, min = -1, max = -1, n = nums.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                start = min = max = i;
            } else {
                min = nums[i] == minK ? i : min;
                max = nums[i] == maxK ? i : max;
                count += Math.min(min, max) - start;
            }
        }
        return count;
    }
}
