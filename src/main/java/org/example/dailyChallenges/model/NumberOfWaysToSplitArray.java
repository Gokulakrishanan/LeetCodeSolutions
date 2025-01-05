package org.example.dailyChallenges.model;

public class NumberOfWaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        long sum = 0, prefSum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            prefSum += nums[i];

            if (prefSum >= (sum - prefSum)) {
                ans++;
            }
        }

        return ans;
    }
}
