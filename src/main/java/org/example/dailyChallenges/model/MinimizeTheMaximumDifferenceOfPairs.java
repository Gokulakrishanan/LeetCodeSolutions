package org.example.dailyChallenges.model;

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceOfPairs {
    public int minMaxDifference(int[] nums, int p) {
        /*if (p == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2, count = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    count++;
                    i++;
                }
            }
            if (count >= p) right = mid;
            else left = mid + 1;
        }
        return left;*/

        if (p == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            right = Math.max(right, nums[i] - nums[i - 1]);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!isPossible(nums, mid, p)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isPossible(int[] nums, int mid, int p) {
        int i = 1, n = nums.length;
        while (i < n && p > 0) {
            if (nums[i] - nums[i - 1] <= mid) {
                i += 2;
                p--;
            } else {
                i++;
            }
        }
        return p == 0;
    }
}
