package org.example.dailyChallenges.model;

public class MinNumberOfOpsToMoveBallsToEachBox {
    public int[] minOperations(String boxes) {
        int n = boxes.length(), prefixSum = 0, prefixCount = 0, suffixSum = 0, suffixCount = 0;
        int[] result = new int[n];

        //left to right
        for (int i = 0; i < n; i++) {
            result[i] = prefixCount * i - prefixSum;
            if (boxes.charAt(i) == '1') {
                prefixCount++;
                prefixSum += i;
            }
        }

        //right to left
        for (int i = n - 1; i >= 0; i--) {
            result[i] += suffixSum - suffixCount * i;
            if (boxes.charAt(i) == '1') {
                suffixCount++;
                suffixSum += i;
            }
        }

        return result;
    }
}
