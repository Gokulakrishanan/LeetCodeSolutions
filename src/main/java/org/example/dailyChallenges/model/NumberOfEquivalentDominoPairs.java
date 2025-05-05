package org.example.dailyChallenges.model;

public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100];
        for (int[] dominoe : dominoes) {
            if (dominoe[0] > dominoe[1]) {
                map[dominoe[0] * 10 + dominoe[1]]++;
            } else {
                map[dominoe[1] * 10 + dominoe[0]]++;
            }
        }
        int count = 0;
        for (int value : map) {
            count += value * (value - 1) / 2;
        }
        return count;
    }

    //optimised dynamic programming
    public int numEquivDominoes(int[][] dominoes) {
        int[][] dp = new int[10][10];
        for (int[] dominoe : dominoes) {
            dp[dominoe[0]][dominoe[1]]++;
        }

        int maxCount = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j < dp[i].length; j++) {
                int occurence = dp[i][j];
                if (i != j) {
                    occurence += dp[j][i];
                }
                maxCount += occurence * (occurence - 1) / 2;
            }
        }
        return maxCount;
    }
}
