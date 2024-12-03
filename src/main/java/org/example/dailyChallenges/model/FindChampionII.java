package org.example.dailyChallenges.model;

public class FindChampionII {
    public int findChampion(int n, int[][] nums) {
        int[] inDegree = new int[n];

        for (int[] edges : nums) {
            inDegree[edges[1]]++;
        }

        int ans = -1, counter = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                ans = i;
                counter++;
            }
        }

        if (counter == 1) {
            return ans;
        }
        return -1;
    }
}
