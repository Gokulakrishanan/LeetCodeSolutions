package org.example.dailyChallenges.model.BitWiseManipulation;

public class MaximumXOR {
    public int[] solve(int[] nums, int maximumBit) {
        int n = nums.length;
        int k = (int) Math.pow(2, maximumBit) - 1;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            k ^= nums[i];
            result[n - 1 - i] = k;
        }

        return result;
    }
}
