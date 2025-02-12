package org.example.dailyChallenges.model;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfAPairWithEqualSumOfDigits {
    public int maximumSum(int[] nums) {
        int maxSum = -1;
        //key = sum of the digit/number, value = digit/number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = 0, temp = num;
            while (temp > 0) {
                key += temp % 10;
                temp /= 10;
            }
            if (!map.containsKey(key)) {
                map.put(key, num);
            } else {
                int pair = map.get(key);
                maxSum = Math.max(maxSum, pair + num);
                if (num > pair)
                    map.put(key, num);
            }
        }
        return maxSum;
    }


}
