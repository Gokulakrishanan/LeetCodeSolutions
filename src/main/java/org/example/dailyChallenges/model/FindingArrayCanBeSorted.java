package org.example.dailyChallenges.model;

import java.util.Arrays;

public class FindingArrayCanBeSorted {
    public boolean canSortArray(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1] && Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {
                    swap(nums, j, j + 1);
                }
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }


    public boolean canSortArray1(int[] values) {
        int len = values.length;
        int[] nums = Arrays.copyOf(values, len);
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            } else {
                if (Integer.bitCount(nums[i]) == Integer.bitCount(nums[i + 1])) {
                    swap(nums, i, i + 1);
                } else {
                    return false;
                }
            }
        }

        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            } else {
                if (Integer.bitCount(nums[i]) == Integer.bitCount(nums[i - 1])) {
                    swap(nums, i, i - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
