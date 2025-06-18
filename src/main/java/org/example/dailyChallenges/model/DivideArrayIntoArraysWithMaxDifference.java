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

    public int[][] maxDiff(int[] nums, int k) {
        int max = Integer.MIN_VALUE, n = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        int[][] result = new int[n / 3][3];
        int row = 0, col = 0;
        for (int i = 0; i < max + 1; i++) {
            if (count[i] > 0) {
                while (count[i] > 0) {
                    result[row][col++] = i;
                    if (col == 3) {
                        if (Math.abs(result[row][0] - result[row][2]) > k) {
                            return new int[0][];
                        }
                    }
                    count[i]--;
                }
            }
        }
        return result;
    }
}
