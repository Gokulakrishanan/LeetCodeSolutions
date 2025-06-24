package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }
}
