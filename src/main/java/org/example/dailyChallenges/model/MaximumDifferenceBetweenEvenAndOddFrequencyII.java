package org.example.dailyChallenges.model;

import java.util.Arrays;

public class MaximumDifferenceBetweenEvenAndOddFrequencyII {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        for (int a = 0; a <= 4; ++a) {
            for (int b = 0; b <= 4; ++b) {
                if (a == b) {
                    continue;
                }
                int[] countA = new int[n + 1], countB = new int[n + 1];
                for (int i = 1; i <= n; ++i) {
                    //s= 11233
                    countA[i] = countA[i - 1] + (s.charAt(i - 1) - '0' == a ? 1 : 0); // 11
                    countB[i] = countB[i - 1] + (s.charAt(i - 1) - '0' == b ? 1 : 0);
                }
                //initialising dp
                int[][] parity = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    Arrays.fill(parity[i], Integer.MIN_VALUE);
                }

                int j = 0;

                for (int i = k; i <= n; i++) {
                    while (i - j >= k && countA[i] > countA[j] && countB[i] > countB[j]) {
                        int parityA = countA[j] % 2;
                        int parityB = countB[j] % 2;
                        parity[parityA][parityB] = Math.max(parity[parityA][parityB], countB[j] - countA[j]);
                        j++;
                    }
                    //pA = parityOfA, pB = parityOfB
                    int pA = countA[i] % 2;
                    int pB = countB[i] % 2;
                    int best = parity[1 - pA][pB];
                    if (best != Integer.MIN_VALUE) {
                        ans = Math.max(ans, (countA[i] - countB[i]) + best);
                    }
                }
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
