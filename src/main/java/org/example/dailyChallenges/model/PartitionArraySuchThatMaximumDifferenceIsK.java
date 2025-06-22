package org.example.dailyChallenges.model;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {
    public int maxDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, result = 1, min = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - min > k) {
                result++;
                min = nums[i];
            }
        }

        return result;
    }
}
