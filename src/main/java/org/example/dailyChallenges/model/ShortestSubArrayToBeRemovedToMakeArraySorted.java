package org.example.dailyChallenges.model;

public class ShortestSubArrayToBeRemovedToMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] nums) {
        int left = 0, n = nums.length, right = n - 1;

        while (left + 1 < n && nums[left] <= nums[left + 1]) {
            left++;
        }
        if (left == n - 1) {
            return 0;
        }

        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }
        int result = Math.min(right, n + left - 1);
        int i = 0, j = right;

        while (i <= left && j < n) {
            if (nums[i] <= nums[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
