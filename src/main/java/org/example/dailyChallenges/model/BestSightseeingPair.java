package org.example.dailyChallenges.model;

public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE;
        int greedyValue = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] - i + greedyValue > ans) {
                ans = values[i] - i + greedyValue;
            }

            if (values[i] + i > greedyValue) {
                greedyValue = values[i] + i;
            }

        }


        return ans;
    }
}
