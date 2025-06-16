package org.example.dailyChallenges.model;

public class MaximumDifferenceBetweenIncreasingElements {
    public int maxDifference(int[] nums) {
        int max = 0, i = 0, n = nums.length;
        for (int j = 1; j < n; j++) {
            if (j > i && nums[j] > nums[i]) {
                max = Math.max(max, nums[j] - nums[i]);
            } else {
                i = j;
            }
        }


        if (max == 0) {
            return -1;
        }
        return max;
    }
}
