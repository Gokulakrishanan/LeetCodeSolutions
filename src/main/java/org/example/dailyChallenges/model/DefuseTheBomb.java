package org.example.dailyChallenges.model;

public class DefuseTheBomb {
    public int[] decrypt(int[] nums, int k) {
        if (k == 0) {
            return new int[nums.length];
        }
        int n = nums.length, left = 1, right = k, sum = 0;
        int[] result = new int[n];
        if (k < 0) {
            left = n - Math.abs(k);
            right = n - 1;
        }

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }


        for (int i = 0; i < n; i++) {
            result[i] = sum;
            sum -= nums[(left) % n];
            sum += nums[(right + 1) % n];
            left++;
            right++;
        }


        return result;
    }
}
