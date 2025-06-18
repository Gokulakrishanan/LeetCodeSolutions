package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] maxDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i += 3) {
            int a = nums[i], b = nums[i + 1], c = nums[i + 2];
            if (c - a > k) {
                return new int[][]{};
            }
            list.add(new int[]{a, b, c});
        }
        return list.toArray(new int[list.size()][]);
    }
}
