package org.example.leetCodeProblems.model;

public class TrappingRainWater {
    public int solve(int[] nums) {
        int n = nums.length, sum = 0, left = 0, right = n - 1, maxLeft = nums[left], maxRight = nums[right];

        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, nums[left]);
                sum += maxLeft - nums[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, nums[right]);
                sum += maxRight - nums[right];
            }
        }
        return sum;
    }
}
