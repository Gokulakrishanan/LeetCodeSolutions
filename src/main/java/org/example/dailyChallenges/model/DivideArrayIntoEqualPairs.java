package org.example.dailyChallenges.model;

import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer i : map.keySet()) {
            if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
