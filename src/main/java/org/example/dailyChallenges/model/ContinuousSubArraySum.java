package org.example.dailyChallenges.model;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {
    public boolean checkSubArraySolve(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int remainder = (sum + nums[i]) % k;
            if (remainder < 0) remainder += k;

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) > 1) return true;
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
