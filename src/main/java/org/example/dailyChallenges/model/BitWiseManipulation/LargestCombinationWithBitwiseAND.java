package org.example.dailyChallenges.model.BitWiseManipulation;

public class LargestCombinationWithBitwiseAND {
    public int largestCombination(int[] candidates) {
        int result = 0;
        for (int i = 0; i < 24; i++) {
            int count = 0;
            for (int num : candidates) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        return result;

    }
}
