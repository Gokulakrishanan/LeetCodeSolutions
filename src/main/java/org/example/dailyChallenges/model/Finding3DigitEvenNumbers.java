package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.List;

public class Finding3DigitEvenNumbers {
    public int[] findEvenNumbers(int[] nums) {
        int[] map = new int[10];
        //updating the count of digits in the map
        for (int i : nums) {
            map[i]++;
        }
        List<Integer> result = new ArrayList<>();
        //iter from ith element (i*100+j*10+k*1)
        for (int i = 1; i <= 9; i++) {
            if (map[i] == 0) {
                continue;
            }
            map[i]--;
            for (int j = 0; j <= 9; j++) {
                if (map[j] == 0) continue;
                map[j]--;
                for (int k = 0; k <= 8; k += 2) {
                    if (map[k] == 0) continue;
                    map[k]--;
                    result.add(i * 100 + j * 10 + k);
                    map[k]++;
                }
                map[j]++;
            }
            map[i]++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
