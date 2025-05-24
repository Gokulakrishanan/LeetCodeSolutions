package org.example.dailyChallenges.model;

public class ZeroArrayTransformationI {
    //Difference Array Method
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0;
        int[] diff = new int[n + 1];
        for (int[] query : queries) {
            diff[query[0]]--;
            if (query[1] + 1 < n) diff[query[1] + 1]++;
        }
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (nums[i] > -sum) return false;
        }
        return true;
    }

    public boolean isZeroArrayBF(int[] nums, int[][] queries) {
        int n = nums.length;

        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j < queries[i][1]; j++) {
                if (nums[j] > 0) nums[j]--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) return false;
        }
        return true;
    }
}
