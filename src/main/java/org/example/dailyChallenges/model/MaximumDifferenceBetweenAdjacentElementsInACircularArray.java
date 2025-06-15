package org.example.dailyChallenges.model;

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    public int maxDifference(int[] nums) {
        int n = nums.length;
        //For circular Array
        int max = Math.abs(nums[n - 1] - nums[0]);
        for (int i = 0; i < n - 1; i++) {
            //iterating through the array O(n)
            max = Math.max(max, Math.abs(nums[i + 1] - nums[i]));
        }
        return max;
    }
}
