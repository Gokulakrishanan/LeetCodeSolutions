package org.example.dailyChallenges.model;

import java.util.HashMap;

public class ContinuousSubArraySum {
    public boolean checkSubArraySolve(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if (remainderMap.containsKey(rem)) {
                if (i - remainderMap.get(rem) > 1) {
                    return true;
                }
            } else {
                remainderMap.put(rem, i);
            }
        }
        return true;
    }
}
