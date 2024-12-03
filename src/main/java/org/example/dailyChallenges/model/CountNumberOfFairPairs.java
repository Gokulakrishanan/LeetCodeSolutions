package org.example.dailyChallenges.model;

import java.util.Arrays;

public class CountNumberOfFairPairs {
    private long binarySearch(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }

        }
        return result;
    }

    private long twoPointers(int[] nums, int target) {
        long result = 0;
        int end = nums.length - 1;
        for (int start = 0; start < end; start++) {
            while (start < end && nums[start] + nums[end] > target) {
                end--;
            }
            result += end - start;
        }
        return result;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return twoPointers(nums, upper) - twoPointers(nums, lower - 1);
    }
}
