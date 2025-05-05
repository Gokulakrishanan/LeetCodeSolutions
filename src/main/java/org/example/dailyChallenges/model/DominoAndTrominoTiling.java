package org.example.dailyChallenges.model;

public class DominoAndTrominoTiling {

    public int numTilings(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i < n; i++) {

            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
        }
        return dp[n];
    }
}
