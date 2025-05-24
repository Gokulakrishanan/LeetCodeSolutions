package org.example.dailyChallenges.model;

import java.util.ArrayList;
import java.util.List;

public class PaintingAGridWithThreeDifferentColors {

    public int colorTheGrid(int m, int n) {
        final int mod = 1_000_000_007;
        int totalSolutions = 1;
        for (int i = 0; i < m; i++) {
            //three colours so X3
            totalSolutions *= 3;
        }

        //initialising the DP
        int[][] dp = new int[n + 1][totalSolutions];
        int[][] rowValid = new int[totalSolutions][totalSolutions];
        List<Integer> goodElement = new ArrayList<>();
        List<Integer>[] pattern = new ArrayList[totalSolutions];

        for (int i = 0; i < totalSolutions; i++) {
            pattern[i] = new ArrayList<>();
        }

        for (int i = 0; i < totalSolutions; i++) {
            int value = i, valid = i;
            for (int j = 0; j < m; j++) {
                pattern[i].add(value % 3);
                value /= 3;

            }
        }


        return 0;
    }

}
